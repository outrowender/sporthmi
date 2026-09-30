/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.FilePermission;
import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Vector;

final class FilePermissionCollection
extends PermissionCollection
implements Serializable {
    private static final long serialVersionUID = 2202956749081564585L;
    Vector permissions = new Vector();

    public void add(Permission permission) {
        if (!this.isReadOnly()) {
            if (!(permission instanceof FilePermission)) {
                throw new IllegalArgumentException(permission.toString());
            }
        } else {
            throw new IllegalStateException();
        }
        this.permissions.addElement(permission);
    }

    public Enumeration elements() {
        return this.permissions.elements();
    }

    public boolean implies(Permission permission) {
        if (permission instanceof FilePermission) {
            FilePermission filePermission = (FilePermission)permission;
            int n = 0;
            int n2 = 0;
            while (n2 < this.permissions.size() && (n & filePermission.mask) != filePermission.mask) {
                n |= ((FilePermission)this.permissions.elementAt(n2)).impliesMask(permission);
                ++n2;
            }
            return (n & filePermission.mask) == filePermission.mask;
        }
        return false;
    }
}

