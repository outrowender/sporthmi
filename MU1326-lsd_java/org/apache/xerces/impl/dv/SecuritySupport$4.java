/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

import java.security.PrivilegedAction;
import org.apache.xerces.impl.dv.SecuritySupport;

class SecuritySupport$4
implements PrivilegedAction {
    private final /* synthetic */ String val$propName;
    private final /* synthetic */ SecuritySupport this$0;

    SecuritySupport$4(SecuritySupport securitySupport, String string) {
        this.this$0 = securitySupport;
        this.val$propName = string;
    }

    @Override
    public Object run() {
        return System.getProperty(this.val$propName);
    }
}

