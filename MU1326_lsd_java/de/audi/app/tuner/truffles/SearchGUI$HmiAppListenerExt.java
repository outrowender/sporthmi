/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.SearchGUI;
import de.audi.app.tuner.truffles.SearchGUI$1;
import de.audi.tuner.app.HmiAppListener;

class SearchGUI$HmiAppListenerExt
extends HmiAppListener {
    private final /* synthetic */ SearchGUI this$0;

    private SearchGUI$HmiAppListenerExt(SearchGUI searchGUI) {
        this.this$0 = searchGUI;
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        SearchGUI.access$700((SearchGUI)this.this$0).truffles.log(-2137614336, "[SearchGUI.HMIAppListenerExt.screenFadedOut] id %1", (long)n);
        if (SearchGUI.access$500(this.this$0)) {
            SearchGUI.access$600(this.this$0);
            SearchGUI.access$502(this.this$0, false);
        }
    }

    /* synthetic */ SearchGUI$HmiAppListenerExt(SearchGUI searchGUI, SearchGUI$1 searchGUI$1) {
        this(searchGUI);
    }
}

