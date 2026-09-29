/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRApplication;

class OnlineServiceRegistrationListener$1
extends CommandResponse {
    private final /* synthetic */ OSRApplication[] val$idList;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$1(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRApplication[] oSRApplicationArray) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$idList = oSRApplicationArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).getOnlineApplicationListResponse(this.val$idList);
    }
}

