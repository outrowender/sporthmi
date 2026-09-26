/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.IOSDUpdateListener;
import de.audi.tv.app.TVInfobar;
import de.audi.tv.app.TVInfobar$1;

class TVInfobar$OsdUpdateListener
implements IOSDUpdateListener {
    private final /* synthetic */ TVInfobar this$0;

    private TVInfobar$OsdUpdateListener(TVInfobar tVInfobar) {
        this.this$0 = tVInfobar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateProgress() {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$1400(this.this$0, TVInfobar.access$1300(this.this$0));
            TVInfobar.access$1500(this.this$0).flush();
        }
    }

    /* synthetic */ TVInfobar$OsdUpdateListener(TVInfobar tVInfobar, TVInfobar$1 tVInfobar$1) {
        this(tVInfobar);
    }
}

