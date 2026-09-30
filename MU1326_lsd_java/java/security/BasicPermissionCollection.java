/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;

class BasicPermissionCollection
extends PermissionCollection {
    private static final long serialVersionUID = 739301742472979399L;
    boolean all_allowed = false;
    Hashtable permissions = new Hashtable(8);

    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new IllegalStateException();
        }
        String string = permission.getName();
        this.all_allowed = this.all_allowed || string.equals("*");
        this.permissions.put(string, permission);
    }

    public Enumeration elements() {
        return this.permissions.elements();
    }

    public boolean implies(Permission permission) {
        if (this.all_allowed) {
            return true;
        }
        String string = permission.getName();
        if (this.permissions.get(string) != null) {
            return true;
        }
        int n = string.lastIndexOf(46);
        while (n >= 0) {
            if (n + 1 == string.length()) {
                return false;
            }
            if (this.permissions.get(String.valueOf(string = string.substring(0, n)) + ".*") != null) {
                return true;
            }
            n = string.lastIndexOf(46);
        }
        return false;
    }
}

