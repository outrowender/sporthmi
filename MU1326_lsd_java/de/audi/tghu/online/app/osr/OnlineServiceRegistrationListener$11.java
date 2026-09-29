/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRUser;

class OnlineServiceRegistrationListener$11
extends CommandResponse {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$11(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRUser oSRUser, int n) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$user = oSRUser;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).checkPasswordResponse(this.val$user, this.val$result);
    }
}

