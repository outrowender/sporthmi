/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.impl;

import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;

class MapContentSyncHandler$1
extends SimpleButtonListener {
    private final /* synthetic */ MapContentSyncHandler this$0;

    MapContentSyncHandler$1(MapContentSyncHandler mapContentSyncHandler) {
        this.this$0 = mapContentSyncHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void keyPressed(int n, int n2, int n3) {
        Object object = MapContentSyncHandler.access$000(this.this$0);
        synchronized (object) {
            this.this$0.checkAll(false);
        }
    }
}

