/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.app.navi.evo.predictivenav.PredictiveNavControllerEvo;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

class PredictiveNavControllerEvo$1
extends NavCommand {
    private final /* synthetic */ LikelyDestination[] val$likelyDestinations;
    private final /* synthetic */ PredictiveNavControllerEvo this$0;

    PredictiveNavControllerEvo$1(PredictiveNavControllerEvo predictiveNavControllerEvo, String string, LikelyDestination[] likelyDestinationArray) {
        this.this$0 = predictiveNavControllerEvo;
        this.val$likelyDestinations = likelyDestinationArray;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.updateLikelyDestinations(this.val$likelyDestinations);
        this.getCommandList().commandFinished();
    }
}

