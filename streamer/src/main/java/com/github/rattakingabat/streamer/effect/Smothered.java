package com.github.rattakingabat.streamer.effect;

import com.github.rattakingabat.streamer.person.Victim;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Smothered extends Effect<Victim>{

    //Cannot be smothered more than once per turn
    @Getter
    private static final Smothered instance = new Smothered();

    @Override
    void tick(Long tick, Victim target) {

    }
}
