/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.fw.arrays.fastlist;

import de.audi.app.bap.fw.arrays.IArrayHeader;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public class ArrayHeaderFastList
implements IArrayHeader {
    private static final int MASK_MODE_SHIFT = 1;
    private static final int MASK_MODE_ARRAY_DIRECTION_IS_BACKWARD = 2;
    private static final int MASK_MODE_ARRAY_POSITION_IS_TRANSMITTED = 4;
    private static final int MASK_MODE_INDEX_SIZE_16_BITS = 8;
    private final ArrayHeader arrayHeader;

    public ArrayHeaderFastList() {
        this.arrayHeader = new ArrayHeader();
    }

    public ArrayHeaderFastList(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setStart(int n) {
        this.arrayHeader.start = n;
    }

    public int getStart() {
        return (int)this.arrayHeader.getStart();
    }

    public int getStartOffset() {
        return this.arrayHeader.getRelativeJump();
    }

    public int getNumberOfElements() {
        return this.arrayHeader.getElements();
    }

    public boolean isModeShift() {
        return (this.arrayHeader.getMode() & 1) > 0;
    }

    public boolean isModeArrayDirectionBackward() {
        return (this.arrayHeader.getMode() & 2) > 0;
    }

    public boolean isModePositionTransmitted() {
        return (this.arrayHeader.getMode() & 4) > 0;
    }

    public boolean isModeIndexSize16Bit() {
        return (this.arrayHeader.getMode() & 8) > 0;
    }

    public int getRecordAddress() {
        return this.arrayHeader.getRecordAddress();
    }

    public void setRecordAddress(int n) {
        this.arrayHeader.recordAddress = n;
    }

    public int getJobID() {
        return this.arrayHeader.getJobID();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.arrayHeader.absoluteListPos;
        n = 31 * n + this.arrayHeader.elements;
        n = 31 * n + this.arrayHeader.jobID;
        n = 31 * n + this.arrayHeader.jobModification;
        n = 31 * n + this.arrayHeader.jobPriority;
        n = 31 * n + this.arrayHeader.mode;
        n = 31 * n + this.arrayHeader.recordAddress;
        n = 31 * n + this.arrayHeader.relativeJump;
        n = 31 * n + (int)(this.arrayHeader.start ^ this.arrayHeader.start >>> 32);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        ArrayHeader arrayHeader = ((ArrayHeaderFastList)object).arrayHeader;
        if (this.arrayHeader.absoluteListPos != arrayHeader.absoluteListPos) {
            return false;
        }
        if (this.arrayHeader.elements != arrayHeader.elements) {
            return false;
        }
        if (this.arrayHeader.jobID != arrayHeader.jobID) {
            return false;
        }
        if (this.arrayHeader.jobModification != arrayHeader.jobModification) {
            return false;
        }
        if (this.arrayHeader.jobPriority != arrayHeader.jobPriority) {
            return false;
        }
        if (this.arrayHeader.mode != arrayHeader.mode) {
            return false;
        }
        if (this.arrayHeader.recordAddress != arrayHeader.recordAddress) {
            return false;
        }
        if (this.arrayHeader.relativeJump != arrayHeader.relativeJump) {
            return false;
        }
        return this.arrayHeader.start == arrayHeader.start;
    }
}

