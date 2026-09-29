/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRUser;

class OnlineServiceRegistrationListener$17
extends CommandResponse {
    private final /* synthetic */ String val$authIdentifier;
    private final /* synthetic */ OSRUser[] val$user;
    private final /* synthetic */ int[] val$result;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$17(OnlineServiceRegistrationListener onlineServiceRegistrationListener, String string, OSRUser[] oSRUserArray, int[] nArray) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$authIdentifier = string;
        this.val$user = oSRUserArray;
        this.val$result = nArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).logoutAuthSchemeResult(this.val$authIdentifier, this.val$user, this.val$result);
    }
}

