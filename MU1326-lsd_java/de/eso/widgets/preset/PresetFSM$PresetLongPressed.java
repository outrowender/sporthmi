/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetFSM$1;
import de.eso.widgets.preset.PresetFSM$State;

final class PresetFSM$PresetLongPressed
extends PresetFSM$State {
    private final /* synthetic */ PresetFSM this$0;

    private PresetFSM$PresetLongPressed(PresetFSM presetFSM) {
        this.this$0 = presetFSM;
        super(presetFSM, null);
    }

    @Override
    protected void onEnter() {
        PresetFSM.access$1000(this.this$0).getBeepHandler().requestBeep();
        PresetFSM.access$1000(this.this$0).saveToPersistence(PresetFSM.access$1200(this.this$0));
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().restartSaveDelayTimer();
        PresetFSM.access$1000(this.this$0).getPresetPopupController().presetTouched(PresetFSM.access$1200(this.this$0));
    }

    @Override
    public void fireSaveDelayTimer() {
        PresetFSM.access$800(this.this$0, PresetFSM.access$1300(this.this$0));
    }

    /* synthetic */ PresetFSM$PresetLongPressed(PresetFSM presetFSM, PresetFSM$1 presetFSM$1) {
        this(presetFSM);
    }
}

