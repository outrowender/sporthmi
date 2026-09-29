/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.TVInfobar;

class TVInfobar$2
extends DefaultTimerListener {
    private final /* synthetic */ TVInfobar this$0;

    TVInfobar$2(TVInfobar tVInfobar) {
        this.this$0 = tVInfobar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$600(this.this$0);
        }
    }
}

