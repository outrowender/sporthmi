/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.Rect;

class MapResponseDispatcher$5
extends CommandResponse {
    private final /* synthetic */ Rect val$viewScreenViewPort;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$5(MapResponseDispatcher mapResponseDispatcher, Rect rect) {
        this.this$0 = mapResponseDispatcher;
        this.val$viewScreenViewPort = rect;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).updateViewScreenViewPort(this.val$viewScreenViewPort);
    }
}

