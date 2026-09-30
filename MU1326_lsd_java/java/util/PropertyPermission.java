/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.PropertyPermissionCollection;
import java.util.StringTokenizer;

public final class PropertyPermission
extends BasicPermission {
    private static final long serialVersionUID = 885438825399942851L;
    private transient boolean read;
    private transient boolean write;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[1];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("actions", clazz);
        serialPersistentFields = objectStreamFieldArray;
    }

    public PropertyPermission(String string, String string2) {
        super(string);
        this.decodeActions(string2);
    }

    private void decodeActions(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string.toLowerCase(), " \t\n\r,");
        while (stringTokenizer.hasMoreTokens()) {
            String string2 = stringTokenizer.nextToken();
            if (string2.equals("read")) {
                this.read = true;
                continue;
            }
            if (string2.equals("write")) {
                this.write = true;
                continue;
            }
            throw new IllegalArgumentException();
        }
        if (!this.read && !this.write) {
            throw new IllegalArgumentException();
        }
    }

    public boolean equals(Object object) {
        if (super.equals(object)) {
            PropertyPermission propertyPermission = (PropertyPermission)object;
            return this.read == propertyPermission.read && this.write == propertyPermission.write;
        }
        return false;
    }

    public String getActions() {
        return this.read ? (this.write ? "read,write" : "read") : "write";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean implies(Permission permission) {
        if (super.implies(permission)) {
            PropertyPermission propertyPermission = (PropertyPermission)permission;
            return !(!this.read && propertyPermission.read || !this.write && propertyPermission.write);
        }
        return false;
    }

    public PermissionCollection newPermissionCollection() {
        return new PropertyPermissionCollection();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putField = objectOutputStream.putFields();
        putField.put("actions", this.getActions());
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField getField = objectInputStream.readFields();
        String string = (String)getField.get("actions", "");
        this.decodeActions(string);
    }
}

