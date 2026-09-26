/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$1
extends AbstractRemoteHMITask {
    private final /* synthetic */ IFolderBrowsingService val$remotehmiFolderBrowsingService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$1(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IFolderBrowsingService iFolderBrowsingService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$remotehmiFolderBrowsingService = iFolderBrowsingService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setRemotehmiIFolderBrowsingService(this.val$remotehmiFolderBrowsingService);
    }
}

