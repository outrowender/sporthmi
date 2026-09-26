/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.GoodbyePopupHKTimerController;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class GoodbyePopupHKTimerController$1
implements TimerListener {
    private boolean shouldFire = true;
    private final /* synthetic */ GoodbyePopupHKTimerController this$0;

    GoodbyePopupHKTimerController$1(GoodbyePopupHKTimerController goodbyePopupHKTimerController) {
        this.this$0 = goodbyePopupHKTimerController;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.shouldFire) {
            GoodbyePopupHKTimerController.access$000(this.this$0).removePopup();
            GoodbyePopupHKTimerController.access$102(this.this$0, false);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.shouldFire = false;
        GoodbyePopupHKTimerController.access$102(this.this$0, true);
    }
}

