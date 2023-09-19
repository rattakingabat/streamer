package com.github.rattakingabat.streamer.action;

import com.github.rattakingabat.streamer.actor.Girl;
import com.github.rattakingabat.streamer.actor.Victim;
import lombok.Value;

@Value
public class Facesits implements Action<Girl, Victim> {

    Girl originator;
    Victim target;

}
