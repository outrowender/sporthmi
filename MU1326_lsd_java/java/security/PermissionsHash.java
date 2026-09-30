/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;

class PermissionsHash
extends PermissionCollection {
    private static final long serialVersionUID = -8491988220802933440L;
    Hashtable perms = new Hashtable(8);

    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new IllegalStateException();
        }
        this.perms.put(permission, permission);
    }

    public Enumeration elements() {
        return this.perms.keys();
    }

    public boolean implies(Permission permission) {
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            if (!((Permission)enumeration.nextElement()).implies(permission)) continue;
            return true;
        }
        return false;
    }
}

