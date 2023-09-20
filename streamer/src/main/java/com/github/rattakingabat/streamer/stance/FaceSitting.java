package com.github.rattakingabat.streamer.stance;

import com.github.rattakingabat.streamer.action.Facesits;
import com.github.rattakingabat.streamer.person.Girl;
import com.github.rattakingabat.streamer.person.Victim;
import com.github.rattakingabat.streamer.person.stats.StatEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Increases arousal
 */
@Getter
public class FaceSitting extends ActiveStance<Girl, Facesits, Girl> {

    private final FaceSat faceSat;

    public FaceSitting(Girl originator, Facesits origin, Victim victim) {
        super(originator, origin, originator);
        this.faceSat = new FaceSat(originator, origin, victim);
    }

    @Override
    public StanceTick<Girl> tickEvents(Long tick) {
        return new StanceTick<>(tick, Collections.emptyList(), new HashSet<>());
    }
}
