/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.OSRApplication;

class OnlineServiceRegistrationListener$2
extends CommandResponse {
    private final /* synthetic */ OSRApplication val$app;
    private final /* synthetic */ OnlineServiceRegistrationListener this$0;

    OnlineServiceRegistrationListener$2(OnlineServiceRegistrationListener onlineServiceRegistrationListener, OSRApplication oSRApplication) {
        this.this$0 = onlineServiceRegistrationListener;
        this.val$app = oSRApplication;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIOnlineServiceRegistrationListener)dSIListener).getOnlineApplicationResponse(this.val$app);
    }
}

