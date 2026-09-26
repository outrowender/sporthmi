/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.core.comfort.UGDOLearningHandler;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;

class UGDOLearningHandler$NoResponseTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ UGDOLearningHandler this$0;

    UGDOLearningHandler$NoResponseTimerListener(UGDOLearningHandler uGDOLearningHandler) {
        this.this$0 = uGDOLearningHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        UGDOLearningHandler.access$000(this.this$0).log(-1601830656, "UGDOLearningHandler#DeleteButtonResponseMissingTimerListener#fireTimer: no response after 3000sec, switch to error screen");
        UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHmiServiceApp().getChoiceModel(1579747584).setValue(0);
        UGDOLearningHandler.access$400(this.this$0).getFrameworkAccess().getHmiServiceApp().getChoiceModel(1579747584).setStatus(1);
    }

    @Override
    public void cancelTimer(Timer timer) {
        UGDOLearningHandler.access$000(this.this$0).log(1078071040, "UGDOLearningHandler#DeleteButtonResponseMissingTimerListener#cancelTimer: got response, cancel timer");
    }
}

