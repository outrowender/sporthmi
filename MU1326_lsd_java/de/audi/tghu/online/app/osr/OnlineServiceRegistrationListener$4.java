/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRNotifyProperties;

class OnlineServiceRegistrationListener$4
extends CommandResponse {
    private final /* synthetic */ OSRNotifyProperties[] val$props;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$4(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$props = oSRNotifyPropertiesArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).updateApplicationState(this.val$props, this.val$validFlag);
    }
}

