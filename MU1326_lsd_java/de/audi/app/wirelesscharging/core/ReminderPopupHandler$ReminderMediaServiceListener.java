/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$1;
import de.audi.atip.interapp.media.IMediaServiceListener$DefaultMediaServiceListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ReminderPopupHandler$ReminderMediaServiceListener
extends IMediaServiceListener$DefaultMediaServiceListener {
    private final /* synthetic */ ReminderPopupHandler this$0;

    private ReminderPopupHandler$ReminderMediaServiceListener(ReminderPopupHandler reminderPopupHandler) {
        this.this$0 = reminderPopupHandler;
    }

    @Override
    public void sourceListChanged(Map map) {
        List list = (List)map.get(new Integer(10));
        ReminderPopupHandler.access$902(this.this$0, list != null ? list : new ArrayList());
        ReminderPopupHandler.access$1002(this.this$0, ReminderPopupHandler.access$1100(this.this$0));
        ReminderPopupHandler.access$500(this.this$0).log(1078071040, "[ReminderMediaServiceListener#sourceListChanged] isDeviceConnectedViaUsbAndBT=%1", ReminderPopupHandler.access$1000(this.this$0));
        if (!ReminderPopupHandler.access$700(this.this$0)) {
            ReminderPopupHandler.access$800(this.this$0);
        }
    }

    /* synthetic */ ReminderPopupHandler$ReminderMediaServiceListener(ReminderPopupHandler reminderPopupHandler, ReminderPopupHandler$1 reminderPopupHandler$1) {
        this(reminderPopupHandler);
    }
}

