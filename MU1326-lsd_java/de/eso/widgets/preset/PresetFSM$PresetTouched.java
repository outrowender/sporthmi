/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetFSM$1;
import de.eso.widgets.preset.PresetFSM$State;

final class PresetFSM$PresetTouched
extends PresetFSM$State {
    private final /* synthetic */ PresetFSM this$0;

    private PresetFSM$PresetTouched(PresetFSM presetFSM) {
        this.this$0 = presetFSM;
        super(presetFSM, null);
    }

    @Override
    protected void onEnter() {
        PresetFSM.access$1000(this.this$0).showPresetPopup(true);
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelHideDelayTimer();
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().restartLongTouchTimer();
        PresetFSM.access$1000(this.this$0).getPresetPopupController().presetTouched(PresetFSM.access$1200(this.this$0));
    }

    @Override
    protected void touchPadApproached() {
        this.onEnter();
    }

    @Override
    protected void touchPadAbandoned() {
        PresetFSM.access$800(this.this$0, PresetFSM.access$1300(this.this$0));
    }

    @Override
    public void fireLongTouchTimer() {
        PresetFSM.access$800(this.this$0, PresetFSM.access$1400(this.this$0));
    }

    @Override
    protected void keyPressed() {
        PresetFSM.access$800(this.this$0, PresetFSM.access$1500(this.this$0));
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().restartEarlyStoreTimer();
    }

    /* synthetic */ PresetFSM$PresetTouched(PresetFSM presetFSM, PresetFSM$1 presetFSM$1) {
        this(presetFSM);
    }
}

