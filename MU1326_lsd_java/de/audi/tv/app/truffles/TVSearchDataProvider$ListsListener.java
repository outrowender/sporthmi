/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.truffles.TVSearchDataProvider;
import de.audi.tv.app.truffles.TVSearchDataProvider$1;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

class TVSearchDataProvider$ListsListener
extends DefaultTVListsListener {
    private final /* synthetic */ TVSearchDataProvider this$0;

    private TVSearchDataProvider$ListsListener(TVSearchDataProvider tVSearchDataProvider) {
        this.this$0 = tVSearchDataProvider;
    }

    @Override
    public void updateStationList() {
        TVSearchDataProvider.access$200(this.this$0).log(-2137614336, "[TVSearchDataProvider.updateStationList] invalidate data for station list]");
        this.invalidate(27);
    }

    @Override
    public void updateFavoritesList() {
        TVSearchDataProvider.access$200(this.this$0).log(-2137614336, "[TVSearchDataProvider.updateFavoritesList] invalidate data for favorites]");
        this.invalidate(20027);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void invalidate(int n) {
        SimpleIntIntMap simpleIntIntMap = TVSearchDataProvider.access$300(this.this$0);
        synchronized (simpleIntIntMap) {
            if (TVSearchDataProvider.access$400(this.this$0)) {
                TVSearchDataProvider.access$300(this.this$0).add(n, n);
            } else {
                TVSearchDataProvider.access$500(this.this$0, n);
            }
        }
    }

    /* synthetic */ TVSearchDataProvider$ListsListener(TVSearchDataProvider tVSearchDataProvider, TVSearchDataProvider$1 tVSearchDataProvider$1) {
        this(tVSearchDataProvider);
    }
}

