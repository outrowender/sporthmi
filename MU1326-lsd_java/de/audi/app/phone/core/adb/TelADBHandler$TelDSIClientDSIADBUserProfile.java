/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.addressbook.core.common.commands.ADBDSIAccess;
import de.audi.app.phone.core.adb.TelADBHandler;
import de.audi.app.phone.core.adb.TelADBHandler$1;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.organizer.DSIAdbUserProfile;

class TelADBHandler$TelDSIClientDSIADBUserProfile
implements IDSIClient {
    private final /* synthetic */ TelADBHandler this$0;

    private TelADBHandler$TelDSIClientDSIADBUserProfile(TelADBHandler telADBHandler) {
        this.this$0 = telADBHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        ADBDSIAccess aDBDSIAccess;
        TelADBHandler.access$800(this.this$0).log(1078071040, "[TelADBHandler.TelDSIClientDSIADBUserProfile#setDSI] dsi=%1", (Object)dSIBase);
        ADBDSIAccess aDBDSIAccess2 = aDBDSIAccess = TelADBHandler.access$500(this.this$0) != null ? TelADBHandler.access$500(this.this$0).getADBDSIAccess() : null;
        if (aDBDSIAccess != null) {
            if (dSIBase != null) {
                aDBDSIAccess.setDSIAdbUserProfile((DSIAdbUserProfile)dSIBase, TelADBHandler.access$500(this.this$0).getADBDSIListener());
            } else {
                aDBDSIAccess.clearDSIAdbUserProfile(TelADBHandler.access$500(this.this$0).getADBDSIListener());
            }
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[0];
    }

    /* synthetic */ TelADBHandler$TelDSIClientDSIADBUserProfile(TelADBHandler telADBHandler, TelADBHandler$1 telADBHandler$1) {
        this(telADBHandler);
    }
}

