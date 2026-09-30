/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModel;

public class TiledListModel
extends BaseListModel
implements TiledListModelApp,
TiledListModelGUI {
    public TiledListModel(int n) {
        super(n, null);
    }

    public TiledListModel(int n, MenuModel menuModel) {
        super(n, menuModel, "TiledListModel");
    }

    public int getModelType() {
        return 26;
    }

    public void setListener(TiledListModelListener tiledListModelListener) {
        super.setListener(tiledListModelListener);
    }

    public void requestItems(int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "%1.requestItems] requestID:%2 startIndex:%3", (Object)this.logPrefix, (long)n, (long)n2);
        this.lc.log(10000000, "%1.requestItems] requestID:%2 length:%3", (Object)this.logPrefix, (long)n, (long)n3);
        try {
            ((TiledListModelListener)this.listener).requestItems(n2, n3, n, this.id, n4);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void unrequestItems(int n, int n2, int n3) {
        this.lc.log(10000000, "%1.requestItems] startIndex:%2 length:%3", (Object)this.logPrefix, (long)n, (long)n2);
        try {
            ((TiledListModelListener)this.listener).unrequestItems(n, n2, this.id, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }
}

