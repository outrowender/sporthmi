/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.remotehmi.IOsrUserCacheInformation;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import org.dsi.ifc.online.OSRUser;

public class T2AuthenticationService$CacheInfos
implements IOsrUserCacheInformation {
    OSRUser user;
    String path;
    String domain;
    boolean authenticated;
    private final /* synthetic */ T2AuthenticationService this$0;

    public T2AuthenticationService$CacheInfos(T2AuthenticationService t2AuthenticationService, OSRUser oSRUser, String string, String string2, boolean bl) {
        this.this$0 = t2AuthenticationService;
        this.user = oSRUser;
        this.path = string;
        this.domain = string2;
        this.authenticated = bl;
    }

    @Override
    public void setAuthenticated(boolean bl) {
        this.authenticated = bl;
    }

    @Override
    public Object getUser() {
        return this.user;
    }

    @Override
    public String getProfilePath() {
        return this.path;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public String getDomain() {
        return this.domain;
    }
}

