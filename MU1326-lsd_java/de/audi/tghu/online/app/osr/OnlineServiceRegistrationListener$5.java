/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;

class OnlineServiceRegistrationListener$5
extends CommandResponse {
    private final /* synthetic */ String val$authIdentifier;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$5(OnlineServiceRegistrationListener onlineServiceRegistrationListener, String string, int n) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$authIdentifier = string;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).setCredentialResponse(this.val$authIdentifier, this.val$result);
    }
}

