/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.earlysound;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.audio.earlysound.ReadinessSound;

public class ReadinessSound$AutoReleaseTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ ReadinessSound this$0;

    public ReadinessSound$AutoReleaseTimerListener(ReadinessSound readinessSound) {
        this.this$0 = readinessSound;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer != null && timer.equals(ReadinessSound.access$1100(this.this$0))) {
            ReadinessSound.access$200(this.this$0).log(-2137614336, "[ReadinessSound.AutoReleaseTimerListener.fireTimer] release heartbeat connection ");
            ReadinessSound.access$800(this.this$0).releaseConnection(48);
            ReadinessSound.access$1202(this.this$0, false);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        ReadinessSound.access$200(this.this$0).log(-2137614336, "[ReadinessSound.AutoReleaseTimerListener.cancelTimer] called ");
    }
}

