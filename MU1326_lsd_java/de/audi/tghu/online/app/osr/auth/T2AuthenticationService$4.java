/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.LogoutCommand$LogoutCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$4
implements LogoutCommand$LogoutCommandResponseListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$4(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void logoutCommandResponse(OSRUser oSRUser, int n) {
        this.this$0.log.log(1078071040, "%1#logoutCommandResponse response: %2", (Object)"T2AuthenticationService", (long)n);
        if (n == 0) {
            this.this$0.modelManager.setCurrentUser(null);
            this.this$0.modelManager.updateAuthStatus(13);
            T2AuthenticationService.access$300(this.this$0).restoreScreenTypeAfterAuthentication();
            this.this$0.modelManager.releaseLogoutModel();
            T2AuthenticationService.access$400(this.this$0, 4);
        }
    }
}

