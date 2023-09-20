package com.github.rattakingabat.streamer.person.stats;

import com.github.rattakingabat.streamer.person.StatsType;

import java.util.HashMap;

public class StatBag {

    private final HashMap<StatsType, StatPocket> map;

    public StatBag(){
        map = new HashMap<>();
    }

    public void initStat(StatsType type, Integer value, Integer minValue, Integer maxValue){
        map.put(type, new StatPocket(new Stat(value), type, minValue, maxValue));
    }

    public Stat getStat(StatsType type){
        return map.get(type).getStat();
    }

    public void changeStat(StatsType type, Stat value){
        StatPocket pocket = map.get(type).withValue(value);
        map.put(type, pocket);
    }

    public Stat getSuffocation(){
        return getStat(StatsType.SUFFOCATION);
    }

}
