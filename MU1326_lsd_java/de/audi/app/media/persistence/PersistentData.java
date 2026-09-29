/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.atip.util.Util;
import java.io.Serializable;

public class PersistentData
implements Serializable {
    private static final long serialVersionUID;
    public static final byte TYPE_BOOLEAN;
    public static final byte TYPE_INT;
    public static final byte TYPE_STRING;
    public static final PersistentData BOOLEAN_TRUE;
    public static final PersistentData BOOLEAN_FALSE;
    private final byte type;
    private final Object value;

    private PersistentData(byte by, Object object) {
        this.type = by;
        this.value = object;
    }

    public PersistentData(int n) {
        this(2, Util.createInteger(n));
    }

    public PersistentData(String string) {
        this(3, string);
    }

    public PersistentData(boolean bl) {
        this(1, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    public byte getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean getBoolean(boolean bl) {
        if (1 == this.type) {
            return (Boolean)this.value;
        }
        return bl;
    }

    public int getInt(int n) {
        if (2 == this.type) {
            return (Integer)this.value;
        }
        return n;
    }

    public String getString(String string) {
        if (3 == this.type && null != this.value) {
            return (String)this.value;
        }
        return string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        PersistentData persistentData = (PersistentData)object;
        if (this.type != persistentData.type) {
            return false;
        }
        return !(this.value == null ? persistentData.value != null : !this.value.equals(persistentData.value));
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.type;
        n = 31 * n + (this.value == null ? 0 : this.value.hashCode());
        return n;
    }

    static {
        BOOLEAN_TRUE = new PersistentData(1, Boolean.TRUE);
        BOOLEAN_FALSE = new PersistentData(1, Boolean.FALSE);
    }
}

