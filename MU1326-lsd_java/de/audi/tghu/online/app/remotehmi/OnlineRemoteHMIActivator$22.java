/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.phone.ITelService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$22
extends AbstractRemoteHMITask {
    private final /* synthetic */ ITelService val$telService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$22(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, ITelService iTelService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$telService = iTelService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getPhoneComponent().setTelService(this.val$telService);
    }
}

