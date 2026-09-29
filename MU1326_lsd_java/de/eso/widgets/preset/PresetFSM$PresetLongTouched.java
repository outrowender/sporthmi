/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetFSM$1;
import de.eso.widgets.preset.PresetFSM$State;

final class PresetFSM$PresetLongTouched
extends PresetFSM$State {
    private final /* synthetic */ PresetFSM this$0;

    private PresetFSM$PresetLongTouched(PresetFSM presetFSM) {
        this.this$0 = presetFSM;
        super(presetFSM, null);
    }

    @Override
    protected void onEnter() {
        PresetFSM.access$1000(this.this$0).sendDefinitionRequest(PresetFSM.access$1200(this.this$0));
        PresetFSM.access$1000(this.this$0).getPresetPopupController().presetLongTouched(PresetFSM.access$1200(this.this$0));
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
    protected void keyPressed() {
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().restartLongPressDelayTimer();
    }

    @Override
    protected void keyReleased() {
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelLongPressDelayTimer();
        PresetFSM.access$800(this.this$0, PresetFSM.access$1300(this.this$0));
        boolean bl = PresetFSM.access$1000(this.this$0).handleExecution(PresetFSM.access$1200(this.this$0));
        if (!bl) {
            PresetFSM.access$800(this.this$0, PresetFSM.access$1600(this.this$0));
        }
    }

    @Override
    protected void fireLongPressDelayTimer() {
        PresetFSM.access$800(this.this$0, PresetFSM.access$1500(this.this$0));
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().restartLongPressTimer();
    }

    /* synthetic */ PresetFSM$PresetLongTouched(PresetFSM presetFSM, PresetFSM$1 presetFSM$1) {
        this(presetFSM);
    }
}

