package com.github.rattakingabat.streamer.person;

import com.github.rattakingabat.streamer.actor.Actor;
import com.github.rattakingabat.streamer.person.stats.Stat;
import com.github.rattakingabat.streamer.person.stats.StatBag;
import com.github.rattakingabat.streamer.person.stats.StatEvent;
import com.github.rattakingabat.streamer.stance.Stance;
import com.github.rattakingabat.streamer.stance.StanceTick;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Person implements Actor {

    protected final StatBag statBag = initializeStatBag();

    abstract StatBag initializeStatBag();

    private final Set<Stance<?, ?, ?>> receivedStances = new HashSet<>();
    private final Set<Stance<?, ?, ?>> givenStances = new HashSet<>();

    public Set<Stance<?, ?, ?>> getReceivedStances(){
        return new HashSet<>(receivedStances);
    }

    public Set<Stance<?, ?, ?>> getGivenStances(){
        return new HashSet<>(givenStances);
    }

    public void receiveStance(Stance<?, ?, ?> stance){
        if(stance.getReceiver() == this){
            receivedStances.add(stance);
        }
    }

    public void removeReceivedStance(Stance<?, ?, ?> stance){
        this.receivedStances.remove(stance);
    }

    public void giveStance(Stance<?, ?, ?> stance){
        if(stance.getOriginAction().originator() == this){
            givenStances.add(stance);
        }
    }

    public Stat getStat(StatsType type){
        return statBag.getStat(type);
    }

    public PersonTickEvent tick(Long tick){

        List<StanceTick<?>> receivedStancesTick = this.receivedStances
                                                      .stream()
                                                      .map(s -> s.tickEvents(tick))
                                                      .collect(Collectors.toList());

        List<StanceTick<?>> givenStancesTick = this.givenStances
                                                    .stream()
                                                    .map(s -> s.tickEvents(tick))
                                                    .collect(Collectors.toList());

        List<StatEvent> receivedStanceEvents = receivedStancesTick.stream()
                                                                   .map(StanceTick::statEvents)
                                                                   .flatMap(List::stream)
                                                                   .toList();
        List<StatEvent> givenStanceEvents = givenStancesTick.stream()
                                                            .map(StanceTick::statEvents)
                                                            .flatMap(List::stream)
                                                            .toList();

        receivedStanceEvents.forEach(e -> e.applyEvent(this.statBag));
        givenStanceEvents.forEach(e -> e.applyEvent(this.statBag));

        return new PersonTickEvent(this, tick, receivedStanceEvents, givenStanceEvents);
    }

    public abstract void calculateStatsConsequences();

}
