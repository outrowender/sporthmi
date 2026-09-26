/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class TpegPOIDetailSequence$1
extends NavCommand {
    private final /* synthetic */ TpegPOIDetailSequence this$0;

    TpegPOIDetailSequence$1(TpegPOIDetailSequence tpegPOIDetailSequence, String string) {
        this.this$0 = tpegPOIDetailSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onUpdateLocation(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

