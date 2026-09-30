/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PermissionsHash;
import java.security.UnresolvedPermission;
import java.security.UnresolvedPermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Vector;

public final class Permissions
extends PermissionCollection
implements Serializable {
    private static final long serialVersionUID = 4858622370623524688L;
    Hashtable perms = new Hashtable(8);
    PermissionCollection allPermission;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new SecurityException();
        }
        Class clazz = permission.getClass();
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.security.AllPermission");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if (clazz == clazz2) {
            this.allPermission = this.findCollection(permission);
            this.allPermission.add(permission);
        } else {
            this.findCollection(permission).add(permission);
        }
    }

    public Enumeration elements() {
        PermissionsEnumeration permissionsEnumeration = new PermissionsEnumeration();
        return permissionsEnumeration;
    }

    private PermissionCollection findCollection(Permission permission) {
        Class clazz = permission.getClass();
        PermissionCollection permissionCollection = (PermissionCollection)this.perms.get(clazz);
        if (permissionCollection == null) {
            permissionCollection = permission.newPermissionCollection();
            if (permissionCollection == null) {
                permissionCollection = new PermissionsHash();
            }
            this.perms.put(clazz, permissionCollection);
        }
        return permissionCollection;
    }

    public boolean implies(Permission permission) {
        Vector vector;
        UnresolvedPermissionCollection unresolvedPermissionCollection;
        if (this.allPermission != null) {
            return true;
        }
        PermissionCollection permissionCollection = (PermissionCollection)this.perms.get(permission.getClass());
        if (permissionCollection != null) {
            return permissionCollection.implies(permission);
        }
        Class clazz = class$1;
        if (clazz == null) {
            try {
                clazz = class$1 = Class.forName("java.security.UnresolvedPermission");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if ((unresolvedPermissionCollection = (UnresolvedPermissionCollection)this.perms.get(clazz)) != null && (vector = unresolvedPermissionCollection.getPermissions(permission.getClass().getName())) != null) {
            Enumeration enumeration = vector.elements();
            while (enumeration.hasMoreElements()) {
                Permission permission2 = ((UnresolvedPermission)enumeration.nextElement()).resolve(permission.getClass().getClassLoader());
                if (permission2 == null) continue;
                permissionCollection = this.findCollection(permission2);
                permissionCollection.add(permission2);
            }
            if (permissionCollection != null) {
                return permissionCollection.implies(permission);
            }
        }
        return false;
    }

    private class PermissionsEnumeration
    implements Enumeration {
        Enumeration enumMap;
        PermissionCollection c;
        Enumeration enumC;
        Permission next;

        PermissionsEnumeration() {
            this.enumMap = Permissions.this.perms.elements();
            this.next = this.findNextPermission();
        }

        public boolean hasMoreElements() {
            return this.next != null;
        }

        public Object nextElement() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            Permission permission = this.next;
            this.next = this.findNextPermission();
            return permission;
        }

        private Permission findNextPermission() {
            while (this.c == null && this.enumMap.hasMoreElements()) {
                this.c = (PermissionCollection)this.enumMap.nextElement();
                this.enumC = this.c.elements();
                if (this.enumC.hasMoreElements()) continue;
                this.c = null;
            }
            if (this.c == null) {
                return null;
            }
            Permission permission = (Permission)this.enumC.nextElement();
            if (!this.enumC.hasMoreElements()) {
                this.c = null;
            }
            return permission;
        }
    }
}

