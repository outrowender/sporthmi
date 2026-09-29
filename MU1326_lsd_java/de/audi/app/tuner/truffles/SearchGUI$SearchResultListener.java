/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.SearchGUI;
import de.audi.app.tuner.truffles.SearchGUI$1;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

class SearchGUI$SearchResultListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ SearchGUI this$0;

    private SearchGUI$SearchResultListener(SearchGUI searchGUI) {
        this.this$0 = searchGUI;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.this$0.itemSelected(evoListRow, n, n2, n3, n4);
    }

    /* synthetic */ SearchGUI$SearchResultListener(SearchGUI searchGUI, SearchGUI$1 searchGUI$1) {
        this(searchGUI);
    }
}

