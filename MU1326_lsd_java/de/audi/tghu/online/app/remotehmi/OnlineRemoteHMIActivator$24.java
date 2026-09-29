/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.SDSService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$24
extends AbstractRemoteHMITask {
    private final /* synthetic */ SDSService val$sdsService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$24(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, SDSService sDSService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$sdsService = sDSService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setSDSService(this.val$sdsService);
        if (this.val$sdsService != null) {
            this.val$sdsService.registerStatusListener(OnlineRemoteHMIActivator.access$100(this.this$0));
        }
    }
}

