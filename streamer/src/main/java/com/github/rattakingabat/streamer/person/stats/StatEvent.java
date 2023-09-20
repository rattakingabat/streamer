package com.github.rattakingabat.streamer.person.stats;

import com.github.rattakingabat.streamer.person.Person;

import java.util.List;

public record StatEvent(StatEventType statEventType, List<StatImpact> impactList, Person person) {

    public void applyEvent(StatBag bag){
        impactList.forEach(si -> si.impact(bag));
    }

}
