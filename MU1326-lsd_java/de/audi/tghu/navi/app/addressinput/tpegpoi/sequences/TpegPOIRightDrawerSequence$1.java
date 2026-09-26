/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIRightDrawerSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class TpegPOIRightDrawerSequence$1
extends NavCommand {
    private final /* synthetic */ TpegPOIRightDrawerSequence this$0;

    TpegPOIRightDrawerSequence$1(TpegPOIRightDrawerSequence tpegPOIRightDrawerSequence, String string) {
        this.this$0 = tpegPOIRightDrawerSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        if (navLocation.isPositionValid()) {
            TpegPOIRightDrawerSequence.access$000(this.this$0).startPoiWithSearchContext(4, navLocation, false, true);
        } else {
            this.logger.log(10000, "1%#poiSearchNearDestination invalid location", (Object)this.CLASS_NAME);
        }
        this.getCommandList().commandFinished();
    }
}

