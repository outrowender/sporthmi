/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRUser;

class OnlineServiceRegistrationListener$8
extends CommandResponse {
    private final /* synthetic */ OSRUser[] val$userlist;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$8(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRUser[] oSRUserArray) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$userlist = oSRUserArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).getUsersResponse(this.val$userlist);
    }
}

