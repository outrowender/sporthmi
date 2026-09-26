/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.map.command.IDSIMapViewerControlListener;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import org.dsi.ifc.base.DSIListener;

class MapResponseDispatcher$1
extends CommandResponse {
    private final /* synthetic */ long[] val$handles;
    private final /* synthetic */ MapResponseDispatcher this$0;

    MapResponseDispatcher$1(MapResponseDispatcher mapResponseDispatcher, long[] lArray) {
        this.this$0 = mapResponseDispatcher;
        this.val$handles = lArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSIMapViewerControlListener)dSIListener).configureFlags(this.val$handles);
    }
}

