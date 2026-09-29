/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.dab.DABDSIUpManager;
import de.audi.tuner.app.dab.DABDSIUpManager$1;

class DABDSIUpManager$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ DABDSIUpManager this$0;

    private DABDSIUpManager$TimerListener(DABDSIUpManager dABDSIUpManager) {
        this.this$0 = dABDSIUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = DABDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            DABDSIUpManager.access$1102(this.this$0, true);
            DABDSIUpManager.access$1200(this.this$0).reNotification(7);
        }
    }

    /* synthetic */ DABDSIUpManager$TimerListener(DABDSIUpManager dABDSIUpManager, DABDSIUpManager$1 dABDSIUpManager$1) {
        this(dABDSIUpManager);
    }
}

