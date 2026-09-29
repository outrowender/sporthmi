/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetFSM;
import de.eso.widgets.preset.PresetFSM$1;
import de.eso.widgets.preset.PresetFSM$State;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;

final class PresetFSM$PresetPressed
extends PresetFSM$State {
    private final /* synthetic */ PresetFSM this$0;

    private PresetFSM$PresetPressed(PresetFSM presetFSM) {
        this.this$0 = presetFSM;
        super(presetFSM, null);
    }

    @Override
    protected void onEnter() {
        PresetFSM.access$1000(this.this$0).getPresetPopupController().activateGlowOnActivePreset();
        if (AbstractWidget.sdsService != null) {
            AbstractWidget.sdsService.abortSDSSession(false, (byte)3);
        }
    }

    @Override
    protected void onExit() {
        PresetFSM.access$1000(this.this$0).getPresetPopupController().deactivateGlowOnActivePreset();
    }

    @Override
    protected void touchPadAbandoned() {
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelLongPressTimer();
        PresetFSM.access$800(this.this$0, PresetFSM.access$1300(this.this$0));
    }

    @Override
    protected void keyReleased() {
        boolean bl = false;
        if (!PresetFSM.access$1000(this.this$0).getPresetTimerHandler().isLongPressTimerActive()) {
            try {
                bl = PresetFSM.access$1000(this.this$0).handleExecution(PresetFSM.access$1200(this.this$0));
            }
            catch (Exception exception) {
                PresetFSM.access$1700().log(10000, "PresetPressed.keyReleased: Exception", (Throwable)exception);
            }
        }
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelEarlyStoreTimer();
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().cancelLongPressTimer();
        if (bl) {
            PresetFSM.access$800(this.this$0, PresetFSM.access$1300(this.this$0));
        } else {
            PresetFSM.access$800(this.this$0, PresetFSM.access$1600(this.this$0));
        }
    }

    @Override
    public void fireLongPressTimer() {
        IPresetPopupData iPresetPopupData = PresetFSM.access$1000(this.this$0).getPresetStorageProvider().getPresetPopupDataToStore(PresetFSM.access$1200(this.this$0));
        if (iPresetPopupData.getResult() == 0) {
            PresetFSM.access$800(this.this$0, PresetFSM.access$1800(this.this$0));
        } else {
            PresetFSM.access$1700().log(-1601830656, "PresetPressed.fireLongPressTimer: long press not possible presetNr=%1, result=%2, presetType=%3", (long)PresetFSM.access$1200(this.this$0), (long)iPresetPopupData.getResult(), (long)iPresetPopupData.getPreset().getExecutionType());
        }
    }

    @Override
    public void fireEarlyStoreTimer() {
        PresetFSM.access$1000(this.this$0).sendDefinitionRequest(PresetFSM.access$1200(this.this$0));
        PresetFSM.access$1000(this.this$0).getPresetPopupController().presetLongTouched(PresetFSM.access$1200(this.this$0));
        PresetFSM.access$1000(this.this$0).getPresetTimerHandler().restartLongPressTimer();
    }

    /* synthetic */ PresetFSM$PresetPressed(PresetFSM presetFSM, PresetFSM$1 presetFSM$1) {
        this(presetFSM);
    }
}

