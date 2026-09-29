/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.OnlineHMIService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$18
extends AbstractRemoteHMITask {
    private final /* synthetic */ OnlineHMIService val$onlineHmiService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$18(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, OnlineHMIService onlineHMIService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$onlineHmiService = onlineHMIService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setOnlineHmiService(this.val$onlineHmiService);
    }
}

