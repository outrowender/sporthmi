/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.IArrayHeader;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.ArrayHeader$Mode;

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

    @Override
    public void setStart(int n) {
        this.arrayHeader.start = n;
    }

    @Override
    public int getStart() {
        return this.arrayHeader.start;
    }

    @Override
    public int getStartOffset() {
        return 0;
    }

    @Override
    public int getNumberOfElements() {
        return this.arrayHeader.elements;
    }

    @Override
    public boolean isModeShift() {
        return this.arrayHeader.mode.shift;
    }

    @Override
    public boolean isModeArrayDirectionBackward() {
        return this.arrayHeader.mode.arrayDirectionIsBackward;
    }

    @Override
    public boolean isModePositionTransmitted() {
        return this.arrayHeader.mode.arrayPositionIsTransmitted;
    }

    @Override
    public boolean isModeIndexSize16Bit() {
        return this.arrayHeader.mode.indexSize16BitForStartElements;
    }

    @Override
    public int getRecordAddress() {
        return this.arrayHeader.getRecordAddress();
    }

    @Override
    public void setRecordAddress(int n) {
        this.arrayHeader.setRecordAddress(n);
    }

    @Override
    public int getJobID() {
        return -1;
    }

    @Override
    public int hashCode() {
        int n = 1;
        n = 31 * n + this.arrayHeader.elements;
        n = 31 * n + (this.arrayHeader.mode == null ? 0 : ArrayHeaderBAP.modeHashCode(this.arrayHeader.mode));
        n = 31 * n + this.arrayHeader.getRecordAddress();
        n = 31 * n + this.arrayHeader.getSerializationRecordAddress();
        n = 31 * n + this.arrayHeader.start;
        return n;
    }

    @Override
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

    private static int modeHashCode(ArrayHeader$Mode arrayHeader$Mode) {
        int n = 1;
        n = 31 * n + (arrayHeader$Mode.arrayDirectionIsBackward ? 1231 : 1237);
        n = 31 * n + (arrayHeader$Mode.arrayPositionIsTransmitted ? 1231 : 1237);
        n = 31 * n + (arrayHeader$Mode.indexSize16BitForStartElements ? 1231 : 1237);
        n = 31 * n + (arrayHeader$Mode.shift ? 1231 : 1237);
        return n;
    }

    private boolean modeEquals(ArrayHeader$Mode arrayHeader$Mode, ArrayHeader$Mode arrayHeader$Mode2) {
        if (arrayHeader$Mode.equals(arrayHeader$Mode2)) {
            return true;
        }
        if (arrayHeader$Mode2 == null) {
            return false;
        }
        if (super.getClass() != super.getClass()) {
            return false;
        }
        ArrayHeader$Mode arrayHeader$Mode3 = arrayHeader$Mode2;
        if (arrayHeader$Mode.arrayDirectionIsBackward != arrayHeader$Mode3.arrayDirectionIsBackward) {
            return false;
        }
        if (arrayHeader$Mode.arrayPositionIsTransmitted != arrayHeader$Mode3.arrayPositionIsTransmitted) {
            return false;
        }
        if (arrayHeader$Mode.indexSize16BitForStartElements != arrayHeader$Mode3.indexSize16BitForStartElements) {
            return false;
        }
        return arrayHeader$Mode.shift == arrayHeader$Mode3.shift;
    }
}

