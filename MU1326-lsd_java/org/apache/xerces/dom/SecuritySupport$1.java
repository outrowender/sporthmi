/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.security.PrivilegedAction;
import org.apache.xerces.dom.SecuritySupport;

class SecuritySupport$1
implements PrivilegedAction {
    private final /* synthetic */ SecuritySupport this$0;

    SecuritySupport$1(SecuritySupport securitySupport) {
        this.this$0 = securitySupport;
    }

    @Override
    public Object run() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        return classLoader;
    }
}

