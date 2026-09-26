/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog;
import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog$AcknowledgeWatchdogListener;
import de.audi.atip.hmi.event.TimerSyncer;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public final class AcknowledgeWatchdogWithTimer
implements AcknowledgeWatchdog,
TimerListener {
    private AcknowledgeWatchdog$AcknowledgeWatchdogListener listener;
    private final Timer noAcknowledgeTimer;

    public AcknowledgeWatchdogWithTimer(int n) {
        this.noAcknowledgeTimer = new Timer("NoAcknowledgeTimer", n, true, new TimerSyncer(this));
    }

    @Override
    public void activate() {
        this.noAcknowledgeTimer.restart();
    }

    @Override
    public void deactivate() {
        this.noAcknowledgeTimer.cancel();
    }

    @Override
    public void setListener(AcknowledgeWatchdog$AcknowledgeWatchdogListener acknowledgeWatchdog$AcknowledgeWatchdogListener) {
        this.listener = acknowledgeWatchdog$AcknowledgeWatchdogListener;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(this.noAcknowledgeTimer) && this.listener != null) {
            this.listener.acknowledgeMissing();
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

