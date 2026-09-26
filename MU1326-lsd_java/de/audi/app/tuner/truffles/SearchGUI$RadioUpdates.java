/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.SearchGUI;
import de.audi.app.tuner.truffles.SearchGUI$1;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;

class SearchGUI$RadioUpdates
extends DefaultUpdateListener
implements IUpdateListener {
    private int band;
    private int list;
    private final /* synthetic */ SearchGUI this$0;

    private SearchGUI$RadioUpdates(SearchGUI searchGUI) {
        this.this$0 = searchGUI;
    }

    @Override
    public void updatedWaveband(int n) {
        this.doUpdate(n, this.list);
    }

    @Override
    public void updatedActiveList(int n) {
        this.doUpdate(this.band, n);
    }

    private void doUpdate(int n, int n2) {
        if (n != this.band || n2 != this.list) {
            if (!SearchGUI.access$500(this.this$0)) {
                SearchGUI.access$600(this.this$0);
            }
            this.band = n;
            this.list = n2;
        }
    }

    /* synthetic */ SearchGUI$RadioUpdates(SearchGUI searchGUI, SearchGUI$1 searchGUI$1) {
        this(searchGUI);
    }
}

