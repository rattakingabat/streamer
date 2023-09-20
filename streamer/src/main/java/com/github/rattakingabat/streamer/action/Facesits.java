package com.github.rattakingabat.streamer.action;

import com.github.rattakingabat.streamer.person.Girl;
import com.github.rattakingabat.streamer.person.Victim;
import com.github.rattakingabat.streamer.stance.FaceSat;
import com.github.rattakingabat.streamer.stance.FaceSitting;

public record Facesits(Girl originator, Victim target) implements Action<Girl, Victim> {

    @Override
    public void execute() {
        FaceSitting facesitting = new FaceSitting(originator, this, target);
        FaceSat facesat = facesitting.getFaceSat();

        originator.giveStance(facesitting);
        target.receiveStance(facesat);
    }
}
