/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;

class RMLSequence$1
extends NavCommand {
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$1(RMLSequence rMLSequence, String string) {
        this.this$0 = rMLSequence;
        super(string);
    }

    @Override
    public void execute() {
        boolean bl = this.dsiResponseContainer.isRgActive();
        this.logger.log(-2137614336, "RMLSequence#start()#execute() - %1 ", bl);
        if (!bl) {
            this.getCommandList().commandAborted("RouteGuidance is not active");
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

