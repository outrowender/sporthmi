/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.phone.core.adb.TelADBHandler;
import de.audi.app.phone.core.adb.TelADBHandler$1;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.organizer.DSIAdbSetup;

class TelADBHandler$TelDSIClientDSIADBSetup
implements IDSIClient {
    private final /* synthetic */ TelADBHandler this$0;

    private TelADBHandler$TelDSIClientDSIADBSetup(TelADBHandler telADBHandler) {
        this.this$0 = telADBHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        ADBDSIAccess aDBDSIAccess;
        TelADBHandler.access$600(this.this$0).log(1078071040, "[TelADBHandler.TelDSIClientDSIADBSetup#setDSI] dsi=%1", (Object)dSIBase);
        ADBDSIAccess aDBDSIAccess2 = aDBDSIAccess = TelADBHandler.access$500(this.this$0) != null ? TelADBHandler.access$500(this.this$0).getADBDSIAccess() : null;
        if (aDBDSIAccess != null) {
            if (dSIBase != null) {
                aDBDSIAccess.setDSIAdbSetup((DSIAdbSetup)dSIBase, TelADBHandler.access$500(this.this$0).getADBDSIListener());
            } else {
                aDBDSIAccess.clearDSIAdbSetup(TelADBHandler.access$500(this.this$0).getADBDSIListener());
            }
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[0];
    }

    /* synthetic */ TelADBHandler$TelDSIClientDSIADBSetup(TelADBHandler telADBHandler, TelADBHandler$1 telADBHandler$1) {
        this(telADBHandler);
    }
}

