/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.SDSAudioHandler$1;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class SDSAudioHandler$SDSAudioHelper
implements TimerListener {
    private static final String SYSTEM_PROPERTY_SDS_AUDIO_TIMER_VALUE;
    private Timer releaseTimer = new Timer("ReleaseTimer", this.getTimerValue(), true, this);
    private final /* synthetic */ SDSAudioHandler this$0;

    private SDSAudioHandler$SDSAudioHelper(SDSAudioHandler sDSAudioHandler) {
        this.this$0 = sDSAudioHandler;
        SDSAudioHandler.access$000(sDSAudioHandler).log(-2137614336, "[SDSAudioHandler.SDSAudioHelper#ctor] Called.");
    }

    private void startTimer() {
        SDSAudioHandler.access$000(this.this$0).log(-2137614336, "[SDSAudioHandler.SDSAudioHelper#startTimer] Called.");
        this.releaseTimer.restart();
    }

    private void cancelTimer() {
        SDSAudioHandler.access$000(this.this$0).log(-2137614336, "[SDSAudioHandler.SDSAudioHelper#cancelTimer] Called.");
        this.releaseTimer.cancel();
    }

    private long getTimerValue() {
        String string = System.getProperty("sdsAudioTimerValue", "5000");
        Long l = Long.getLong(string);
        if (l == null) {
            return 0;
        }
        return l;
    }

    @Override
    public void cancelTimer(Timer timer) {
        SDSAudioHandler.access$000(this.this$0).log(-2137614336, "[SDSAudioHandler.SDSAudioHelper#cancelTimer] Called.");
    }

    @Override
    public void fireTimer(Timer timer) {
        SDSAudioHandler.access$000(this.this$0).log(-2137614336, "[SDSAudioHandler.SDSAudioHelper#fireTimer] Called, release DOWNLINK connection.");
        SDSAudioHandler.access$100(this.this$0, 112);
    }

    /* synthetic */ SDSAudioHandler$SDSAudioHelper(SDSAudioHandler sDSAudioHandler, SDSAudioHandler$1 sDSAudioHandler$1) {
        this(sDSAudioHandler);
    }

    static /* synthetic */ void access$500(SDSAudioHandler$SDSAudioHelper sDSAudioHandler$SDSAudioHelper) {
        sDSAudioHandler$SDSAudioHelper.cancelTimer();
    }

    static /* synthetic */ void access$600(SDSAudioHandler$SDSAudioHelper sDSAudioHandler$SDSAudioHelper) {
        sDSAudioHandler$SDSAudioHelper.startTimer();
    }
}

