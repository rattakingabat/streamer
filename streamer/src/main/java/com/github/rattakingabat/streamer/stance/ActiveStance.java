package com.github.rattakingabat.streamer.stance;

import com.github.rattakingabat.streamer.action.Action;
import com.github.rattakingabat.streamer.person.Person;
import lombok.RequiredArgsConstructor;

/**
 * Effect caused by an actor
 */
@RequiredArgsConstructor
public abstract class ActiveStance<ORIGIN_PERSON extends Person,
                          ORIGIN_ACTION extends Action<ORIGIN_PERSON, ? extends Person>,
                          TARGET extends Person> implements Stance<ORIGIN_PERSON, ORIGIN_ACTION, TARGET> {

    protected final ORIGIN_PERSON originator;
    protected final ORIGIN_ACTION origin;
    protected final TARGET target;


    @Override
    public ORIGIN_ACTION getOriginAction() {
        return origin;
    }

    @Override
    public TARGET getReceiver() {
        return target;
    }

}
