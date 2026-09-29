/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;

class RMLSequence$11
extends NavCommand {
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$11(RMLSequence rMLSequence) {
        this.this$0 = rMLSequence;
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onTrafficInfoSelected();
        this.getCommandList().commandFinished();
    }
}

