/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.LogoutAllUsersCommand$LogoutAllUsersCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$6
implements LogoutAllUsersCommand$LogoutAllUsersCommandResponseListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$6(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void logoutAllUsersCommandResponse(OSRUser[] oSRUserArray, int[] nArray) {
        this.this$0.log.log(1078071040, "%1#logoutAllUsersCommandResponse");
        this.this$0.modelManager.setCurrentUser(null);
        this.this$0.modelManager.updateAuthStatus(13);
        this.this$0.modelManager.releaseLogoutModel();
    }
}

