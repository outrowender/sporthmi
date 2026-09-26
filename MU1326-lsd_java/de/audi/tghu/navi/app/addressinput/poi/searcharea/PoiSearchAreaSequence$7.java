/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.RouteUtil;

class PoiSearchAreaSequence$7
extends NavCommand {
    private final /* synthetic */ boolean val$active;
    private final /* synthetic */ PoiSearchAreaSequence this$0;

    PoiSearchAreaSequence$7(PoiSearchAreaSequence poiSearchAreaSequence, String string, boolean bl) {
        this.this$0 = poiSearchAreaSequence;
        this.val$active = bl;
        super(string);
    }

    @Override
    public void execute() {
        if (!(this.val$active || this.this$0.poiSearchArea.getSearchContext() != 1 && this.this$0.poiSearchArea.getSearchContext() != 2 && this.this$0.poiSearchArea.getSearchContext() != 3)) {
            this.this$0.updateSearchArea(0, null);
        }
        this.this$0.modelAccess.onUpdateSearchArea(this.this$0.poiSearchArea, this.val$active, RouteUtil.getNumberOfDestinations(this.this$0.routeManager.getRoute(), 1));
        this.getCommandList().commandFinished();
    }
}

