/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public final class AcknowledgeWatchdogWithTimer
implements AcknowledgeWatchdog,
TimerListener {
    private AcknowledgeWatchdog.AcknowledgeWatchdogListener listener;
    private final Timer noAcknowledgeTimer;

    public AcknowledgeWatchdogWithTimer(int n) {
        this.noAcknowledgeTimer = new Timer("NoAcknowledgeTimer", n, true, new TimerSyncer(this));
    }

    public void activate() {
        this.noAcknowledgeTimer.restart();
    }

    public void deactivate() {
        this.noAcknowledgeTimer.cancel();
    }

    public void setListener(AcknowledgeWatchdog.AcknowledgeWatchdogListener acknowledgeWatchdogListener) {
        this.listener = acknowledgeWatchdogListener;
    }

    public void fireTimer(Timer timer) {
        if (timer.equals(this.noAcknowledgeTimer) && this.listener != null) {
            this.listener.acknowledgeMissing();
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

