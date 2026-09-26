/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiSearchAreaSequence$3
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaSequence this$0;

    PoiSearchAreaSequence$3(PoiSearchAreaSequence poiSearchAreaSequence, String string) {
        this.this$0 = poiSearchAreaSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onStart(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

