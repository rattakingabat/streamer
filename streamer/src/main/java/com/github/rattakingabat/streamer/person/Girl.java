package com.github.rattakingabat.streamer.person;

import com.github.rattakingabat.streamer.person.stats.StatBag;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Girl extends Person{

    private final String name;

    @Override
    StatBag initializeStatBag() {
        StatBag bag = new StatBag();
        bag.initStat(StatsType.ANGER, 0, 0, 10);
        bag.initStat(StatsType.AROUSAL, 0, 0, 10);
        return bag;
    }

    @Override
    public void calculateStatsConsequences() {

    }
}
