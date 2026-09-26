/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;

class MapResponseDispatcher$4
extends CommandResponse {
    private final /* synthetic */ int val$currentViewType;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$4(MapResponseDispatcher mapResponseDispatcher, int n) {
        this.this$0 = mapResponseDispatcher;
        this.val$currentViewType = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).updateCurrentViewType(this.val$currentViewType);
    }
}

