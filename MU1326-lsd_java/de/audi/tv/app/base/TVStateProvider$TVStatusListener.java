/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.base.TVStateProvider;
import de.audi.tv.app.base.TVStateProvider$1;

class TVStateProvider$TVStatusListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVStateProvider this$0;

    private TVStateProvider$TVStatusListener(TVStateProvider tVStateProvider) {
        this.this$0 = tVStateProvider;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerAvailable() {
        Object object = TVStateProvider.access$200(this.this$0);
        synchronized (object) {
            TVStateProvider.access$302(this.this$0, 0);
            TVStateProvider.access$400(this.this$0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerUnavailable() {
        Object object = TVStateProvider.access$200(this.this$0);
        synchronized (object) {
            TVStateProvider.access$302(this.this$0, 1);
            TVStateProvider.access$400(this.this$0);
        }
    }

    /* synthetic */ TVStateProvider$TVStatusListener(TVStateProvider tVStateProvider, TVStateProvider$1 tVStateProvider$1) {
        this(tVStateProvider);
    }
}

