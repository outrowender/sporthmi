/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.app.navi.evo.predictivenav.PredictiveNavSequenceEvo;
import de.audi.tghu.navi.app.command.NavCommand;

class PredictiveNavSequenceEvo$2
extends NavCommand {
    private final /* synthetic */ PredictiveNavSequenceEvo this$0;

    PredictiveNavSequenceEvo$2(PredictiveNavSequenceEvo predictiveNavSequenceEvo, String string) {
        this.this$0 = predictiveNavSequenceEvo;
        super(string);
    }

    @Override
    public void execute() {
        PredictiveNavSequenceEvo.access$002(this.this$0, false);
        this.getCommandList().commandFinished();
    }
}

