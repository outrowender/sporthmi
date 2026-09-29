/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;

class RMLSequence$8
extends NavCommand {
    private final /* synthetic */ long val$elementsTotal;
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$8(RMLSequence rMLSequence, String string, long l) {
        this.this$0 = rMLSequence;
        this.val$elementsTotal = l;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onUpdateListLength(this.val$elementsTotal);
        this.getCommandList().commandFinished();
    }
}

