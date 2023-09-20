package com.github.rattakingabat.streamer.person;

import com.github.rattakingabat.streamer.person.stats.StatEvent;
import lombok.Value;

import java.util.List;

public record PersonTickEvent(Person person, Long tick, List<StatEvent> receivedStanceEvents, List<StatEvent> givenStanceEvents) {}
