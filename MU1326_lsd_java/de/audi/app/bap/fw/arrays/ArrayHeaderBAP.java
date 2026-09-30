/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.vw.mib.bap.datatypes.ArrayHeader;

public class ArrayHeaderBAP
implements IArrayHeader {
    private final ArrayHeader arrayHeader;

    public ArrayHeaderBAP() {
        this.arrayHeader = new ArrayHeader();
    }

    public ArrayHeaderBAP(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setStart(int n) {
        this.arrayHeader.start = n;
    }

    public int getStart() {
        return this.arrayHeader.start;
    }

    public int getStartOffset() {
        return 0;
    }

    public int getNumberOfElements() {
        return this.arrayHeader.elements;
    }

    public boolean isModeShift() {
        return this.arrayHeader.mode.shift;
    }

    public boolean isModeArrayDirectionBackward() {
        return this.arrayHeader.mode.arrayDirectionIsBackward;
    }

    public boolean isModePositionTransmitted() {
        return this.arrayHeader.mode.arrayPositionIsTransmitted;
    }

    public boolean isModeIndexSize16Bit() {
        return this.arrayHeader.mode.indexSize16BitForStartElements;
    }

    public int getRecordAddress() {
        return this.arrayHeader.getRecordAddress();
    }

    public void setRecordAddress(int n) {
        this.arrayHeader.setRecordAddress(n);
    }

    public int getJobID() {
        return -1;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.arrayHeader.elements;
        n = 31 * n + (this.arrayHeader.mode == null ? 0 : ArrayHeaderBAP.modeHashCode(this.arrayHeader.mode));
        n = 31 * n + this.arrayHeader.getRecordAddress();
        n = 31 * n + this.arrayHeader.getSerializationRecordAddress();
        n = 31 * n + this.arrayHeader.start;
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
        ArrayHeader arrayHeader = ((ArrayHeaderBAP)object).arrayHeader;
        if (this.arrayHeader.elements != arrayHeader.elements) {
            return false;
        }
        if (this.arrayHeader.mode == null ? arrayHeader.mode != null : !this.modeEquals(this.arrayHeader.mode, arrayHeader.mode)) {
            return false;
        }
        if (this.arrayHeader.getRecordAddress() != arrayHeader.getRecordAddress()) {
            return false;
        }
        if (this.arrayHeader.getSerializationRecordAddress() != arrayHeader.getSerializationRecordAddress()) {
            return false;
        }
        return this.arrayHeader.start == arrayHeader.start;
    }

    private static int modeHashCode(ArrayHeader.Mode mode) {
        int n = 1;
        n = 31 * n + (mode.arrayDirectionIsBackward ? 1231 : 1237);
        n = 31 * n + (mode.arrayPositionIsTransmitted ? 1231 : 1237);
        n = 31 * n + (mode.indexSize16BitForStartElements ? 1231 : 1237);
        n = 31 * n + (mode.shift ? 1231 : 1237);
        return n;
    }

    private boolean modeEquals(ArrayHeader.Mode mode, ArrayHeader.Mode mode2) {
        if (mode.equals(mode2)) {
            return true;
        }
        if (mode2 == null) {
            return false;
        }
        if (mode.getClass() != mode2.getClass()) {
            return false;
        }
        ArrayHeader.Mode mode3 = mode2;
        if (mode.arrayDirectionIsBackward != mode3.arrayDirectionIsBackward) {
            return false;
        }
        if (mode.arrayPositionIsTransmitted != mode3.arrayPositionIsTransmitted) {
            return false;
        }
        if (mode.indexSize16BitForStartElements != mode3.indexSize16BitForStartElements) {
            return false;
        }
        return mode.shift == mode3.shift;
    }
}

