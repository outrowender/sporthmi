/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Map;

class MapEntry
implements Map.Entry,
Cloneable {
    Object key;
    Object value;

    MapEntry(Object object) {
        this.key = object;
    }

    MapEntry(Object object, Object object2) {
        this.key = object;
        this.value = object2;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry)object;
            return (this.key == null ? entry.getKey() == null : this.key.equals(entry.getKey())) && (this.value == null ? entry.getValue() == null : this.value.equals(entry.getValue()));
        }
        return false;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
    }

    public Object setValue(Object object) {
        Object object2 = this.value;
        this.value = object;
        return object2;
    }

    static interface Type {
        public Object get(MapEntry var1);
    }
}

