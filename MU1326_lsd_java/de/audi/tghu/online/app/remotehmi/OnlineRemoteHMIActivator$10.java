/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.NaviService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$10
extends AbstractRemoteHMITask {
    private final /* synthetic */ NaviService val$naviService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$10(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, NaviService naviService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$naviService = naviService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getNaviComponent().setNaviService(this.val$naviService);
    }
}

