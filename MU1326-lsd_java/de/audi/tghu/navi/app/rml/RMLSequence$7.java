/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;

class RMLSequence$7
extends NavCommand {
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$7(RMLSequence rMLSequence, String string) {
        this.this$0 = rMLSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onStart();
        this.getCommandList().commandFinished();
    }
}

