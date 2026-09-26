/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;

class OnlineServiceRegistrationListener$6
extends CommandResponse {
    private final /* synthetic */ String val$serviceID;
    private final /* synthetic */ String val$url;
    private final /* synthetic */ String val$localResource;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$6(OnlineServiceRegistrationListener onlineServiceRegistrationListener, String string, String string2, String string3, int n) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$serviceID = string;
        this.val$url = string2;
        this.val$localResource = string3;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).downloadResponse(this.val$serviceID, this.val$url, this.val$localResource, this.val$result);
    }
}

