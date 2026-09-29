/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRLicense;

class OnlineServiceRegistrationListener$19
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ OSRLicense val$license;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$19(OnlineServiceRegistrationListener onlineServiceRegistrationListener, int n, OSRLicense oSRLicense) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$result = n;
        this.val$license = oSRLicense;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).getLicenseResponse(this.val$result, this.val$license);
    }
}

