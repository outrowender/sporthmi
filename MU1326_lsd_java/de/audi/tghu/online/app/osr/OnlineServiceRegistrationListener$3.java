/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRLicense;

class OnlineServiceRegistrationListener$3
extends CommandResponse {
    private final /* synthetic */ OSRLicense val$license;
    private final /* synthetic */ int val$status;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$3(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRLicense oSRLicense, int n) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$license = oSRLicense;
        this.val$status = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).activateLicenseResponse(this.val$license, this.val$status);
    }
}

