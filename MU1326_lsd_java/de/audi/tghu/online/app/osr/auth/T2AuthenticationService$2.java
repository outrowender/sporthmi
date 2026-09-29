/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService$CacheInfos;
import de.audi.tghu.online.app.osr.command.OSRGetProfileFolderCommand$ORSGetProfileFolderCommandListener;
import org.dsi.ifc.online.OSRUser;

class T2AuthenticationService$2
implements OSRGetProfileFolderCommand$ORSGetProfileFolderCommandListener {
    private final /* synthetic */ T2AuthenticationService this$0;

    T2AuthenticationService$2(T2AuthenticationService t2AuthenticationService) {
        this.this$0 = t2AuthenticationService;
    }

    @Override
    public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2, boolean bl) {
        this.this$0.log.log(1078071040, "%1#getProfileFolderResponse result: %4 path:%2 user: %3", (Object)"T2AuthenticationService", (Object)string, (Object)(oSRUser != null ? oSRUser.getPortalUser() : "null"), (long)n);
        if (n != 0) {
            return;
        }
        T2AuthenticationService.access$102(this.this$0, new T2AuthenticationService$CacheInfos(this.this$0, oSRUser, string, string2, bl));
        this.this$0.modelManager.storeCacheInfosForUser(oSRUser, T2AuthenticationService.access$100(this.this$0));
        T2AuthenticationService.access$200(this.this$0);
    }
}

