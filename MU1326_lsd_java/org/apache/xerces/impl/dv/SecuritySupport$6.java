/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

import java.io.InputStream;
import java.security.PrivilegedAction;
import org.apache.xerces.impl.dv.SecuritySupport;

class SecuritySupport$6
implements PrivilegedAction {
    private final /* synthetic */ ClassLoader val$cl;
    private final /* synthetic */ String val$name;
    private final /* synthetic */ SecuritySupport this$0;

    SecuritySupport$6(SecuritySupport securitySupport, ClassLoader classLoader, String string) {
        this.this$0 = securitySupport;
        this.val$cl = classLoader;
        this.val$name = string;
    }

    @Override
    public Object run() {
        InputStream inputStream = this.val$cl == null ? ClassLoader.getSystemResourceAsStream(this.val$name) : this.val$cl.getResourceAsStream(this.val$name);
        return inputStream;
    }
}

