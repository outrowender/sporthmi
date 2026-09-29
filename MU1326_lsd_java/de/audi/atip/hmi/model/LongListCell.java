/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListCell;

public class LongListCell
implements ListCell {
    private long value;

    public LongListCell(long l) {
        this.value = l;
    }

    public void setValue(long l) {
        this.value = l;
    }

    public long getValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof LongListCell)) {
            return false;
        }
        return this.value == ((LongListCell)object).value;
    }

    public int hashCode() {
        return (int)(this.value ^ this.value >>> 32);
    }

    public String toString() {
        return Long.toString(this.value);
    }
}

