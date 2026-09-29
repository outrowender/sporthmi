/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$1;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

class ReminderPopupHandler$ReminderTMUpdateListener
extends DefaultTerminalModeUpdateListener {
    private final /* synthetic */ ReminderPopupHandler this$0;

    private ReminderPopupHandler$ReminderTMUpdateListener(ReminderPopupHandler reminderPopupHandler) {
        this.this$0 = reminderPopupHandler;
    }

    @Override
    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
        ReminderPopupHandler.access$500(this.this$0).log(1078071040, "[ReminderTMUpdateListener#updateActiveDeviceState] TMDevice=%1, isActive=%2", terminalModeDevice.isActive(), (Object)terminalModeDevice);
        ReminderPopupHandler.access$602(this.this$0, terminalModeDevice.isActive());
        if (!ReminderPopupHandler.access$700(this.this$0)) {
            ReminderPopupHandler.access$800(this.this$0);
        }
    }

    /* synthetic */ ReminderPopupHandler$ReminderTMUpdateListener(ReminderPopupHandler reminderPopupHandler, ReminderPopupHandler$1 reminderPopupHandler$1) {
        this(reminderPopupHandler);
    }
}

