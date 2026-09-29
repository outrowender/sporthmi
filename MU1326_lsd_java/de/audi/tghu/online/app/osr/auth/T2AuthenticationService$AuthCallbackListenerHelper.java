/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.interapp.PortalAuthenticationServiceCallbackListener;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;

class T2AuthenticationService$AuthCallbackListenerHelper
implements PortalAuthenticationServiceCallbackListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$AuthCallbackListenerHelper(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void validatePairingCodeResult(boolean bl, int n, int n2) {
        if (!bl) {
            this.this$0.modelManager.clearSpellermodel(-82107648);
        }
    }

    @Override
    public void validateCredentialsResult(boolean bl, int n, int n2) {
        if (!bl) {
            this.this$0.modelManager.clearSpellermodel(52175616);
        }
    }

    @Override
    public void loginResult(int n) {
        this.this$0.log.log(1078071040, "%1AuthCallbackListenerHelper#loginResult %2 updateProfileInfoListeners", (Object)"T2AuthenticationService", (long)n);
        if (n == 1) {
            this.this$0.modelManager.setBackendVerificationNeccessary(true);
            return;
        }
    }
}

