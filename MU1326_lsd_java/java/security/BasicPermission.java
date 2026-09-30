/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.BasicPermissionCollection;
import java.security.Permission;
import java.security.PermissionCollection;

public abstract class BasicPermission
extends Permission
implements Serializable {
    private static final long serialVersionUID = 6279438298436773498L;
    private transient String wildcard;

    public BasicPermission(String string) {
        super(string);
        int n = string.length();
        if (n > 1) {
            if (string.charAt(n - 1) == '*' && string.charAt(n - 2) == '.') {
                this.wildcard = string.substring(0, n - 1);
            }
        } else if (n == 1 && string.charAt(0) == '*') {
            this.wildcard = "";
        } else if (n == 0) {
            throw new IllegalArgumentException();
        }
    }

    public BasicPermission(String string, String string2) {
        this(string);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            return this.getName().equals(((BasicPermission)object).getName());
        }
        return false;
    }

    public String getActions() {
        return "";
    }

    public int hashCode() {
        return this.getName().hashCode();
    }

    public boolean implies(Permission permission) {
        if (this == permission) {
            return true;
        }
        if (permission != null && this.getClass() == permission.getClass()) {
            if (this.wildcard != null) {
                return permission.getName().startsWith(this.wildcard);
            }
            return permission.getName().equals(this.getName());
        }
        return false;
    }

    public PermissionCollection newPermissionCollection() {
        return new BasicPermissionCollection();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String string = this.getName();
        int n = string.length();
        if (n > 1) {
            if (string.charAt(n - 1) == '*' && string.charAt(n - 2) == '.') {
                this.wildcard = string.substring(0, n - 1);
            }
        } else if (n == 1 && string.charAt(0) == '*') {
            this.wildcard = "";
        }
    }
}

