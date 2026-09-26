/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.auth.GetUsersCommand$GetUsersCommandListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$15
implements GetUsersCommand$GetUsersCommandListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$15(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void getUsersResponse(OSRUser[] oSRUserArray) {
        if (oSRUserArray == null) {
            this.this$0.log.log(1078071040, "%1#GetUsersCommandListener: response Received empty user list");
        } else {
            this.this$0.log.log(1078071040, "%1#GetUsersCommandListener: response Received usersList-length: %2", (Object)"T2AuthenticationService", (long)oSRUserArray.length);
        }
    }
}

