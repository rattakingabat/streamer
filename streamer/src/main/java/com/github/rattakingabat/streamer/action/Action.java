package com.github.rattakingabat.streamer.action;

import com.github.rattakingabat.streamer.actor.Person;

public interface Action<ORIG extends Person, TARGET extends Person> {
    ORIG getOriginator();
    TARGET getTarget();

}
