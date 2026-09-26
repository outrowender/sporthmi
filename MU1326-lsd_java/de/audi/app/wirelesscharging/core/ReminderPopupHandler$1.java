/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class ReminderPopupHandler$1
implements TimerListener {
    private final /* synthetic */ ReminderPopupHandler this$0;

    ReminderPopupHandler$1(ReminderPopupHandler reminderPopupHandler) {
        this.this$0 = reminderPopupHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        ReminderPopupHandler.access$000(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
        ReminderPopupHandler.access$000(this.this$0);
    }
}

