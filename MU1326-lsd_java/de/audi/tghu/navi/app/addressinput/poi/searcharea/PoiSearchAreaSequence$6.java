/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiSearchAreaSequence$6
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaSequence this$0;

    PoiSearchAreaSequence$6(PoiSearchAreaSequence poiSearchAreaSequence) {
        this.this$0 = poiSearchAreaSequence;
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object != null && object instanceof NavLocation) {
            NavLocation navLocation = (NavLocation)object;
            this.this$0.previewMap.setPreviewLocationCity(navLocation, 1, null, null);
        }
        this.getCommandList().commandFinished();
    }
}

