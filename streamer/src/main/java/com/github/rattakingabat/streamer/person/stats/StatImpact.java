package com.github.rattakingabat.streamer.person.stats;

import com.github.rattakingabat.streamer.person.StatsType;
import lombok.Value;

public record StatImpact(Integer value, StatsType type) {
    public void impact(StatBag bag){
        Stat stat = bag.getStat(type);
        bag.changeStat(type, stat.change(value));
    }
}
