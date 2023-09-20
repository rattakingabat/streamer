package com.github.rattakingabat.streamer.action;

import com.github.rattakingabat.streamer.person.Person;

public interface Action<ORIG extends Person, TARGET extends Person> {
    ORIG originator();
    TARGET target();

    void execute();

}
