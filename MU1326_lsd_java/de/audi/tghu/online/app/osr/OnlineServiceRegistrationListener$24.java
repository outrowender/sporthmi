/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRServiceState;

class OnlineServiceRegistrationListener$24
extends CommandResponse {
    private final /* synthetic */ String val$appID;
    private final /* synthetic */ OSRServiceState[] val$states;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$24(OnlineServiceRegistrationListener onlineServiceRegistrationListener, String string, OSRServiceState[] oSRServiceStateArray) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$appID = string;
        this.val$states = oSRServiceStateArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).precheckOnlineServiceResponse(this.val$appID, this.val$states);
    }
}

