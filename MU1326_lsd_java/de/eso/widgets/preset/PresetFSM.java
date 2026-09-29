/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.log.LogChannel;
import de.eso.widgets.preset.PresetFSM$NoAppRegistered;
import de.eso.widgets.preset.PresetFSM$PresetInitState;
import de.eso.widgets.preset.PresetFSM$PresetLongPressed;
import de.eso.widgets.preset.PresetFSM$PresetLongTouched;
import de.eso.widgets.preset.PresetFSM$PresetNotTouchedButHideDelayPopupShown;
import de.eso.widgets.preset.PresetFSM$PresetPressed;
import de.eso.widgets.preset.PresetFSM$PresetTouched;
import de.eso.widgets.preset.PresetFSM$State;
import de.eso.widgets.preset.PresetManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public final class PresetFSM {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    private final PresetFSM$State stateInit = new PresetFSM$PresetInitState(this, null);
    private final PresetFSM$State stateNotTouched = new PresetFSM$PresetNotTouchedButHideDelayPopupShown(this, null);
    private final PresetFSM$State stateTouched = new PresetFSM$PresetTouched(this, null);
    private final PresetFSM$State stateLongTouched = new PresetFSM$PresetLongTouched(this, null);
    private final PresetFSM$State statePressed = new PresetFSM$PresetPressed(this, null);
    private final PresetFSM$State stateLongPressed = new PresetFSM$PresetLongPressed(this, null);
    private final PresetFSM$State stateNoAppRegistered = new PresetFSM$NoAppRegistered(this, null);
    private PresetFSM$State lastState = this.stateInit;
    private PresetFSM$State currentState = this.stateInit;
    private PresetManager presetManager;
    private int currentPresetIndex;

    public PresetFSM(PresetManager presetManager) {
        this.presetManager = presetManager;
    }

    private void setState(PresetFSM$State presetFSM$State) {
        lc.log(-2137614336, "[PresetFSM.setState] state=%1, currentState=%2", (Object)presetFSM$State, (Object)this.currentState);
        if (!presetFSM$State.equals(this.currentState)) {
            this.lastState = this.currentState;
            this.lastState.onExit();
            this.currentState = presetFSM$State;
            this.currentState.onEnter();
        }
    }

    public void touchPadApproached(int n) {
        this.currentPresetIndex = n;
        this.currentState.touchPadApproached();
    }

    public void touchPadAbandoned() {
        this.currentState.touchPadAbandoned();
    }

    public void keyPressed(int n) {
        this.currentPresetIndex = n;
        this.currentState.keyPressed();
    }

    public void keyReleased(int n) {
        this.currentPresetIndex = n;
        this.currentState.keyReleased();
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        this.currentState.touchPadPositionMoved(touchEvent);
    }

    public void fireHideDelayTimer() {
        this.currentState.fireHideDelayTimer();
    }

    public void fireLongTouchTimer() {
        this.currentState.fireLongTouchTimer();
    }

    public void fireLongPressTimer() {
        this.currentState.fireLongPressTimer();
    }

    public void fireEarlyStoreTimer() {
        this.currentState.fireEarlyStoreTimer();
    }

    public void fireLongPressDelayTimer() {
        this.currentState.fireLongPressDelayTimer();
    }

    public void cancelPopup() {
        this.currentState.cancelPopup();
    }

    public void fireSaveDelayTimer() {
        this.currentState.fireSaveDelayTimer();
    }

    public String toString() {
        return new Buffer().append("PresetFSM [lastState=").append(this.lastState).append(", currentState=").append(this.currentState).append(']').toString();
    }

    static /* synthetic */ PresetFSM$State access$700(PresetFSM presetFSM) {
        return presetFSM.stateInit;
    }

    static /* synthetic */ void access$800(PresetFSM presetFSM, PresetFSM$State state) {
        presetFSM.setState(state);
    }

    static /* synthetic */ PresetManager access$1000(PresetFSM presetFSM) {
        return presetFSM.presetManager;
    }

    static /* synthetic */ PresetFSM$State access$1100(PresetFSM presetFSM) {
        return presetFSM.stateTouched;
    }

    static /* synthetic */ int access$1200(PresetFSM presetFSM) {
        return presetFSM.currentPresetIndex;
    }

    static /* synthetic */ PresetFSM$State access$1300(PresetFSM presetFSM) {
        return presetFSM.stateNotTouched;
    }

    static /* synthetic */ PresetFSM$State access$1400(PresetFSM presetFSM) {
        return presetFSM.stateLongTouched;
    }

    static /* synthetic */ PresetFSM$State access$1500(PresetFSM presetFSM) {
        return presetFSM.statePressed;
    }

    static /* synthetic */ PresetFSM$State access$1600(PresetFSM presetFSM) {
        return presetFSM.stateNoAppRegistered;
    }

    static /* synthetic */ LogChannel access$1700() {
        return lc;
    }

    static /* synthetic */ PresetFSM$State access$1800(PresetFSM presetFSM) {
        return presetFSM.stateLongPressed;
    }
}

