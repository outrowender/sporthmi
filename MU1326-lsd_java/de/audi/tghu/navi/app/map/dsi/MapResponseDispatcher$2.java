/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;

class MapResponseDispatcher$2
extends CommandResponse {
    private final /* synthetic */ NavLocationWgs84 val$position;
    private final /* synthetic */ boolean val$detailedMapMaterialAvailable;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$2(MapResponseDispatcher mapResponseDispatcher, NavLocationWgs84 navLocationWgs84, boolean bl) {
        this.this$0 = mapResponseDispatcher;
        this.val$position = navLocationWgs84;
        this.val$detailedMapMaterialAvailable = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).isDetailedMapMaterialAvailable(this.val$position, this.val$detailedMapMaterialAvailable);
    }
}

