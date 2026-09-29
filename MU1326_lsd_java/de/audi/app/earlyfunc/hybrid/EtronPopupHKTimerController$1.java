/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.earlyfunc.hybrid.EtronPopupHKTimerController;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class EtronPopupHKTimerController$1
implements TimerListener {
    private final /* synthetic */ ChoiceModelApp val$myModel;
    private final /* synthetic */ EtronPopupHKTimerController this$0;

    EtronPopupHKTimerController$1(EtronPopupHKTimerController etronPopupHKTimerController, ChoiceModelApp choiceModelApp) {
        this.this$0 = etronPopupHKTimerController;
        this.val$myModel = choiceModelApp;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.val$myModel.setValue(0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

