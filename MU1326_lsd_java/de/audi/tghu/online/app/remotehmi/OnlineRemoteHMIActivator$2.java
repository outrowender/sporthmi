/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$2
extends AbstractRemoteHMITask {
    private final /* synthetic */ OnlinePOICall val$onlineOperatorCallService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$2(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, OnlinePOICall onlinePOICall) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$onlineOperatorCallService = onlinePOICall;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setOnlineOperatorCallService(this.val$onlineOperatorCallService);
    }
}

