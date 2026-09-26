/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOICategoryListSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class TpegPOICategoryListSequence$1
extends NavCommand {
    private final /* synthetic */ TpegPOICategoryListSequence this$0;

    TpegPOICategoryListSequence$1(TpegPOICategoryListSequence tpegPOICategoryListSequence, String string) {
        this.this$0 = tpegPOICategoryListSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.spellerStack.reset();
        this.getCommandList().commandFinished();
    }
}

