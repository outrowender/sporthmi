/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class TpegPOIDetailSequence$2
extends NavCommand {
    private final /* synthetic */ TpegPOIDetailSequence this$0;

    TpegPOIDetailSequence$2(TpegPOIDetailSequence tpegPOIDetailSequence, String string) {
        this.this$0 = tpegPOIDetailSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.previewMap.setPreviewPOIsOnboard(new NavLocation[]{this.dsiResponseContainer.getLiCurrentLD()}, 5, null, null);
        this.getCommandList().commandFinished();
    }
}

