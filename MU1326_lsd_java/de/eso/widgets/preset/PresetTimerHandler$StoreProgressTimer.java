/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.eso.widgets.preset.PresetTimerHandler;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;

class PresetTimerHandler$StoreProgressTimer
implements ATIPEventListener {
    private static final int LONG_PRESS_STORE_TIME_STEP_DELAY;
    private static final int LONG_PRESS_STORE_STEPS_HIGH;
    private static final int LONG_PRESS_STORE_STEPS_STD;
    private int longPressProgressCounter;
    private Job longPressTimer;
    private TimerEvent longPressTimerEvent;
    private final int longPressStoreSteps = AbstractWidget.isScreenResolution1024() ? 20 : 10;
    private final /* synthetic */ PresetTimerHandler this$0;

    public PresetTimerHandler$StoreProgressTimer(PresetTimerHandler presetTimerHandler) {
        this.this$0 = presetTimerHandler;
        this.longPressTimerEvent = new TimerEvent(this);
    }

    private void start() {
        this.stop();
        this.longPressTimer = PresetTimerHandler.access$000(this.this$0).getHMIService().getEventDispatcher().postEvent(this.longPressTimerEvent, 0);
    }

    private void reschedule() {
        this.longPressTimer = PresetTimerHandler.access$000(this.this$0).getHMIService().getEventDispatcher().postEvent(this.longPressTimerEvent, 0);
    }

    private void stop() {
        this.longPressProgressCounter = 0;
        if (this.longPressTimer != null && !this.longPressTimer.isCanceled()) {
            this.longPressTimer.cancel();
        }
    }

    public boolean isActive() {
        return this.longPressTimer != null && !this.longPressTimer.isCanceled();
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        PresetTimerHandler.access$100().log(-2137614336, "StoreProgressTimer#processEvent fireLongPressTimer received");
        ++this.longPressProgressCounter;
        if (this.longPressProgressCounter <= this.longPressStoreSteps) {
            float f2 = (float)this.longPressProgressCounter / (float)this.longPressStoreSteps;
            PresetTimerHandler.access$200(this.this$0).getPresetPopupController().setStoreProgressbarValue(f2);
            this.reschedule();
        } else {
            this.longPressProgressCounter = 0;
            PresetTimerHandler.access$200(this.this$0).getPresetFSM().fireLongPressTimer();
        }
    }

    static /* synthetic */ void access$300(PresetTimerHandler$StoreProgressTimer presetTimerHandler$StoreProgressTimer) {
        presetTimerHandler$StoreProgressTimer.start();
    }

    static /* synthetic */ void access$400(PresetTimerHandler$StoreProgressTimer presetTimerHandler$StoreProgressTimer) {
        presetTimerHandler$StoreProgressTimer.stop();
    }
}

