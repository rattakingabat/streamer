package com.github.rattakingabat.streamer.actor;

import lombok.Value;

public record Stat(Integer value) {
    public Stat increase(Integer increment) {
        return new Stat(this.value + increment);
    }

    public Stat decrease(Integer decrement) {
        return new Stat(this.value - decrement);
    }

}
