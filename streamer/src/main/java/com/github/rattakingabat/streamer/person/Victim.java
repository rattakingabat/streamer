package com.github.rattakingabat.streamer.person;

import com.github.rattakingabat.streamer.person.stats.Stat;
import com.github.rattakingabat.streamer.person.stats.StatBag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Victim extends Person {

    private final String name;

    @Override
    StatBag initializeStatBag() {
        StatBag bag = new StatBag();
        bag.initStat(StatsType.SUFFOCATION, 0, 0, 10);
        bag.initStat(StatsType.ANGER, 0, 0, 10);
        bag.initStat(StatsType.AROUSAL, 0, 0, 10);
        bag.initStat(StatsType.ORGASM, 0, 0, 10);
        bag.initStat(StatsType.PAIN, 0, 0, 10);
        bag.initStat(StatsType.FEAR, 0, 0, 10);
        bag.initStat(StatsType.PANIC, 0, 0, 10);
        bag.initStat(StatsType.UNCONSCIOUSNESS, 0, 0, 10);
        return bag;
    }

    @Override
    public void calculateStatsConsequences() {
        
    }

    public Stat getSuffocation(){
        return statBag.getSuffocation();
    }


}
