/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIDetailSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class TpegPOIDetailSequence$3
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ TpegPOIDetailSequence this$0;

    TpegPOIDetailSequence$3(TpegPOIDetailSequence tpegPOIDetailSequence, String string, NavLocation navLocation) {
        this.this$0 = tpegPOIDetailSequence;
        this.val$location = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onUpdateLocation(this.val$location);
        this.getCommandList().commandFinished();
    }
}

