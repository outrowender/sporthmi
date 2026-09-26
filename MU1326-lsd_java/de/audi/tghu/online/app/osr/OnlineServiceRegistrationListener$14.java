/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRUser;

class OnlineServiceRegistrationListener$14
extends CommandResponse {
    private final /* synthetic */ OSRUser val$user;
    private final /* synthetic */ OSRDevice[] val$devices;
    private final /* synthetic */ int[] val$results;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$14(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$user = oSRUser;
        this.val$devices = oSRDeviceArray;
        this.val$results = nArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).setAutoLoginResponse(this.val$user, this.val$devices, this.val$results);
    }
}

