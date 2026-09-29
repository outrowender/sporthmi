/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;

class MapResponseDispatcher$7
extends CommandResponse {
    private final /* synthetic */ int val$mapOrientation;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$7(MapResponseDispatcher mapResponseDispatcher, int n) {
        this.this$0 = mapResponseDispatcher;
        this.val$mapOrientation = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).updateMapOrientation(this.val$mapOrientation);
    }
}

