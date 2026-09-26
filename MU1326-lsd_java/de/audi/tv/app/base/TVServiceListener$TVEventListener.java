/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.base.TVServiceListener;
import de.audi.tv.app.base.TVServiceListener$1;

class TVServiceListener$TVEventListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVServiceListener this$0;

    private TVServiceListener$TVEventListener(TVServiceListener tVServiceListener) {
        this.this$0 = tVServiceListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerAvailable() {
        Object object = TVServiceListener.access$500(this.this$0);
        synchronized (object) {
            TVServiceListener.access$700(this.this$0, TVServiceListener.access$600(this.this$0));
            TVServiceListener.access$802(this.this$0, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onTunerUnavailable() {
        Object object = TVServiceListener.access$500(this.this$0);
        synchronized (object) {
            this.this$0.deactivate();
            TVServiceListener.access$802(this.this$0, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onFocusedListChanged(int n) {
        Object object = TVServiceListener.access$500(this.this$0);
        synchronized (object) {
            if (TVServiceListener.access$800(this.this$0)) {
                TVServiceListener.access$700(this.this$0, TVServiceListener.access$600(this.this$0));
            }
        }
    }

    /* synthetic */ TVServiceListener$TVEventListener(TVServiceListener tVServiceListener, TVServiceListener$1 tVServiceListener$1) {
        this(tVServiceListener);
    }
}

