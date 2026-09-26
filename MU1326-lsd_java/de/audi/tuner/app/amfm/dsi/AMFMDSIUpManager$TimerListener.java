/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$1;

class AMFMDSIUpManager$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ AMFMDSIUpManager this$0;

    private AMFMDSIUpManager$TimerListener(AMFMDSIUpManager aMFMDSIUpManager) {
        this.this$0 = aMFMDSIUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(AMFMDSIUpManager.access$1000(this.this$0))) {
            Object object = AMFMDSIUpManager.access$200(this.this$0);
            synchronized (object) {
                AMFMDSIUpManager.access$1200(this.this$0);
            }
        } else {
            AMFMDSIUpManager.access$1300(this.this$0).reNotification(2);
        }
    }

    /* synthetic */ AMFMDSIUpManager$TimerListener(AMFMDSIUpManager aMFMDSIUpManager, AMFMDSIUpManager$1 aMFMDSIUpManager$1) {
        this(aMFMDSIUpManager);
    }
}

