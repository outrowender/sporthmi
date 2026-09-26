/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.combi.bap.app.audio.DedicatedAudioControlHandler;
import de.audi.app.combi.bap.app.audio.DedicatedAudioControlHandler$1;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class DedicatedAudioControlHandler$FastForwardBackwardTimerListener
implements TimerListener {
    private final /* synthetic */ DedicatedAudioControlHandler this$0;

    private DedicatedAudioControlHandler$FastForwardBackwardTimerListener(DedicatedAudioControlHandler dedicatedAudioControlHandler) {
        this.this$0 = dedicatedAudioControlHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        DedicatedAudioControlHandler.access$000(this.this$0).log(10000, "[DedicatedAudioControlHandler.FastForwardBackwardTimerListener#fireTimer] timeout, no response receveived after %1ms -> abort method", timer.getDelay());
        DedicatedAudioControlHandler.access$600(this.this$0).methodAborted();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    /* synthetic */ DedicatedAudioControlHandler$FastForwardBackwardTimerListener(DedicatedAudioControlHandler dedicatedAudioControlHandler, DedicatedAudioControlHandler$1 dedicatedAudioControlHandler$1) {
        this(dedicatedAudioControlHandler);
    }
}

