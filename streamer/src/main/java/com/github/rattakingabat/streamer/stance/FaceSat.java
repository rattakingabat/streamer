package com.github.rattakingabat.streamer.stance;

import com.github.rattakingabat.streamer.action.Facesits;
import com.github.rattakingabat.streamer.person.Girl;
import com.github.rattakingabat.streamer.person.StatsType;
import com.github.rattakingabat.streamer.person.Victim;
import com.github.rattakingabat.streamer.person.stats.Stat;
import com.github.rattakingabat.streamer.person.stats.StatEvent;
import com.github.rattakingabat.streamer.person.stats.StatEventType;
import com.github.rattakingabat.streamer.person.stats.StatImpact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Increases arousal, inflicts suffocation
 */
public class FaceSat extends Smothered {

    public FaceSat(Girl originator, Facesits origin, Victim victim) {
        super(originator, origin, victim);
    }

    @Override
    public StanceTick<Victim> tickEvents(Long tick) {
        Stat suffocation = target.getSuffocation();
        if(!suffocation.greaterThan(10)){
            return null;
        }
        StatImpact suffocationImpact = new StatImpact(1, StatsType.SUFFOCATION);
        StatEvent event = new StatEvent(StatEventType.SMOTHER, Collections.singletonList(suffocationImpact), target);
        return new StanceTick<>(tick, Collections.singletonList(event), new HashSet<>());
    }


}
