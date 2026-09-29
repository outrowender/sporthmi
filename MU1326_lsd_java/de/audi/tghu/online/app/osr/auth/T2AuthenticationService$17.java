/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.interapp.PortalAuthenticationServiceCallbackListener;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.AbstractOSRCommand;

class T2AuthenticationService$17
extends AbstractOSRCommand {
    private final /* synthetic */ PortalAuthenticationServiceCallbackListener val$callback;
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$17(T2AuthenticationService t2AuthenticationService, PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
        this.this$0 = t2AuthenticationService;
        this.val$callback = portalAuthenticationServiceCallbackListener;
    }

    @Override
    public void execute() {
        this.this$0.log.log(1078071040, "%1#validateCredentials command List execute Error Command", (Object)"T2AuthenticationService");
        int n = 10;
        int n2 = this.this$0.convertLegacyResultCode(n);
        this.this$0.modelManager.updateAuthStatus(n);
        if (this.val$callback != null) {
            this.val$callback.validateCredentialsResult(false, n, n2);
        }
        this.getCommandList().commandFinished();
    }
}

