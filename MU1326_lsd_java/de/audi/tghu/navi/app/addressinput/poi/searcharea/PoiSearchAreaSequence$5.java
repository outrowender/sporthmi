/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiSearchAreaSequence$5
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaSequence this$0;

    PoiSearchAreaSequence$5(PoiSearchAreaSequence poiSearchAreaSequence) {
        this.this$0 = poiSearchAreaSequence;
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        this.this$0.updateSearchArea(4, this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

