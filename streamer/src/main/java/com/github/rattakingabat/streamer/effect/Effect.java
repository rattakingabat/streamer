package com.github.rattakingabat.streamer.effect;

import com.github.rattakingabat.streamer.action.Action;
import com.github.rattakingabat.streamer.actor.Person;

public interface Effect<ORIGIN_PERSON extends Person, ORIGIN_ACTION extends Action<ORIGIN_PERSON, ? extends Person>, TARGET extends Person> {

    ORIGIN_ACTION  getOrigin();

    TARGET getTarget();

    //Executed each turn for effect to be evaluated
    void tick();

}
