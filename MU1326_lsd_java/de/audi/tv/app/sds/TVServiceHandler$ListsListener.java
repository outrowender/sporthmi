/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sds;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.sds.TVServiceHandler;
import de.audi.tv.app.sds.TVServiceHandler$1;

class TVServiceHandler$ListsListener
extends DefaultTVListsListener {
    private final /* synthetic */ TVServiceHandler this$0;

    private TVServiceHandler$ListsListener(TVServiceHandler tVServiceHandler) {
        this.this$0 = tVServiceHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateFavoritesList() {
        Object object = TVServiceHandler.access$300(this.this$0);
        synchronized (object) {
            SDSListEntry[] sDSListEntryArray = TVServiceHandler.access$800(this.this$0, TVServiceHandler.access$700(this.this$0).getTmpList());
            if (sDSListEntryArray.length != 0 != TVServiceHandler.access$900(this.this$0)) {
                TVServiceHandler.access$902(this.this$0, sDSListEntryArray.length > 0);
                TVServiceHandler.access$500(this.this$0);
            }
            TVServiceHandler.access$1000(this.this$0, sDSListEntryArray, 2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStationList() {
        Object object = TVServiceHandler.access$300(this.this$0);
        synchronized (object) {
            TVServiceHandler.access$1000(this.this$0, TVServiceHandler.access$800(this.this$0, TVServiceHandler.access$1100(this.this$0).getTmpList()), 1);
        }
    }

    /* synthetic */ TVServiceHandler$ListsListener(TVServiceHandler tVServiceHandler, TVServiceHandler$1 tVServiceHandler$1) {
        this(tVServiceHandler);
    }
}

