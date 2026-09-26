/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;

class ReminderPopupHandler$2
implements IDSIClient {
    private final /* synthetic */ ReminderPopupHandler this$0;

    ReminderPopupHandler$2(ReminderPopupHandler reminderPopupHandler) {
        this.this$0 = reminderPopupHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
    }

    @Override
    public int[] getAutoNotifications() {
        return DSIActivator.ATTR_ALL;
    }
}

