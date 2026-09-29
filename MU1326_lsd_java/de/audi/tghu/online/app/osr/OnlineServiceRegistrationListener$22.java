/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRServiceState;

class OnlineServiceRegistrationListener$22
extends CommandResponse {
    private final /* synthetic */ String val$appID;
    private final /* synthetic */ OSRServiceState val$state;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$22(OnlineServiceRegistrationListener onlineServiceRegistrationListener, String string, OSRServiceState oSRServiceState) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$appID = string;
        this.val$state = oSRServiceState;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).precheckOnlineServiceServiceIDResponse(this.val$appID, this.val$state);
    }
}

