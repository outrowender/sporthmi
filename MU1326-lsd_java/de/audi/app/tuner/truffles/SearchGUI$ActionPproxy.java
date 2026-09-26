/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.SearchGUI;
import de.audi.app.tuner.truffles.SearchGUI$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class SearchGUI$ActionPproxy
extends TunerActionProxyListener {
    private final /* synthetic */ SearchGUI this$0;

    private SearchGUI$ActionPproxy(SearchGUI searchGUI) {
        this.this$0 = searchGUI;
    }

    @Override
    public void hmiDeactivatedTuner() {
        SearchGUI.access$600(this.this$0);
    }

    /* synthetic */ SearchGUI$ActionPproxy(SearchGUI searchGUI, SearchGUI$1 searchGUI$1) {
        this(searchGUI);
    }
}

