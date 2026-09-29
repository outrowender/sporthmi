/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr.auth;

import de.audi.remotehmi.IOsrUserCacheInformation;
import de.audi.tghu.online.app.osr.auth.AuthenticationModelManager;
import org.dsi.ifc.online.OSRUser;

public class AuthenticationModelManager$OsrUserContainer {
    OSRUser user;
    String source;
    IOsrUserCacheInformation cacheInfo;
    private final /* synthetic */ AuthenticationModelManager this$0;

    public AuthenticationModelManager$OsrUserContainer(AuthenticationModelManager authenticationModelManager, OSRUser oSRUser, String string) {
        this.this$0 = authenticationModelManager;
        this.user = oSRUser;
        this.source = string;
    }

    public void setCacheInfo(IOsrUserCacheInformation iOsrUserCacheInformation) {
        this.cacheInfo = iOsrUserCacheInformation;
    }

    public IOsrUserCacheInformation getCacheInfo() {
        return this.cacheInfo;
    }

    public boolean equals(Object object) {
        AuthenticationModelManager$OsrUserContainer authenticationModelManager$OsrUserContainer = (AuthenticationModelManager$OsrUserContainer)object;
        if (authenticationModelManager$OsrUserContainer == null) {
            return false;
        }
        if (this.user == null && authenticationModelManager$OsrUserContainer.user == null) {
            return true;
        }
        if (this.user == null || authenticationModelManager$OsrUserContainer.user == null) {
            return false;
        }
        return this.user.portalUser.equals(authenticationModelManager$OsrUserContainer.user.portalUser) && this.user.authIdentifier.equals(authenticationModelManager$OsrUserContainer.user.authIdentifier);
    }

    public int hashCode() {
        return 0;
    }
}

