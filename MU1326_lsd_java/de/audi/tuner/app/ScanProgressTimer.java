/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.timer.TimerListener;
import de.audi.tuner.app.ScanProgressTimer$MyTimerListener;
import de.audi.tuner.app.TunerModels;

class ScanProgressTimer {
    private final TimerListener receiver;
    private final ScanProgressTimer$MyTimerListener timer;

    ScanProgressTimer(TunerModels tunerModels, TimerListener timerListener) {
        this.timer = new ScanProgressTimer$MyTimerListener(this, tunerModels.getRangeModel(-1618476800), tunerModels.getLabelModel(931791104), tunerModels.getLabelModel(915013888));
        this.receiver = timerListener;
    }

    void restart() {
        this.timer.start();
    }

    public boolean cancel() {
        return this.timer.cancel();
    }

    static /* synthetic */ TimerListener access$000(ScanProgressTimer scanProgressTimer) {
        return scanProgressTimer.receiver;
    }
}

