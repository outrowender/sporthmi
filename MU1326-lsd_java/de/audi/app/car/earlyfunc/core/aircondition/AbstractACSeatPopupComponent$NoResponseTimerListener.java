/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;

class AbstractACSeatPopupComponent$NoResponseTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ AbstractACSeatPopupComponent this$0;

    AbstractACSeatPopupComponent$NoResponseTimerListener(AbstractACSeatPopupComponent abstractACSeatPopupComponent) {
        this.this$0 = abstractACSeatPopupComponent;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogChannel().log(-1601830656, "[NoResponseTimerListener##fireTimer]: no response after 4 sec, flushing all queues");
        AbstractACSeatPopupComponent.access$1000(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.this$0.getLogChannel().log(1078071040, "[NoResponseTimerListener#cancelTimer]: got response, cancel timer");
    }
}

