package com.github.rattakingabat.streamer.actor;

import com.github.rattakingabat.streamer.action.Action;
import com.github.rattakingabat.streamer.effect.Effect;

import java.util.HashSet;
import java.util.Set;

public abstract class Person {

    //Victim stats
    private Stat oxygen;
    private Stat pain;
    private Stat arousal;

    private Stat submission;
    private Stat devotion;
    private Stat fear;
    private Stat anger;

    //Torturer Stats


    Set<Effect> effects = new HashSet<>();

    void execute(Action action){

    }

    void tick(){

    }

}
