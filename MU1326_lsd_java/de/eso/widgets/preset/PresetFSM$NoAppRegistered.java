/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetFSM$1;
import de.eso.widgets.preset.PresetFSM$State;

final class PresetFSM$NoAppRegistered
extends PresetFSM$State {
    private final /* synthetic */ PresetFSM this$0;

    private PresetFSM$NoAppRegistered(PresetFSM presetFSM) {
        this.this$0 = presetFSM;
        super(presetFSM, null);
    }

    @Override
    protected void onEnter() {
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().restartHideDelayTimer();
        PresetFSM.access$1000(this.this$0).getPresetPopupController().presetLongTouched(PresetFSM.access$1200(this.this$0));
    }

    @Override
    public void fireHideDelayTimer() {
        PresetFSM.access$800(this.this$0, PresetFSM.access$700(this.this$0));
    }

    /* synthetic */ PresetFSM$NoAppRegistered(PresetFSM presetFSM, PresetFSM$1 presetFSM$1) {
        this(presetFSM);
    }
}

