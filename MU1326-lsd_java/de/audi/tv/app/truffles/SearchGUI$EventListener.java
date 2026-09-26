/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.truffles.SearchGUI;
import de.audi.tv.app.truffles.SearchGUI$1;

class SearchGUI$EventListener
extends TVEventDefaultListener {
    private int list = 0;
    private final /* synthetic */ SearchGUI this$0;

    private SearchGUI$EventListener(SearchGUI searchGUI) {
        this.this$0 = searchGUI;
    }

    @Override
    public void onAppDeactivated(int n) {
        this.this$0.clearSearch();
    }

    @Override
    public void onFocusedListChanged(int n) {
        if (n != this.list) {
            if (!SearchGUI.access$600(this.this$0)) {
                this.this$0.clearSearch();
            }
            this.list = n;
        }
    }

    /* synthetic */ SearchGUI$EventListener(SearchGUI searchGUI, SearchGUI$1 searchGUI$1) {
        this(searchGUI);
    }
}

