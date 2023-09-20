package com.github.rattakingabat.streamer.world;

import com.github.rattakingabat.streamer.person.Girl;
import com.github.rattakingabat.streamer.person.Person;
import com.github.rattakingabat.streamer.person.Victim;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class World {

    private Long tick = 0l;
    private final Set<Person> persons = new HashSet<>();

    public Girl createGirl(String name){
        Girl g = new Girl(name);
        persons.add(g);
        return g;
    }


    public Victim createSlave(String name){
        Victim v = new Victim(name);
        persons.add(v);
        return v;
    }

    public WorldTick tick(){
        tick++;
        return new WorldTick(tick, persons.stream().map(p -> p.tick(tick)).collect(Collectors.toList()));
    }


}
