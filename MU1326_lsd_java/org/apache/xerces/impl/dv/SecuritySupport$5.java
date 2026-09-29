/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv;

import java.io.File;
import java.io.FileInputStream;
import java.security.PrivilegedExceptionAction;
import org.apache.xerces.impl.dv.SecuritySupport;

class SecuritySupport$5
implements PrivilegedExceptionAction {
    private final /* synthetic */ File val$file;
    private final /* synthetic */ SecuritySupport this$0;

    SecuritySupport$5(SecuritySupport securitySupport, File file) {
        this.this$0 = securitySupport;
        this.val$file = file;
    }

    @Override
    public Object run() {
        return new FileInputStream(this.val$file);
    }
}

