package com.github.rattakingabat.streamer.action;

import com.github.rattakingabat.streamer.world.World;
import com.github.rattakingabat.streamer.person.Girl;
import com.github.rattakingabat.streamer.person.StatsType;
import com.github.rattakingabat.streamer.person.Victim;
import com.github.rattakingabat.streamer.person.stats.Stat;
import com.github.rattakingabat.streamer.stance.FaceSitting;
import com.github.rattakingabat.streamer.stance.Stance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StanceTest {

    @Test
    public void stanceTest(){

        World world = new World();

        Victim victim = world.createSlave("Tim");
        Girl girl = world.createGirl("Ashley");
        Action<Girl, Victim> faceSit = new Facesits(girl, victim);
        faceSit.execute();

        assertEquals(1, girl.getGivenStances().size(), "Stance not created");

        Stance<?,?,?> girlStance = girl.getGivenStances().stream().findFirst().orElse(null);

        assertNotNull(girlStance);
        assertInstanceOf(FaceSitting.class, girlStance);

        FaceSitting faceSittingStance = (FaceSitting) girlStance;
        assertNotNull(faceSittingStance.getFaceSat());
        assertEquals(victim, faceSittingStance.getFaceSat().getReceiver());

    }

    @Test
    public void initialSuffocationTest(){

        World world = new World();

        Victim victim = world.createSlave("Tim");
        Stat initialSuffocation = victim.getStat(StatsType.SUFFOCATION);
        assertEquals(0, initialSuffocation.value());
        Girl girl = world.createGirl("Ashley");
        Action<Girl, Victim> faceSit = new Facesits(girl, victim);
        faceSit.execute();

        world.tick();

        Stat finalSuffocation = victim.getStat(StatsType.SUFFOCATION);
        assertEquals(1, finalSuffocation.value());

    }

    @Test
    public void maxSuffocationTest(){

        World world = new World();

        Victim victim = world.createSlave("Tim");
        Stat initialSuffocation = victim.getStat(StatsType.SUFFOCATION);
        assertEquals(0, initialSuffocation.value());


        Girl girl = new Girl("Ashley");
        Action<Girl, Victim> faceSit = new Facesits(girl, victim);
        faceSit.execute();

        for(int i = 0; i < 15; ++i){
            world.tick();
        }

        Stat finalSuffocation = victim.getStat(StatsType.SUFFOCATION);
        assertEquals(10, finalSuffocation.value());
    }

}
