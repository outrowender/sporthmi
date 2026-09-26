/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.tv.app.NullScreenActionListener;
import de.audi.tv.app.truffles.SearchGUI;
import de.audi.tv.app.truffles.SearchGUI$1;

class SearchGUI$ScreenActionListener
extends NullScreenActionListener {
    private final /* synthetic */ SearchGUI this$0;

    private SearchGUI$ScreenActionListener(SearchGUI searchGUI) {
        this.this$0 = searchGUI;
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        if (SearchGUI.access$600(this.this$0)) {
            this.this$0.clearSearch();
            SearchGUI.access$602(this.this$0, false);
        }
    }

    /* synthetic */ SearchGUI$ScreenActionListener(SearchGUI searchGUI, SearchGUI$1 searchGUI$1) {
        this(searchGUI);
    }
}

