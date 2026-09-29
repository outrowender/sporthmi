/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRLicense;

class OnlineServiceRegistrationListener$20
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ boolean val$flagAssigned;
    private final /* synthetic */ boolean val$flagUnassigned;
    private final /* synthetic */ OSRLicense[] val$license;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$20(OnlineServiceRegistrationListener onlineServiceRegistrationListener, int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$result = n;
        this.val$flagAssigned = bl;
        this.val$flagUnassigned = bl2;
        this.val$license = oSRLicenseArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).getLicensesResponse(this.val$result, this.val$flagAssigned, this.val$flagUnassigned, this.val$license);
    }
}

