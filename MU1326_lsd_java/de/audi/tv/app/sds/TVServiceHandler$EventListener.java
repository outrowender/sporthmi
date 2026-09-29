/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sds;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.sds.TVServiceHandler;
import de.audi.tv.app.sds.TVServiceHandler$1;

class TVServiceHandler$EventListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVServiceHandler this$0;

    private TVServiceHandler$EventListener(TVServiceHandler tVServiceHandler) {
        this.this$0 = tVServiceHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerAvailable() {
        Object object = TVServiceHandler.access$300(this.this$0);
        synchronized (object) {
            TVServiceHandler.access$602(this.this$0, true);
            TVServiceHandler.access$500(this.this$0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerUnavailable() {
        Object object = TVServiceHandler.access$300(this.this$0);
        synchronized (object) {
            TVServiceHandler.access$602(this.this$0, false);
            TVServiceHandler.access$500(this.this$0);
        }
    }

    /* synthetic */ TVServiceHandler$EventListener(TVServiceHandler tVServiceHandler, TVServiceHandler$1 tVServiceHandler$1) {
        this(tVServiceHandler);
    }
}

