/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.OSRDeleteUserCommand$IDeleteUserCommandResponseListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$11
implements OSRDeleteUserCommand$IDeleteUserCommandResponseListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$11(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void removeUserResponse(OSRUser oSRUser, int n) {
        this.this$0.modelManager.showPopup(T2AuthenticationService.access$600(this.this$0));
    }
}

