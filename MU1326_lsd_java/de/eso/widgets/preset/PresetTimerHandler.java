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
import de.eso.widgets.preset.PresetTimerHandler$StoreProgressTimer;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public class PresetTimerHandler
implements ATIPEventListener {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    private static final int LONG_TOUCH_TIME;
    private static final int DELAY_HIDE_TIME;
    private static final long EARLY_STORE_TIME;
    private static final int SAVE_DELAY_TIME;
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
    private PresetTimerHandler$StoreProgressTimer longPressTimer;
    private PresetManager presetManager;
    private IFrameworkAccess fw;

    public PresetTimerHandler(PresetManager presetManager, IFrameworkAccess iFrameworkAccess) {
        this.presetManager = presetManager;
        this.fw = iFrameworkAccess;
        this.longPressTimer = new PresetTimerHandler$StoreProgressTimer(this);
        this.hideDelayTimerEvent = new TimerEvent(this);
        this.longTouchTimerEvent = new TimerEvent(this);
        this.earlyStoreTimerEvent = new TimerEvent(this);
        this.longPressDelayTimerEvent = new TimerEvent(this);
        this.glowDeactivationOnPresedPresetTimerEvent = new TimerEvent(this);
        this.saveDelayTimerEvent = new TimerEvent(this);
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.hideDelayTimerEvent)) {
            lc.log(-2137614336, "PresetTimerHandler#processEvent hideDelayTimer received, showPresetPopup(false) called");
            this.presetManager.getPresetFSM().fireHideDelayTimer();
        } else if (aTIPEvent.equals(this.longTouchTimerEvent)) {
            lc.log(-2137614336, "PresetTimerHandler#processEvent longTouchTimerEvent received, longTouchPreset called");
            this.presetManager.getPresetFSM().fireLongTouchTimer();
        } else if (aTIPEvent.equals(this.glowDeactivationOnPresedPresetTimerEvent)) {
            lc.log(-2137614336, "PresetTimerHandler#processEvent glowDeactivationOnPresedPresetTimer received, storePreset called");
            this.presetManager.getPresetPopupController().deactivateGlowOnActivePreset();
        } else if (aTIPEvent.equals(this.earlyStoreTimerEvent)) {
            lc.log(-2137614336, "PresetTimerHandler#processEvent earlyStoreTimerEvent received");
            this.presetManager.getPresetFSM().fireEarlyStoreTimer();
        } else if (aTIPEvent.equals(this.longPressDelayTimerEvent)) {
            lc.log(-2137614336, "PresetTimerHandler#processEvent longPressDelayTimerEvent received");
            this.presetManager.getPresetFSM().fireLongPressDelayTimer();
        } else if (aTIPEvent.equals(this.saveDelayTimerEvent)) {
            lc.log(-2137614336, "PresetTimerHandler#processEvent saveDelayTimerEvent received");
            this.presetManager.getPresetFSM().fireSaveDelayTimer();
        } else {
            lc.log(-1601830656, "PresetTimerHandler#processEvent unknown event received, event: %1", (Object)aTIPEvent);
        }
    }

    void restartHideDelayTimer() {
        lc.log(-2137614336, "PresetTimerHandler#restartHideDelayTimer");
        this.cancelHideDelayTimer();
        this.hideDelayTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.hideDelayTimerEvent, 0);
    }

    void cancelHideDelayTimer() {
        if (this.hideDelayTimer != null && !this.hideDelayTimer.isCanceled()) {
            this.hideDelayTimer.cancel();
        }
    }

    void restartLongTouchTimer() {
        lc.log(-2137614336, "PresetTimerHandler#restartLongTouchTimer");
        this.cancelLongTouchTimer();
        this.longTouchTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.longTouchTimerEvent, 0);
    }

    void cancelLongTouchTimer() {
        if (this.longTouchTimer != null && !this.longTouchTimer.isCanceled()) {
            this.longTouchTimer.cancel();
        }
    }

    void restartLongPressTimer() {
        lc.log(-2137614336, "PresetTimerHandler#restartLongPressTimer");
        PresetTimerHandler$StoreProgressTimer.access$300(this.longPressTimer);
    }

    void cancelLongPressTimer() {
        lc.log(-2137614336, "PresetTimerHandler#cancelLongPressTimer");
        PresetTimerHandler$StoreProgressTimer.access$400(this.longPressTimer);
    }

    public void restartGlowDeactivationOnPresedPresetTimer() {
        lc.log(-2137614336, "PresetTimerHandler#restartGlowDeactivationOnPresedPresetTimer");
        if (this.glowDeactivationOnPresedPresetTimer != null && !this.glowDeactivationOnPresedPresetTimer.isCanceled()) {
            this.glowDeactivationOnPresedPresetTimer.cancel();
        }
        this.glowDeactivationOnPresedPresetTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.glowDeactivationOnPresedPresetTimerEvent, 0);
    }

    void restartEarlyStoreTimer() {
        lc.log(-2137614336, "PresetTimerHandler#restartEarlyStoreTimer");
        this.cancelEarlyStoreTimer();
        this.earlyStoreTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.earlyStoreTimerEvent, 0);
    }

    void cancelEarlyStoreTimer() {
        lc.log(-2137614336, "PresetTimerHandler#cancelEarlyStoreTimer");
        if (this.earlyStoreTimer != null && !this.earlyStoreTimer.isCanceled()) {
            this.earlyStoreTimer.cancel();
        }
    }

    public boolean isLongPressTimerActive() {
        return this.longPressTimer.isActive();
    }

    void restartLongPressDelayTimer() {
        lc.log(-2137614336, "PresetTimerHandler#restartLongPressDelayTimer");
        this.cancelLongPressDelayTimer();
        this.longPressDelayTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.longPressDelayTimerEvent, 0);
    }

    void cancelLongPressDelayTimer() {
        lc.log(-2137614336, "PresetTimerHandler#cancelLongPressDelayTimer");
        if (this.longPressDelayTimer != null && !this.longPressDelayTimer.isCanceled()) {
            this.longPressDelayTimer.cancel();
        }
    }

    public void restartSaveDelayTimer() {
        lc.log(-2137614336, "PresetTimerHandler#restartSaveDelayTimer");
        this.cancelSaveDelayTimer();
        this.saveDelayTimer = this.fw.getHMIService().getEventDispatcher().postEvent(this.saveDelayTimerEvent, 0);
    }

    public void cancelSaveDelayTimer() {
        lc.log(-2137614336, "PresetTimerHandler#cancelSaveDelayTimer");
        if (this.saveDelayTimer != null && !this.saveDelayTimer.isCanceled()) {
            this.saveDelayTimer.cancel();
        }
    }

    static /* synthetic */ IFrameworkAccess access$000(PresetTimerHandler presetTimerHandler) {
        return presetTimerHandler.fw;
    }

    static /* synthetic */ LogChannel access$100() {
        return lc;
    }

    static /* synthetic */ PresetManager access$200(PresetTimerHandler presetTimerHandler) {
        return presetTimerHandler.presetManager;
    }
}

