/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class TpegPOIResultListSequence$3
extends NavCommand {
    private final /* synthetic */ TpegPOIResultListSequence this$0;

    TpegPOIResultListSequence$3(TpegPOIResultListSequence tpegPOIResultListSequence, String string) {
        this.this$0 = tpegPOIResultListSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (TpegPOIResultListSequence.access$100(this.this$0) != null) {
            TpegPOIResultListSequence.access$100(this.this$0).setPreviewPOIsOnboardAroundCCP(new NavLocation[]{this.dsiResponseContainer.getSelectedLocation()}, 5, null, null);
        }
        this.getCommandList().commandFinished();
    }
}

