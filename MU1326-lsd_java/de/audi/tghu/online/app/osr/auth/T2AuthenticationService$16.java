/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.CreateNewUserCommand$CreateNewUserCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$16
implements CreateNewUserCommand$CreateNewUserCommandResponseListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$16(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void createNewUserResponse(OSRUser oSRUser, int n) {
        T2AuthenticationService.access$000(this.this$0, oSRUser, n);
    }
}

