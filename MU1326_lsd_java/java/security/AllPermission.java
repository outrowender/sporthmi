/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.AllPermissionCollection;
import java.security.Permission;
import java.security.PermissionCollection;

public final class AllPermission
extends Permission {
    private static final long serialVersionUID = -2916474571451318075L;

    public AllPermission() {
        super("<all permissions>");
    }

    public AllPermission(String string, String string2) {
        super("<all permissions>");
    }

    public boolean equals(Object object) {
        return object instanceof AllPermission;
    }

    public String getActions() {
        return "<all actions>";
    }

    public int hashCode() {
        return 1;
    }

    public boolean implies(Permission permission) {
        return true;
    }

    public PermissionCollection newPermissionCollection() {
        return new AllPermissionCollection();
    }
}

