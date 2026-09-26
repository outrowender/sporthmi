/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.esolutions.fw.util.commons.Buffer;

public class SelectedItem {
    private final int index;
    private final long uniqueID;

    public SelectedItem(int n, long l) {
        this.index = n;
        this.uniqueID = l;
    }

    public int getIndex() {
        return this.index;
    }

    public long getUniqueID() {
        return this.uniqueID;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.index;
        n = 31 * n + (int)(this.uniqueID ^ this.uniqueID >>> 32);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof SelectedItem)) {
            return false;
        }
        SelectedItem selectedItem = (SelectedItem)object;
        return this.index == selectedItem.index && this.uniqueID == selectedItem.uniqueID;
    }

    public String toString() {
        Buffer buffer = new Buffer(50);
        buffer.append("SelectedItem Id: ").append(this.uniqueID).append(" index: ").append(this.index);
        return buffer.toString();
    }
}

