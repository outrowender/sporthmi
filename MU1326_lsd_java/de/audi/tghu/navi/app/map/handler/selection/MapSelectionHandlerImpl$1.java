/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl;

class MapSelectionHandlerImpl$1
extends DefaultTimerListener {
    private final /* synthetic */ MapSelectionHandlerImpl this$0;

    MapSelectionHandlerImpl$1(MapSelectionHandlerImpl mapSelectionHandlerImpl) {
        this.this$0 = mapSelectionHandlerImpl;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogger().log(-2137614336, "MapSelectionHandlerImpl#RequestDelayer() - call requestInfoForPosition()");
        this.this$0.canceled = false;
        this.this$0.setSelectedValue(null);
        this.this$0.naviMap.getMVRequest().getInfoForPosition();
    }
}

