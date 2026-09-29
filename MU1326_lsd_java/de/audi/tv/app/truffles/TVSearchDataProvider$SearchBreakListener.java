/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.tv.app.lists.ISearchBreak;
import de.audi.tv.app.truffles.TVSearchDataProvider;
import de.audi.tv.app.truffles.TVSearchDataProvider$1;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

class TVSearchDataProvider$SearchBreakListener
implements ISearchBreak {
    private final /* synthetic */ TVSearchDataProvider this$0;

    private TVSearchDataProvider$SearchBreakListener(TVSearchDataProvider tVSearchDataProvider) {
        this.this$0 = tVSearchDataProvider;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cursorInSearchResult(boolean bl) {
        if (bl) {
            SimpleIntIntMap simpleIntIntMap = TVSearchDataProvider.access$300(this.this$0);
            synchronized (simpleIntIntMap) {
                TVSearchDataProvider.access$402(this.this$0, true);
            }
        }
        SimpleIntIntMap simpleIntIntMap = TVSearchDataProvider.access$300(this.this$0);
        synchronized (simpleIntIntMap) {
            int[] nArray = TVSearchDataProvider.access$300(this.this$0).getKeys();
            TVSearchDataProvider.access$300(this.this$0).clear();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                TVSearchDataProvider.access$500(this.this$0, nArray[i2]);
            }
            TVSearchDataProvider.access$402(this.this$0, false);
        }
    }

    /* synthetic */ TVSearchDataProvider$SearchBreakListener(TVSearchDataProvider tVSearchDataProvider, TVSearchDataProvider$1 tVSearchDataProvider$1) {
        this(tVSearchDataProvider);
    }
}

