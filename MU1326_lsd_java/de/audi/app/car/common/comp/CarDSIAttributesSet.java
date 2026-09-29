/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.comp;

import de.esolutions.fw.util.commons.Buffer;

public class CarDSIAttributesSet {
    private final int id;
    private int[] primaryAttributes;
    private boolean[] primaryAttributesReceived;
    private int[] secondaryAttributes;
    private boolean secondaryAttributesRequested;

    public CarDSIAttributesSet(int n, int[] nArray, int[] nArray2) {
        this.primaryAttributes = nArray;
        this.primaryAttributesReceived = new boolean[nArray.length];
        this.secondaryAttributes = nArray2;
        this.id = n;
    }

    public void reset() {
        this.primaryAttributesReceived = new boolean[this.primaryAttributes.length];
        this.secondaryAttributesRequested = false;
    }

    public void setSecondaryAttributesRequested() {
        this.secondaryAttributesRequested = true;
    }

    public boolean areSecondaryAttributesRequested() {
        return this.secondaryAttributesRequested;
    }

    public int getID() {
        return this.id;
    }

    public int[] getPrimaryAttributes() {
        return this.primaryAttributes;
    }

    public int[] getSecondaryAttributes() {
        return this.secondaryAttributes;
    }

    public boolean hasPrimaryAttributes() {
        return this.primaryAttributes != null && this.primaryAttributes.length > 0;
    }

    public boolean hasSecondaryAttributes() {
        return this.secondaryAttributes != null && this.secondaryAttributes.length > 0;
    }

    public void setPrimaryAttributeReceived(int n) {
        for (int i2 = 0; i2 < this.primaryAttributes.length; ++i2) {
            if (this.primaryAttributes[i2] != n) continue;
            this.primaryAttributesReceived[i2] = true;
        }
    }

    public boolean allPrimaryAttributesReceived() {
        for (int i2 = 0; i2 < this.primaryAttributesReceived.length; ++i2) {
            if (this.primaryAttributesReceived[i2]) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        int n;
        Buffer buffer = new Buffer(100);
        buffer.append("CarDSIAttributesSet(id=").append(this.id).append(",primAttr=(");
        for (n = 0; n < this.primaryAttributes.length; ++n) {
            buffer.append("(attr=").append(this.primaryAttributes[n]).append(",reci=").append(this.primaryAttributesReceived[n]).append(")");
        }
        buffer.append("),secAttr=(");
        for (n = 0; n < this.secondaryAttributes.length; ++n) {
            buffer.append("(attr=").append(this.secondaryAttributes[n]).append(")");
        }
        buffer.append("),secReq=").append(this.secondaryAttributesRequested).append(")");
        return buffer.toString();
    }
}

