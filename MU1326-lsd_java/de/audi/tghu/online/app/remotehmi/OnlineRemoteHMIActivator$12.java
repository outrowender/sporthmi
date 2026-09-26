/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.NaviADBService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$12
extends AbstractRemoteHMITask {
    private final /* synthetic */ NaviADBService val$naviService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$12(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, NaviADBService naviADBService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$naviService = naviADBService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getNaviComponent().setNaviADBService(this.val$naviService);
    }
}

