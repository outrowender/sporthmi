/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.PortalAuthenticationServiceCallbackListener;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.LoginCommand$LoginCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$10
implements LoginCommand$LoginCommandResponseListener {
    private final /* synthetic */ PortalAuthenticationServiceCallbackListener val$listener;
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$10(T2AuthenticationService t2AuthenticationService, PortalAuthenticationServiceCallbackListener portalAuthenticationServiceCallbackListener) {
        this.this$0 = t2AuthenticationService;
        this.val$listener = portalAuthenticationServiceCallbackListener;
    }

    @Override
    public void loginCommandResponse(OSRUser oSRUser, int n) {
        this.this$0.log.log(1078071040, "%1#loginCommandResponse result: %2", (Object)"T2AuthenticationService", (long)n);
        this.this$0.modelManager.updateAuthStatus(n);
        int n2 = T2AuthenticationService.access$500(this.this$0, n);
        this.this$0.log.log(-2137614336, "%1#loginCommandResponse AUTHENTICATION_CREDENTIALS_AVAILABLE_CHOICE: %2", (Object)"T2AuthenticationService", (Object)Integer.toString(this.this$0.modelManager.getChoiceModel(1843968).getValue()));
        if (n2 == 3 && this.this$0.modelManager.getChoiceModel(1843968).getValue() == 0) {
            if (this.this$0.modelManager.isCreateNewUser()) {
                n2 = 10;
            } else {
                ChoiceModelApp choiceModelApp = this.this$0.modelManager.getChoiceModel(589243136);
                choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
            }
        }
        T2AuthenticationService.access$400(this.this$0, n2);
        if (n != 0) {
            if (n == 1) {
                this.this$0.modelManager.getChoiceModel(-1407311104).setValue(1);
            }
            this.this$0.modelManager.clearSpellermodel(-82107648);
        }
        if (this.val$listener != null) {
            this.val$listener.loginResult(n);
        }
    }
}

