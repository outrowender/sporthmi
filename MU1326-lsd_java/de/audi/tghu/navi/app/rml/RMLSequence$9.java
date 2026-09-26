/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;

class RMLSequence$9
extends NavCommand {
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$9(RMLSequence rMLSequence) {
        this.this$0 = rMLSequence;
    }

    @Override
    public void execute() {
        RMLSequence.access$400(this.this$0).startCountryInput(true);
        RMLSequence.access$400(this.this$0).setCountry(this.dsiResponseContainer.getRMLPOILocation());
        this.getCommandList().commandFinished();
    }
}

