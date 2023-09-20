package com.github.rattakingabat.streamer.effect;

import com.github.rattakingabat.streamer.person.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Effect<AFFLICTED extends Person> {

    abstract void tick(Long tick, AFFLICTED target);

}
