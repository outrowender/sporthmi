/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class UnresolvedPermissionCollection
extends PermissionCollection {
    private static final long serialVersionUID = -7176153071733132400L;
    Hashtable permissions = new Hashtable(8);

    UnresolvedPermissionCollection() {
    }

    public void add(Permission permission) {
        if (this.isReadOnly()) {
            throw new IllegalStateException();
        }
        Vector vector = (Vector)this.permissions.get(permission.getName());
        if (vector == null) {
            vector = new Vector();
            this.permissions.put(permission.getName(), vector);
        }
        vector.addElement(permission);
    }

    public Enumeration elements() {
        return new Enumeration(){
            Enumeration vEnum;
            Enumeration pEnum;
            Object next;
            {
                this.pEnum = UnresolvedPermissionCollection.this.permissions.elements();
                this.next = this.findNext();
            }

            private Object findNext() {
                if (this.vEnum != null && this.vEnum.hasMoreElements()) {
                    return this.vEnum.nextElement();
                }
                if (!this.pEnum.hasMoreElements()) {
                    return null;
                }
                this.vEnum = ((Vector)this.pEnum.nextElement()).elements();
                return this.vEnum.nextElement();
            }

            public boolean hasMoreElements() {
                return this.next != null;
            }

            public Object nextElement() {
                Object object = this.next;
                this.next = this.findNext();
                return object;
            }
        };
    }

    public boolean implies(Permission permission) {
        return false;
    }

    Vector getPermissions(String string) {
        return (Vector)this.permissions.get(string);
    }
}

