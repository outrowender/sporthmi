/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.Point;

class MapResponseDispatcher$6
extends CommandResponse {
    private final /* synthetic */ Point val$carPosition;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$6(MapResponseDispatcher mapResponseDispatcher, Point point) {
        this.this$0 = mapResponseDispatcher;
        this.val$carPosition = point;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).updateCarPosition(this.val$carPosition);
    }
}

