/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.TVInfobar;

class TVInfobar$1
extends DefaultTimerListener {
    private final /* synthetic */ TVInfobar this$0;

    TVInfobar$1(TVInfobar tVInfobar) {
        this.this$0 = tVInfobar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$500(this.this$0);
        }
    }
}

