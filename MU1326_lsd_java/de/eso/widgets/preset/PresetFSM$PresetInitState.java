/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.event.TouchEvent;
import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetFSM$1;
import de.eso.widgets.preset.PresetFSM$State;

final class PresetFSM$PresetInitState
extends PresetFSM$State {
    private final /* synthetic */ PresetFSM this$0;

    private PresetFSM$PresetInitState(PresetFSM presetFSM) {
        this.this$0 = presetFSM;
        super(presetFSM, null);
    }

    @Override
    protected void onEnter() {
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelHideDelayTimer();
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelLongTouchTimer();
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelLongPressTimer();
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelEarlyStoreTimer();
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelSaveDelayTimer();
        PresetFSM.access$1000(this.this$0).showPresetPopup(false);
    }

    @Override
    protected void touchPadApproached() {
        PresetFSM.access$800(this.this$0, PresetFSM.access$1100(this.this$0));
    }

    @Override
    protected void touchPadPositionMoved(TouchEvent touchEvent) {
    }

    /* synthetic */ PresetFSM$PresetInitState(PresetFSM presetFSM, PresetFSM$1 presetFSM$1) {
        this(presetFSM);
    }
}

