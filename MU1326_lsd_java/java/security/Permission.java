/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;
import java.security.Guard;
import java.security.PermissionCollection;

public abstract class Permission
implements Guard,
Serializable {
    private static final long serialVersionUID = -5636570222231596674L;
    private String name;

    public Permission(String string) {
        this.name = string;
    }

    public abstract boolean equals(Object var1);

    public abstract int hashCode();

    public void checkGuard(Object object) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(this);
        }
    }

    public abstract String getActions();

    public final String getName() {
        return this.name;
    }

    public abstract boolean implies(Permission var1);

    public PermissionCollection newPermissionCollection() {
        return null;
    }

    public String toString() {
        String string = this.getActions();
        return "(" + this.getClass().getName() + " " + this.getName() + " " + string + ")";
    }
}

