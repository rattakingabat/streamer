package com.github.rattakingabat.streamer.stance;

import com.github.rattakingabat.streamer.action.Facesits;
import com.github.rattakingabat.streamer.person.Girl;
import com.github.rattakingabat.streamer.person.Person;
import com.github.rattakingabat.streamer.person.Victim;

public abstract class Smothered extends ActiveStance<Girl, Facesits, Victim> {
    public Smothered(Girl originator, Facesits origin, Victim victim) {
        super(originator, origin, victim);
    }
}
