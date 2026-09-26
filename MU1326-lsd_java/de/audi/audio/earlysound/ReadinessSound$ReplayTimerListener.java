/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.earlysound;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.audio.earlysound.ReadinessSound;

class ReadinessSound$ReplayTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ ReadinessSound this$0;

    ReadinessSound$ReplayTimerListener(ReadinessSound readinessSound) {
        this.this$0 = readinessSound;
    }

    @Override
    public void fireTimer(Timer timer) {
        ReadinessSound.access$200(this.this$0).log(-2137614336, "ReadinessSound.ReplayTimerListener.fireTimer] Readiness Sound may be played again.");
    }

    @Override
    public void cancelTimer(Timer timer) {
        ReadinessSound.access$200(this.this$0).log(-2137614336, "ReadinessSound.ReplayTimerListener.cancelTimer] called.");
    }
}

