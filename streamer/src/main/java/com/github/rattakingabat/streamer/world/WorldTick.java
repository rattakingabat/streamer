package com.github.rattakingabat.streamer.world;

import com.github.rattakingabat.streamer.person.PersonTickEvent;
import lombok.Value;

import java.util.List;


public record WorldTick(Long tick, List<PersonTickEvent> personTickEvents) {

}
