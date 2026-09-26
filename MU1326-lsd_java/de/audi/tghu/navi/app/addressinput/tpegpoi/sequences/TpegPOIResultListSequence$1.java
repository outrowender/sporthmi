/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class TpegPOIResultListSequence$1
extends NavCommand {
    private final /* synthetic */ long val$index;
    private final /* synthetic */ TpegPOIResultListSequence this$0;

    TpegPOIResultListSequence$1(TpegPOIResultListSequence tpegPOIResultListSequence, String string, long l) {
        this.this$0 = tpegPOIResultListSequence;
        this.val$index = l;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getLabelModel(-1759377920).setText(this.env.getContainer().getLispValueList().list[(int)this.val$index].getData());
        this.getCommandList().commandFinished();
    }
}

