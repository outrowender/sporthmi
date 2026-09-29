/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$1;
import de.audi.atip.power.DefaultPowerEventListener;

class ReminderPopupHandler$ReminderPowerEventListener
extends DefaultPowerEventListener {
    private final /* synthetic */ ReminderPopupHandler this$0;

    private ReminderPopupHandler$ReminderPowerEventListener(ReminderPopupHandler reminderPopupHandler) {
        this.this$0 = reminderPopupHandler;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n == 0 && ReminderPopupHandler.access$1300(this.this$0).isWLCInfoPopupEnabled() && ReminderPopupHandler.access$700(this.this$0)) {
            ReminderPopupHandler.access$500(this.this$0).log(1078071040, "[ReminderPowerEventListener#notifyPowerListenerOnEnterState] going HMI_ON");
            ReminderPopupHandler.access$1400(this.this$0);
        }
    }

    /* synthetic */ ReminderPopupHandler$ReminderPowerEventListener(ReminderPopupHandler reminderPopupHandler, ReminderPopupHandler$1 reminderPopupHandler$1) {
        this(reminderPopupHandler);
    }
}

