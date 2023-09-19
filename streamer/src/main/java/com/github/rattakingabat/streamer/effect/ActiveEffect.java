package com.github.rattakingabat.streamer.effect;

import com.github.rattakingabat.streamer.action.Action;
import com.github.rattakingabat.streamer.actor.Person;

/**
 * Effect caused by an actor
 */
public abstract class ActiveEffect<ORIGIN_PERSON extends Person,
                          ORIGIN_ACTION extends Action<ORIGIN_PERSON, ? extends Person>,
                          TARGET extends Person> implements Effect<ORIGIN_PERSON, ORIGIN_ACTION, TARGET> {

    Person originator;
    ORIGIN_ACTION origin;
    TARGET target;


    @Override
    public ORIGIN_ACTION getOrigin() {
        return origin;
    }

    @Override
    public TARGET getTarget() {
        return target;
    }

}
