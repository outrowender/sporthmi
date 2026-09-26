/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;

class MapResponseDispatcher$9
extends CommandResponse {
    private final /* synthetic */ boolean val$softZoomEnabled;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$9(MapResponseDispatcher mapResponseDispatcher, boolean bl) {
        this.this$0 = mapResponseDispatcher;
        this.val$softZoomEnabled = bl;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).updateSoftZoomEnabled(this.val$softZoomEnabled);
    }
}

