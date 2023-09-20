package com.github.rattakingabat.streamer.stance;

import com.github.rattakingabat.streamer.effect.Effect;
import com.github.rattakingabat.streamer.person.Person;
import com.github.rattakingabat.streamer.person.stats.StatEvent;
import lombok.Value;

import java.util.List;
import java.util.Set;

public record StanceTick<T extends Person>(Long tick, List<StatEvent> statEvents, Set<Effect<T>> effects) {
}
