/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.app.navi.evo.search.IntelliDestSearch$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class IntelliDestSearch$DidYouMeanButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ IntelliDestSearch this$0;

    private IntelliDestSearch$DidYouMeanButtonListener(IntelliDestSearch intelliDestSearch) {
        this.this$0 = intelliDestSearch;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        IntelliDestSearch.access$100(this.this$0);
    }

    /* synthetic */ IntelliDestSearch$DidYouMeanButtonListener(IntelliDestSearch intelliDestSearch, IntelliDestSearch$1 intelliDestSearch$1) {
        this(intelliDestSearch);
    }
}

