/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;

class OnlineServiceRegistrationListener$7
extends CommandResponse {
    private final /* synthetic */ String val$email;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$7(OnlineServiceRegistrationListener onlineServiceRegistrationListener, String string, int n) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$email = string;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).performPortalRegistrationResponse(this.val$email, this.val$result);
    }
}

