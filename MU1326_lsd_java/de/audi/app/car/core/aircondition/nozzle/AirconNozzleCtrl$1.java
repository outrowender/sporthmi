/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition.nozzle;

import de.audi.app.car.core.aircondition.nozzle.AirconNozzleCtrl;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;

class AirconNozzleCtrl$1
extends DefaultTimerListener {
    private final /* synthetic */ AirconNozzleCtrl this$0;

    AirconNozzleCtrl$1(AirconNozzleCtrl airconNozzleCtrl) {
        this.this$0 = airconNozzleCtrl;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(AirconNozzleCtrl.access$000(this.this$0))) {
            if (!this.this$0.isCtrlOverwrite(0)) {
                AirconNozzleCtrl.access$102(this.this$0, true);
                AirconNozzleCtrl.access$200(this.this$0, false);
            } else {
                AirconNozzleCtrl.access$000(this.this$0).restart();
            }
        } else if (timer.equals(AirconNozzleCtrl.access$300(this.this$0))) {
            if (!this.this$0.isCtrlOverwrite(1) && !this.this$0.isCtrlOverwrite(2)) {
                AirconNozzleCtrl.access$402(this.this$0, true);
                AirconNozzleCtrl.access$502(this.this$0, true);
                AirconNozzleCtrl.access$600(this.this$0, false);
            } else {
                AirconNozzleCtrl.access$300(this.this$0).restart();
            }
        } else if (timer.equals(AirconNozzleCtrl.access$700(this.this$0))) {
            if (!this.this$0.isCtrlOverwrite(3)) {
                AirconNozzleCtrl.access$802(this.this$0, true);
                AirconNozzleCtrl.access$900(this.this$0, false);
            } else {
                AirconNozzleCtrl.access$700(this.this$0).restart();
            }
        }
    }
}

