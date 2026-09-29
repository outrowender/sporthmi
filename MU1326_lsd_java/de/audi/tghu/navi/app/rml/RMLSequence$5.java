/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;

class RMLSequence$5
extends NavCommand {
    private final /* synthetic */ int val$value;
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$5(RMLSequence rMLSequence, String string, int n) {
        this.this$0 = rMLSequence;
        this.val$value = n;
        super(string);
    }

    @Override
    public void execute() {
        RMLSequence.access$300(this.this$0, this.val$value);
        this.getCommandList().commandFinished();
    }
}

