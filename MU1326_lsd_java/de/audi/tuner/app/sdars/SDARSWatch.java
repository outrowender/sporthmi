/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.SDARSWatch$DsiUpListener;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;

class SDARSWatch
extends DefaultTimerListener {
    final SDARSDsiUpInfo dsiUpListener = new SDARSWatch$DsiUpListener(this, null);
    private long moduleTime;
    private long systemTime;
    private final Object mutex = new Object();
    private final SDARSTuner tuner;
    private final Timer timer = new Timer("watch", 0, false, this);

    SDARSWatch(SDARSTuner sDARSTuner) {
        this.tuner = sDARSTuner;
    }

    void init() {
        this.tuner.askModuleTime();
        this.timer.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void updateModuleTime(long l) {
        Object object = this.mutex;
        synchronized (object) {
            this.moduleTime = l;
            this.systemTime = System.currentTimeMillis();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long getCurentTime() {
        Object object = this.mutex;
        synchronized (object) {
            return this.moduleTime + System.currentTimeMillis() - this.systemTime;
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        this.tuner.askModuleTime();
    }
}

