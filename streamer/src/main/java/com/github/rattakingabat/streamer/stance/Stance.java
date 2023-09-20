package com.github.rattakingabat.streamer.stance;

import com.github.rattakingabat.streamer.action.Action;
import com.github.rattakingabat.streamer.person.Person;
import com.github.rattakingabat.streamer.person.stats.StatEvent;

import java.util.List;

public interface Stance<GIVER_PERSON extends Person, ORIGIN_ACTION extends Action<GIVER_PERSON, ? extends Person>, RECEIVER extends Person> {

    ORIGIN_ACTION getOriginAction();

    RECEIVER getReceiver();

    //Executed each turn for effect to be evaluated
    StanceTick<RECEIVER> tickEvents(Long tick);

}
