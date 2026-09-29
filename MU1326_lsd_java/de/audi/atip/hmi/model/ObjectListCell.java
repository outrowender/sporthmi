/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListCell;

public class ObjectListCell
implements ListCell {
    public final Object value;

    public ObjectListCell(Object object) {
        this.value = object;
    }

    public String toString() {
        if (this.value == null) {
            return "null";
        }
        return this.value.toString();
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof ObjectListCell)) {
            return false;
        }
        Object object2 = ((ObjectListCell)object).value;
        if (this.value == null) {
            return this.value == null && object2 == null;
        }
        return this.value.equals(object2);
    }

    public int hashCode() {
        return this.value == null ? 0 : this.value.hashCode();
    }

    public Object getValue() {
        return this.value;
    }
}

