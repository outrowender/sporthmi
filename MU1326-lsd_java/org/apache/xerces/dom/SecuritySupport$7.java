/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.io.File;
import java.security.PrivilegedAction;
import org.apache.xerces.dom.SecuritySupport;

class SecuritySupport$7
implements PrivilegedAction {
    private final /* synthetic */ File val$f;
    private final /* synthetic */ SecuritySupport this$0;

    SecuritySupport$7(SecuritySupport securitySupport, File file) {
        this.this$0 = securitySupport;
        this.val$f = file;
    }

    @Override
    public Object run() {
        return this.val$f.exists() ? Boolean.TRUE : Boolean.FALSE;
    }
}

