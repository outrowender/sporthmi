/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.interapp.PortalAuthenticationServiceCallbackListener;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.ValidateCredentialsCommand$ValidateCredentialsCommandListener;

class T2AuthenticationService$18
implements ValidateCredentialsCommand$ValidateCredentialsCommandListener {
    private final /* synthetic */ PortalAuthenticationServiceCallbackListener val$callback;
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$18(T2AuthenticationService t2AuthenticationService, PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
        this.this$0 = t2AuthenticationService;
        this.val$callback = portalAuthenticationServiceCallbackListener;
    }

    @Override
    public void validateCredentialsCommandResponse(int n) {
        this.this$0.log.log(1078071040, "%1#validateCredentialsCommandResponse [Result:%2", (Object)"T2AuthenticationService", (long)n);
        int n2 = n;
        this.this$0.modelManager.updateAuthStatus(n);
        if (this.val$callback != null) {
            this.val$callback.validateCredentialsResult(n2 == 0, n, n2);
        }
    }
}

