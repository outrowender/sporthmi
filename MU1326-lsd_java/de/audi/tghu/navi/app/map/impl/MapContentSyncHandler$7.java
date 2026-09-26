/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.map.gui.SimpleBaseListModelListener;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;

class MapContentSyncHandler$7
extends SimpleBaseListModelListener {
    private final /* synthetic */ MapContentSyncHandler this$0;

    MapContentSyncHandler$7(MapContentSyncHandler mapContentSyncHandler) {
        this.this$0 = mapContentSyncHandler;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.this$0.onClickListItem(1, MapContentSyncHandler.access$100(this.this$0).getPPOIList(), n2);
    }
}

