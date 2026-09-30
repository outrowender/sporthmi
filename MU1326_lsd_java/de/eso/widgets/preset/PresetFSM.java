/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public final class PresetFSM {
    private static LogChannel lc = IWidgetLogChannel.logPreset;
    private final State stateInit = new PresetInitState();
    private final State stateNotTouched = new PresetNotTouchedButHideDelayPopupShown();
    private final State stateTouched = new PresetTouched();
    private final State stateLongTouched = new PresetLongTouched();
    private final State statePressed = new PresetPressed();
    private final State stateLongPressed = new PresetLongPressed();
    private final State stateNoAppRegistered = new NoAppRegistered();
    private State lastState = this.stateInit;
    private State currentState = this.stateInit;
    private PresetManager presetManager;
    private int currentPresetIndex;

    public PresetFSM(PresetManager presetManager) {
        this.presetManager = presetManager;
    }

    private void setState(State state) {
        lc.log(10000000, "[PresetFSM.setState] state=%1, currentState=%2", (Object)state, (Object)this.currentState);
        if (!state.equals(this.currentState)) {
            this.lastState = this.currentState;
            this.lastState.onExit();
            this.currentState = state;
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

    private abstract class State {
        private State() {
        }

        protected void onEnter() {
        }

        protected void onExit() {
        }

        protected void touchPadApproached() {
        }

        protected void touchPadAbandoned() {
        }

        protected void keyPressed() {
        }

        protected void keyReleased() {
        }

        protected void touchPadPositionMoved(TouchEvent touchEvent) {
            touchEvent.consume();
        }

        public void fireHideDelayTimer() {
        }

        public void fireLongTouchTimer() {
        }

        public void fireLongPressTimer() {
        }

        public void fireEarlyStoreTimer() {
        }

        protected void fireLongPressDelayTimer() {
        }

        protected void fireSaveDelayTimer() {
        }

        public void cancelPopup() {
            PresetFSM.this.setState(PresetFSM.this.stateInit);
        }

        public String toString() {
            String string = this.getClass().getName();
            return string.substring(string.lastIndexOf(36) + 1);
        }
    }

    private final class PresetPressed
    extends State {
        private PresetPressed() {
        }

        protected void onEnter() {
            PresetFSM.this.presetManager.getPresetPopupController().activateGlowOnActivePreset();
            if (AbstractWidget.sdsService != null) {
                AbstractWidget.sdsService.abortSDSSession(false, (byte)3);
            }
        }

        protected void onExit() {
            PresetFSM.this.presetManager.getPresetPopupController().deactivateGlowOnActivePreset();
        }

        protected void touchPadAbandoned() {
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelLongPressTimer();
            PresetFSM.this.setState(PresetFSM.this.stateNotTouched);
        }

        protected void keyReleased() {
            boolean bl = false;
            if (!PresetFSM.this.presetManager.getPresetTimerHandler().isLongPressTimerActive()) {
                try {
                    bl = PresetFSM.this.presetManager.handleExecution(PresetFSM.this.currentPresetIndex);
                }
                catch (Exception exception) {
                    lc.log(10000, "PresetPressed.keyReleased: Exception", (Throwable)exception);
                }
            }
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelEarlyStoreTimer();
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelLongPressTimer();
            if (bl) {
                PresetFSM.this.setState(PresetFSM.this.stateNotTouched);
            } else {
                PresetFSM.this.setState(PresetFSM.this.stateNoAppRegistered);
            }
        }

        public void fireLongPressTimer() {
            IPresetPopupData iPresetPopupData = PresetFSM.this.presetManager.getPresetStorageProvider().getPresetPopupDataToStore(PresetFSM.this.currentPresetIndex);
            if (iPresetPopupData.getResult() == 0) {
                PresetFSM.this.setState(PresetFSM.this.stateLongPressed);
            } else {
                lc.log(100000, "PresetPressed.fireLongPressTimer: long press not possible presetNr=%1, result=%2, presetType=%3", (long)PresetFSM.this.currentPresetIndex, (long)iPresetPopupData.getResult(), (long)iPresetPopupData.getPreset().getExecutionType());
            }
        }

        public void fireEarlyStoreTimer() {
            PresetFSM.this.presetManager.sendDefinitionRequest(PresetFSM.this.currentPresetIndex);
            PresetFSM.this.presetManager.getPresetPopupController().presetLongTouched(PresetFSM.this.currentPresetIndex);
            PresetFSM.this.presetManager.getPresetTimerHandler().restartLongPressTimer();
        }
    }

    private final class PresetTouched
    extends State {
        private PresetTouched() {
        }

        protected void onEnter() {
            PresetFSM.this.presetManager.showPresetPopup(true);
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelHideDelayTimer();
            PresetFSM.this.presetManager.getPresetTimerHandler().restartLongTouchTimer();
            PresetFSM.this.presetManager.getPresetPopupController().presetTouched(PresetFSM.this.currentPresetIndex);
        }

        protected void touchPadApproached() {
            this.onEnter();
        }

        protected void touchPadAbandoned() {
            PresetFSM.this.setState(PresetFSM.this.stateNotTouched);
        }

        public void fireLongTouchTimer() {
            PresetFSM.this.setState(PresetFSM.this.stateLongTouched);
        }

        protected void keyPressed() {
            PresetFSM.this.setState(PresetFSM.this.statePressed);
            PresetFSM.this.presetManager.getPresetTimerHandler().restartEarlyStoreTimer();
        }
    }

    private final class NoAppRegistered
    extends State {
        private NoAppRegistered() {
        }

        protected void onEnter() {
            PresetFSM.this.presetManager.getPresetTimerHandler().restartHideDelayTimer();
            PresetFSM.this.presetManager.getPresetPopupController().presetLongTouched(PresetFSM.this.currentPresetIndex);
        }

        public void fireHideDelayTimer() {
            PresetFSM.this.setState(PresetFSM.this.stateInit);
        }
    }

    private final class PresetInitState
    extends State {
        private PresetInitState() {
        }

        protected void onEnter() {
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelHideDelayTimer();
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelLongTouchTimer();
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelLongPressTimer();
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelEarlyStoreTimer();
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelSaveDelayTimer();
            PresetFSM.this.presetManager.showPresetPopup(false);
        }

        protected void touchPadApproached() {
            PresetFSM.this.setState(PresetFSM.this.stateTouched);
        }

        protected void touchPadPositionMoved(TouchEvent touchEvent) {
        }
    }

    private final class PresetLongPressed
    extends State {
        private PresetLongPressed() {
        }

        protected void onEnter() {
            PresetFSM.this.presetManager.getBeepHandler().requestBeep();
            PresetFSM.this.presetManager.saveToPersistence(PresetFSM.this.currentPresetIndex);
            PresetFSM.this.presetManager.getPresetTimerHandler().restartSaveDelayTimer();
            PresetFSM.this.presetManager.getPresetPopupController().presetTouched(PresetFSM.this.currentPresetIndex);
        }

        public void fireSaveDelayTimer() {
            PresetFSM.this.setState(PresetFSM.this.stateNotTouched);
        }
    }

    private final class PresetLongTouched
    extends State {
        private PresetLongTouched() {
        }

        protected void onEnter() {
            PresetFSM.this.presetManager.sendDefinitionRequest(PresetFSM.this.currentPresetIndex);
            PresetFSM.this.presetManager.getPresetPopupController().presetLongTouched(PresetFSM.this.currentPresetIndex);
        }

        protected void touchPadApproached() {
            this.onEnter();
        }

        protected void touchPadAbandoned() {
            PresetFSM.this.setState(PresetFSM.this.stateNotTouched);
        }

        protected void keyPressed() {
            PresetFSM.this.presetManager.getPresetTimerHandler().restartLongPressDelayTimer();
        }

        protected void keyReleased() {
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelLongPressDelayTimer();
            PresetFSM.this.setState(PresetFSM.this.stateNotTouched);
            boolean bl = PresetFSM.this.presetManager.handleExecution(PresetFSM.this.currentPresetIndex);
            if (!bl) {
                PresetFSM.this.setState(PresetFSM.this.stateNoAppRegistered);
            }
        }

        protected void fireLongPressDelayTimer() {
            PresetFSM.this.setState(PresetFSM.this.statePressed);
            PresetFSM.this.presetManager.getPresetTimerHandler().restartLongPressTimer();
        }
    }

    private final class PresetNotTouchedButHideDelayPopupShown
    extends State {
        private PresetNotTouchedButHideDelayPopupShown() {
        }

        protected void onEnter() {
            PresetFSM.this.presetManager.getPresetTimerHandler().cancelLongTouchTimer();
            PresetFSM.this.presetManager.getPresetTimerHandler().restartHideDelayTimer();
        }

        public void fireHideDelayTimer() {
            PresetFSM.this.setState(PresetFSM.this.stateInit);
        }

        protected void touchPadApproached() {
            PresetFSM.this.setState(PresetFSM.this.stateTouched);
        }
    }
}

