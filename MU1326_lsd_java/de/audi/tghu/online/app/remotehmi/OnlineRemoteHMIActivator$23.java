/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.messaging.IMessagingOnlineService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$23
extends AbstractRemoteHMITask {
    private final /* synthetic */ IMessagingOnlineService val$messagingOnlineService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$23(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IMessagingOnlineService iMessagingOnlineService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$messagingOnlineService = iMessagingOnlineService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getPhoneComponent().setOnlineMessagingService(this.val$messagingOnlineService);
    }
}

