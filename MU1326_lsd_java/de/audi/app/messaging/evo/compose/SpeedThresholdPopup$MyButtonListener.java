/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.compose;

import de.audi.app.messaging.evo.compose.SpeedThresholdPopup;
import de.audi.app.messaging.evo.compose.SpeedThresholdPopup$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

final class SpeedThresholdPopup$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SpeedThresholdPopup this$0;

    private SpeedThresholdPopup$MyButtonListener(SpeedThresholdPopup speedThresholdPopup) {
        this.this$0 = speedThresholdPopup;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1368596736 || n == 1385373952) {
            SpeedThresholdPopup.access$200(this.this$0, n, n3);
        } else {
            SpeedThresholdPopup.access$300(this.this$0).log(10000, "[SpeedThresholdPopup#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ SpeedThresholdPopup$MyButtonListener(SpeedThresholdPopup speedThresholdPopup, SpeedThresholdPopup$1 speedThresholdPopup$1) {
        this(speedThresholdPopup);
    }
}

