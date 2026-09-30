/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.log.LogChannel;
import de.eso.widgets.preset.PresetManager;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public class PresetTimerHandler
implements ATIPEventListener {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    private static final int LONG_TOUCH_TIME = 2000;
    private static final int DELAY_HIDE_TIME = 1000;
    private static final long EARLY_STORE_TIME = 800L;
    private static final int SAVE_DELAY_TIME = 3000;
    private Job hideDelayTimer;
    private Job longTouchTimer;
    private Job glowDeactivationOnPresedPresetTimer;
    private Job earlyStoreTimer;
    private Job longPressDelayTimer;
    private Job saveDelayTimer;
    private TimerEvent hideDelayTimerEvent;
    private TimerEvent longTouchTimerEvent;
    private TimerEvent glowDeactivationOnPresedPresetTimerEvent;
    private TimerEvent earlyStoreTimerEvent;
    private TimerEvent longPressDelayTimerEvent;
    private TimerEvent saveDelayTimerEvent;
    private StoreProgressTimer longPressTimer;
    private PresetManager presetManager;
    private IFrameworkAccess fw;

    public PresetTimerHandler(PresetManager presetManager, IFrameworkAccess iFrameworkAccess) {
        this.presetManager = presetManager;
        this.fw = iFrameworkAccess;
        this.longPressTimer = new StoreProgressTimer();
        this.hideDelayTimerEvent = new TimerEvent(this);
        this.longTouchTimerEvent = new TimerEvent(this);
        this.earlyStoreTimerEvent = new TimerEvent(this);
        this.longPressDelayTimerEvent = new TimerEvent(this);
        this.glowDeactivationOnPresedPresetTimerEvent = new TimerEvent(this);
        this.saveDelayTimerEvent = new TimerEvent(this);
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.hideDelayTimerEvent)) {
            lc.log(10000000, "PresetTimerHandler#processEvent hideDelayTimer received, showPresetPopup(false) called");
            this.presetManager.getPresetFSM().fireHideDelayTimer();
        } else if (aTIPEvent.equals(this.longTouchTimerEvent)) {
            lc.log(10000000, "PresetTimerHandler#processEvent longTouchTimerEvent received, longTouchPreset called");
            this.presetManager.getPresetFSM().fireLongTouchTimer();
        } else if (aTIPEvent.equals(this.glowDeactivationOnPresedPresetTimerEvent)) {
            lc.log(10000000, "PresetTimerHandler#processEvent glowDeactivationOnPresedPresetTimer received, storePreset called");
            this.presetManager.getPresetPopupController().deactivateGlowOnActivePreset();
        } else if (aTIPEvent.equals(this.earlyStoreTimerEvent)) {
            lc.log(10000000, "PresetTimerHandler#processEvent earlyStoreTimerEvent received");
            this.presetManager.getPresetFSM().fireEarlyStoreTimer();
        } else if (aTIPEvent.equals(this.longPressDelayTimerEvent)) {
            lc.log(10000000, "PresetTimerHandler#processEvent longPressDelayTimerEvent received");
            this.presetManager.getPresetFSM().fireLongPressDelayTimer();
        } else if (aTIPEvent.equals(this.saveDelayTimerEvent)) {
            lc.log(10000000, "PresetTimerHandler#processEvent saveDelayTimerEvent received");
            this.presetManager.getPresetFSM().fireSaveDelayTimer();
        } else {
            lc.log(100000, "PresetTimerHandler#processEvent unknown event received, event: %1", (Object)aTIPEvent);
        }
    }

    void restartHideDelayTimer() {
        lc.log(10000000, "PresetTimerHandler#restartHideDelayTimer");
        this.cancelHideDelayTimer();
        this.hideDelayTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.hideDelayTimerEvent, 1000L);
    }

    void cancelHideDelayTimer() {
        if (this.hideDelayTimer != null && !this.hideDelayTimer.isCanceled()) {
            this.hideDelayTimer.cancel();
        }
    }

    void restartLongTouchTimer() {
        lc.log(10000000, "PresetTimerHandler#restartLongTouchTimer");
        this.cancelLongTouchTimer();
        this.longTouchTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.longTouchTimerEvent, 2000L);
    }

    void cancelLongTouchTimer() {
        if (this.longTouchTimer != null && !this.longTouchTimer.isCanceled()) {
            this.longTouchTimer.cancel();
        }
    }

    void restartLongPressTimer() {
        lc.log(10000000, "PresetTimerHandler#restartLongPressTimer");
        this.longPressTimer.start();
    }

    void cancelLongPressTimer() {
        lc.log(10000000, "PresetTimerHandler#cancelLongPressTimer");
        this.longPressTimer.stop();
    }

    public void restartGlowDeactivationOnPresedPresetTimer() {
        lc.log(10000000, "PresetTimerHandler#restartGlowDeactivationOnPresedPresetTimer");
        if (this.glowDeactivationOnPresedPresetTimer != null && !this.glowDeactivationOnPresedPresetTimer.isCanceled()) {
            this.glowDeactivationOnPresedPresetTimer.cancel();
        }
        this.glowDeactivationOnPresedPresetTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.glowDeactivationOnPresedPresetTimerEvent, 200L);
    }

    void restartEarlyStoreTimer() {
        lc.log(10000000, "PresetTimerHandler#restartEarlyStoreTimer");
        this.cancelEarlyStoreTimer();
        this.earlyStoreTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.earlyStoreTimerEvent, 800L);
    }

    void cancelEarlyStoreTimer() {
        lc.log(10000000, "PresetTimerHandler#cancelEarlyStoreTimer");
        if (this.earlyStoreTimer != null && !this.earlyStoreTimer.isCanceled()) {
            this.earlyStoreTimer.cancel();
        }
    }

    public boolean isLongPressTimerActive() {
        return this.longPressTimer.isActive();
    }

    void restartLongPressDelayTimer() {
        lc.log(10000000, "PresetTimerHandler#restartLongPressDelayTimer");
        this.cancelLongPressDelayTimer();
        this.longPressDelayTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.longPressDelayTimerEvent, 800L);
    }

    void cancelLongPressDelayTimer() {
        lc.log(10000000, "PresetTimerHandler#cancelLongPressDelayTimer");
        if (this.longPressDelayTimer != null && !this.longPressDelayTimer.isCanceled()) {
            this.longPressDelayTimer.cancel();
        }
    }

    public void restartSaveDelayTimer() {
        lc.log(10000000, "PresetTimerHandler#restartSaveDelayTimer");
        this.cancelSaveDelayTimer();
        this.saveDelayTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.saveDelayTimerEvent, 3000L);
    }

    public void cancelSaveDelayTimer() {
        lc.log(10000000, "PresetTimerHandler#cancelSaveDelayTimer");
        if (this.saveDelayTimer != null && !this.saveDelayTimer.isCanceled()) {
            this.saveDelayTimer.cancel();
        }
    }

    private class StoreProgressTimer
    implements ATIPEventListener {
        private static final int LONG_PRESS_STORE_TIME_STEP_DELAY = 80;
        private static final int LONG_PRESS_STORE_STEPS_HIGH = 20;
        private static final int LONG_PRESS_STORE_STEPS_STD = 10;
        private int longPressProgressCounter;
        private Job longPressTimer;
        private TimerEvent longPressTimerEvent;
        private final int longPressStoreSteps = AbstractWidget.isScreenResolution1024() ? 20 : 10;

        public StoreProgressTimer() {
            this.longPressTimerEvent = new TimerEvent(this);
        }

        private void start() {
            this.stop();
            this.longPressTimer = PresetTimerHandler.this.fw.getHMIService().getEventDispatcher().postEvent(this.longPressTimerEvent, 80L);
        }

        private void reschedule() {
            this.longPressTimer = PresetTimerHandler.this.fw.getHMIService().getEventDispatcher().postEvent(this.longPressTimerEvent, 80L);
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

        public void processEvent(ATIPEvent aTIPEvent) {
            lc.log(10000000, "StoreProgressTimer#processEvent fireLongPressTimer received");
            ++this.longPressProgressCounter;
            if (this.longPressProgressCounter <= this.longPressStoreSteps) {
                float f2 = (float)this.longPressProgressCounter / (float)this.longPressStoreSteps;
                PresetTimerHandler.this.presetManager.getPresetPopupController().setStoreProgressbarValue(f2);
                this.reschedule();
            } else {
                this.longPressProgressCounter = 0;
                PresetTimerHandler.this.presetManager.getPresetFSM().fireLongPressTimer();
            }
        }
    }
}

