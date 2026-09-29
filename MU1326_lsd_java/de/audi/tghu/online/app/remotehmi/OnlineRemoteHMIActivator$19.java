/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$19
extends AbstractRemoteHMITask {
    private final /* synthetic */ PortalAuthenticationService val$service;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$19(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, PortalAuthenticationService portalAuthenticationService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$service = portalAuthenticationService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setAuthenticationService(this.val$service);
    }
}

