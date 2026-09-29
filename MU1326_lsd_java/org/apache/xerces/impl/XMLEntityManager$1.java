/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import java.security.PrivilegedAction;

final class XMLEntityManager$1
implements PrivilegedAction {
    XMLEntityManager$1() {
    }

    @Override
    public Object run() {
        return System.getProperty("user.dir");
    }
}

