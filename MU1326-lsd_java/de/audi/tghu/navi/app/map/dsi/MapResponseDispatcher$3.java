/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;

class MapResponseDispatcher$3
extends CommandResponse {
    private final /* synthetic */ boolean val$dayNightView;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$3(MapResponseDispatcher mapResponseDispatcher, boolean bl) {
        this.this$0 = mapResponseDispatcher;
        this.val$dayNightView = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).updateDayNightView(this.val$dayNightView);
    }
}

