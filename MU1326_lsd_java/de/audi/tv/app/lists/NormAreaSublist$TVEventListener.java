/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.lists.NormAreaSublist;
import de.audi.tv.app.lists.NormAreaSublist$1;

class NormAreaSublist$TVEventListener
extends TVEventDefaultListener {
    private final /* synthetic */ NormAreaSublist this$0;

    private NormAreaSublist$TVEventListener(NormAreaSublist normAreaSublist) {
        this.this$0 = normAreaSublist;
    }

    @Override
    public void onTunerAvailable() {
        this.this$0.init();
    }

    /* synthetic */ NormAreaSublist$TVEventListener(NormAreaSublist normAreaSublist, NormAreaSublist$1 normAreaSublist$1) {
        this(normAreaSublist);
    }
}

