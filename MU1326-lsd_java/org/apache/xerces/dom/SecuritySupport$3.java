/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.security.PrivilegedAction;
import org.apache.xerces.dom.SecuritySupport;

class SecuritySupport$3
implements PrivilegedAction {
    private final /* synthetic */ ClassLoader val$cl;
    private final /* synthetic */ SecuritySupport this$0;

    SecuritySupport$3(SecuritySupport securitySupport, ClassLoader classLoader) {
        this.this$0 = securitySupport;
        this.val$cl = classLoader;
    }

    @Override
    public Object run() {
        ClassLoader classLoader = null;
        try {
            classLoader = this.val$cl.getParent();
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        return classLoader == this.val$cl ? null : classLoader;
    }
}

