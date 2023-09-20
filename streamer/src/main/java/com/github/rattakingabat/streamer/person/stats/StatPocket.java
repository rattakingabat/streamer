package com.github.rattakingabat.streamer.person.stats;

import com.github.rattakingabat.streamer.person.StatsType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class StatPocket {
    Stat stat;
    StatsType type;
    Integer minValue;
    Integer maxValue;

    public StatPocket withValue(Stat stat){
        if(stat.value()>maxValue){
            return this.toBuilder().stat(new Stat(maxValue)).build();
        }

        if(stat.value()<minValue){
            return this.toBuilder().stat(new Stat(minValue)).build();
        }

        return this.toBuilder().stat(stat).build();
    }

}
