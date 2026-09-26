/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.displaymanager.DSIDisplayManagerControllerImpl;
import de.audi.atip.util.osgi.NullDSIDisplayManagement;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

class DSIDisplayManagerControllerImpl$1
implements IDSIClient {
    private final /* synthetic */ DSIDisplayManagerControllerImpl this$0;

    DSIDisplayManagerControllerImpl$1(DSIDisplayManagerControllerImpl dSIDisplayManagerControllerImpl) {
        this.this$0 = dSIDisplayManagerControllerImpl;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        DSIDisplayManagerControllerImpl.access$002(this.this$0, dSIBase != null ? (DSIDisplayManagement)dSIBase : new NullDSIDisplayManagement(DSIDisplayManagerControllerImpl.access$100(this.this$0)));
    }

    @Override
    public int[] getAutoNotifications() {
        return null;
    }
}

