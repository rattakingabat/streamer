package com.github.rattakingabat.streamer.person.stats;

public record Stat(Integer value) {

    public Stat change(Integer change) {
        return new Stat(this.value + change);
    }

    public boolean greaterThan(Integer value){
        return this.value.compareTo(value)<0;
    }

}
