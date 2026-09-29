/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.EditorModeController;
import de.audi.app.messaging.evo.compose.EditorModeController$1;
import de.audi.atip.sysapp.SpeedThresholdListener;

final class EditorModeController$MySpeedThresholdListener
implements SpeedThresholdListener {
    private final /* synthetic */ EditorModeController this$0;

    private EditorModeController$MySpeedThresholdListener(EditorModeController editorModeController) {
        this.this$0 = editorModeController;
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        if (n == 11) {
            EditorModeController.access$200(this.this$0).log(1078071040, "[EditorModeController#exceedsUpperThreshold]");
            EditorModeController.access$300(this.this$0, true);
        }
    }

    @Override
    public void belowLowerThreshold(int n) {
        if (n == 11) {
            EditorModeController.access$400(this.this$0).log(1078071040, "[EditorModeController#belowLowerThreshold]");
            EditorModeController.access$300(this.this$0, false);
        }
    }

    /* synthetic */ EditorModeController$MySpeedThresholdListener(EditorModeController editorModeController, EditorModeController$1 editorModeController$1) {
        this(editorModeController);
    }
}

