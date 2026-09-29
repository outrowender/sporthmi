/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.fw.util.commons.Buffer;

public class PropertyListCell
implements ListCell {
    public static final PropertyListCell EMPTY_CELL = new PropertyListCell(-1, new int[0]);
    private final int category;
    private final int[] properties;

    public static PropertyListCell create(int n, int[] nArray) {
        return new PropertyListCell(n, nArray);
    }

    public PropertyListCell(int n, int[] nArray) {
        this.category = n;
        this.properties = nArray;
    }

    public int getCategory() {
        return this.category;
    }

    public int[] getProperties() {
        return this.properties;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("category: ").append(this.category);
        buffer.append(", properties: ");
        if (this.properties != null) {
            for (int i2 = 0; i2 < this.properties.length; ++i2) {
                buffer.append(", ").append(this.properties[i2]);
            }
        } else {
            buffer.append(this.properties);
        }
        return buffer.toString();
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof PropertyListCell)) {
            return false;
        }
        int n = ((PropertyListCell)object).category;
        if (this.category == n) {
            int[] nArray = ((PropertyListCell)object).properties;
            if (this.properties != null && nArray != null && this.properties.length == nArray.length) {
                for (int i2 = 0; i2 < this.properties.length; ++i2) {
                    if (this.properties[i2] == nArray[i2]) continue;
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n = this.category;
        if (this.properties != null) {
            n += this.properties.hashCode();
        }
        return n;
    }
}

