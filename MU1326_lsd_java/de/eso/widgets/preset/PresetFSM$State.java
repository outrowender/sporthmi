/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.event.TouchEvent;
import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetFSM$1;

abstract class PresetFSM$State {
    private final /* synthetic */ PresetFSM this$0;

    private PresetFSM$State(PresetFSM presetFSM) {
        this.this$0 = presetFSM;
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
        PresetFSM.access$800(this.this$0, PresetFSM.access$700(this.this$0));
    }

    public String toString() {
        String string = super.getClass().getName();
        return string.substring(string.lastIndexOf(36) + 1);
    }

    /* synthetic */ PresetFSM$State(PresetFSM presetFSM, PresetFSM$1 presetFSM$1) {
        this(presetFSM);
    }
}

