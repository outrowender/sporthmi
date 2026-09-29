/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRUser;

class OnlineServiceRegistrationListener$13
extends CommandResponse {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$13(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRUser oSRUser) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$user = oSRUser;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).setPrivacyFlagsResponse(this.val$user);
    }
}

