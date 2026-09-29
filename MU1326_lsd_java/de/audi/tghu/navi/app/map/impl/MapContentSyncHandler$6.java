/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.map.gui.SimpleBaseListModelListener;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;

class MapContentSyncHandler$6
extends SimpleBaseListModelListener {
    private final /* synthetic */ MapContentSyncHandler this$0;

    MapContentSyncHandler$6(MapContentSyncHandler mapContentSyncHandler) {
        this.this$0 = mapContentSyncHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Object object = MapContentSyncHandler.access$000(this.this$0);
        synchronized (object) {
            MapContentSyncHandler.access$200(this.this$0, (int)evoListRow.getUniqueID(), MapContentSyncHandler.access$100(this.this$0).getStandardListLevel3());
        }
    }
}

