/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ArrayHeader
implements BAPEntity {
    public final Mode mode = new Mode();
    private int recordAddress;
    private int serializationRecordAddress;
    public static final int RECORD_ADDRESS_POS = 15;
    public static final int RECORD_ADDRESS_COMPLETE = 0;
    private static final int RECORD_ADDRESS_BITSIZE = 4;
    public int start;
    public static final int FIRST_BAP_POS = 0;
    private static final int START_BITSIZE = 8;
    private static final int START_LONG_BITSIZE = 16;
    public int elements;
    private static final int ELEMENTS_BITSIZE = 8;
    private static final int ELEMENTS_LONG_BITSIZE = 16;
    private static final int POS_BITSIZE = 8;
    private static final int POS_LONG_BITSIZE = 16;
    private static final int FULL_RANGE_UPDATE_ELEMENTS = 65535;
    private static final int ONE_ELEMENT_CHANGE_NUMBER = 1;
    private int _setGetRequestType;
    public static final int REQUEST_TYPE_UNKNOWN = 0;
    public static final int REQUEST_TYPE_MODIFY = 1;
    public static final int REQUEST_TYPE_INSERT = 2;
    public static final int REQUEST_TYPE_DELETE = 3;

    public ArrayHeader() {
        this.internalReset();
    }

    public ArrayHeader(ArrayHeader arrayHeader) {
        this();
        this.copy(arrayHeader);
    }

    public ArrayHeader(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.recordAddress = 0;
        this.serializationRecordAddress = 0;
        this.start = 0;
        this.elements = 0;
    }

    public void reset() {
        this.internalReset();
        this.mode.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ArrayHeader arrayHeader = (ArrayHeader)bAPEntity;
        return this.recordAddress == arrayHeader.recordAddress && this.serializationRecordAddress == arrayHeader.serializationRecordAddress && this.start == arrayHeader.start && this.elements == arrayHeader.elements && this.mode.equalTo(arrayHeader.mode);
    }

    public int getNumberOfElements() {
        return this.elements;
    }

    public boolean isFullRangeUpdate() {
        return this.mode.is16BitsIndexSize() ? this.elements == 65535 : this.elements == 255;
    }

    public void setFullRangeUpdate(boolean bl) {
        this.start = 0;
        this.mode.shift = false;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = false;
        this.setRecordAddress(0);
        this.elements = bl ? 65535 : 255;
        this.mode.indexSize16BitForStartElements = bl;
    }

    public boolean dataElementsExists() {
        return !this.isFullRangeUpdate() && this.mode.arrayPositionIsTransmitted;
    }

    public void setElementsChangedBlockRequest(int n, int n2, boolean bl, int n3) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = false;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = true;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(n3, 15);
    }

    public boolean isElementsChangedBlockRequest() {
        return !this.mode.shift && !this.mode.arrayDirectionIsBackward && this.mode.arrayPositionIsTransmitted && this.getRecordAddress() != 15;
    }

    public void setElementChangedRequest(int n, boolean bl, int n2) {
        this.start = n;
        this.elements = 1;
        this.mode.shift = false;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = false;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(n2, 15);
    }

    public boolean isElementChangedRequest() {
        return !this.mode.shift && !this.mode.arrayPositionIsTransmitted && this.elements == 1 && this.getRecordAddress() != 15;
    }

    public void setElementsDeleteBlockRequest(int n, int n2, boolean bl) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = true;
        this.mode.arrayPositionIsTransmitted = true;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(15);
    }

    public boolean isElementsDeleteBlockRequest() {
        return this.mode.shift && this.mode.arrayDirectionIsBackward && this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 15;
    }

    public void setElementsDeleteRangeRequest(int n, int n2, boolean bl) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = true;
        this.mode.arrayPositionIsTransmitted = false;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(0);
    }

    public boolean isElementsDeleteRangeRequest() {
        return this.mode.shift && this.mode.arrayDirectionIsBackward && !this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 0;
    }

    public void setElementsInsertedBlockRequest(int n, int n2, boolean bl) {
        this.start = n;
        this.elements = n2;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = true;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(15);
    }

    public boolean isElementsInsertedBlockRequest() {
        return this.mode.shift && !this.mode.arrayDirectionIsBackward && this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 15;
    }

    public void setElementInsertedRequest(int n, boolean bl) {
        this.start = n;
        this.elements = 1;
        this.mode.shift = true;
        this.mode.arrayDirectionIsBackward = false;
        this.mode.arrayPositionIsTransmitted = false;
        this.mode.indexSize16BitForStartElements = bl;
        this.setRecordAddress(0);
    }

    public boolean isElementInsertedRequest() {
        return this.elements == 1 && this.mode.shift && !this.mode.arrayDirectionIsBackward && !this.mode.arrayPositionIsTransmitted && this.getRecordAddress() == 0;
    }

    public void setSetGetRequestChangeType(int n) {
        this._setGetRequestType = n;
    }

    public boolean isSetGetModifyRequest() {
        return this._setGetRequestType == 1;
    }

    public boolean isSetGetInsertRequest() {
        return this._setGetRequestType == 2;
    }

    public boolean isSetGetDeleteRequest() {
        return this._setGetRequestType == 3;
    }

    public int getRecordAddress() {
        return this.recordAddress;
    }

    public void setRecordAddress(int n) {
        this.recordAddress = n;
        this.serializationRecordAddress = n;
    }

    public void setRecordAddress(int n, int n2) {
        this.recordAddress = n;
        this.serializationRecordAddress = n2;
    }

    public int getSerializationRecordAddress() {
        return this.serializationRecordAddress;
    }

    public void serializePosOfArrayElement(BitStream bitStream, BAPArrayElement bAPArrayElement) {
        if (this.mode.arrayPositionIsTransmitted || this.serializationRecordAddress == 15) {
            if (this.mode.is16BitsIndexSize()) {
                bitStream.pushShort((short)bAPArrayElement.getPos());
            } else {
                bitStream.pushByte((byte)bAPArrayElement.getPos());
            }
        }
    }

    public void deserializePosOfArrayElement(BitStream bitStream, BAPArrayElement bAPArrayElement) {
        if (this.mode.arrayPositionIsTransmitted || this.serializationRecordAddress == 15) {
            if (this.mode.is16BitsIndexSize()) {
                bAPArrayElement.setPos(bitStream.popFrontShort());
            } else {
                bAPArrayElement.setPos(bitStream.popFrontByte());
            }
        }
    }

    public int bitSizeOfPosArrayElement() {
        return this.mode.is16BitsIndexSize() ? 16 : 8;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ArrayHeader:");
        stringBuffer.append("\n - Mode - ");
        stringBuffer.append(this.mode.toString());
        stringBuffer.append("\n - RecordAddress: ");
        stringBuffer.append(this.recordAddress);
        stringBuffer.append("\n - Start - ");
        stringBuffer.append(this.start);
        stringBuffer.append("\n - Elements - ");
        stringBuffer.append(this.elements);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.mode.bitSize();
        n += 4;
        if (this.mode.is16BitsIndexSize()) {
            n += 16;
            n += 16;
        } else {
            n += 8;
            n += 8;
        }
        return n;
    }

    public void serialize(BitStream bitStream) {
        this.mode.serialize(bitStream);
        bitStream.pushBits(4, this.recordAddress);
        if (this.mode.is16BitsIndexSize()) {
            bitStream.pushShort((short)this.start);
            bitStream.pushShort((short)this.elements);
        } else {
            bitStream.pushByte((byte)this.start);
            bitStream.pushByte((byte)this.elements);
        }
    }

    public void deserialize(BitStream bitStream) {
        this.mode.deserialize(bitStream);
        this.setRecordAddress(bitStream.popFrontBits(4));
        if (this.mode.is16BitsIndexSize()) {
            this.start = bitStream.popFrontShort();
            this.elements = bitStream.popFrontShort();
        } else {
            this.start = bitStream.popFrontByte();
            this.elements = bitStream.popFrontByte();
        }
    }

    public void evaluateRecordAddressPosForChangedArray() {
        this.setRecordAddress(this.getRecordAddress(), 15);
    }

    public void copy(ArrayHeader arrayHeader) {
        this._setGetRequestType = arrayHeader._setGetRequestType;
        this.elements = arrayHeader.elements;
        this.recordAddress = arrayHeader.recordAddress;
        this.serializationRecordAddress = arrayHeader.serializationRecordAddress;
        this.start = arrayHeader.start;
        this.mode.copy(arrayHeader.mode);
    }

    public static final class Mode
    implements BAPEntity {
        public boolean indexSize16BitForStartElements;
        public boolean arrayPositionIsTransmitted;
        public boolean arrayDirectionIsBackward;
        public boolean shift;
        private static final int MODE_BITSIZE = 4;

        public boolean is16BitsIndexSize() {
            return this.indexSize16BitForStartElements;
        }

        public Mode() {
            this.internalReset();
        }

        public Mode(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.indexSize16BitForStartElements = false;
            this.arrayPositionIsTransmitted = false;
            this.arrayDirectionIsBackward = false;
            this.shift = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Mode mode = (Mode)bAPEntity;
            return this.indexSize16BitForStartElements == mode.indexSize16BitForStartElements && this.arrayPositionIsTransmitted == mode.arrayPositionIsTransmitted && this.arrayDirectionIsBackward == mode.arrayDirectionIsBackward && this.shift == mode.shift;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Mode:");
            stringBuffer.append("\n - Bit 3: ");
            if (this.indexSize16BitForStartElements) {
                stringBuffer.append("true  (IndexSize 16 Bit for Start/Elements");
            } else {
                stringBuffer.append("false  (IndexSize 8 Bit for Start/Elements");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.arrayPositionIsTransmitted) {
                stringBuffer.append("true  (Array position is transmitted");
            } else {
                stringBuffer.append("false  (Array position is not transmitted");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.arrayDirectionIsBackward) {
                stringBuffer.append("true  (Array direction is backward");
            } else {
                stringBuffer.append("false  (Array direction is forward");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.shift) {
                stringBuffer.append("true  (Shift");
            } else {
                stringBuffer.append("false  (Shift");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 4;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.indexSize16BitForStartElements);
            bitStream.pushBoolean(this.arrayPositionIsTransmitted);
            bitStream.pushBoolean(this.arrayDirectionIsBackward);
            bitStream.pushBoolean(this.shift);
        }

        public void deserialize(BitStream bitStream) {
            this.indexSize16BitForStartElements = bitStream.popFrontBoolean();
            this.arrayPositionIsTransmitted = bitStream.popFrontBoolean();
            this.arrayDirectionIsBackward = bitStream.popFrontBoolean();
            this.shift = bitStream.popFrontBoolean();
        }

        public void copy(Mode mode) {
            this.arrayDirectionIsBackward = mode.arrayDirectionIsBackward;
            this.arrayPositionIsTransmitted = mode.arrayPositionIsTransmitted;
            this.indexSize16BitForStartElements = mode.indexSize16BitForStartElements;
            this.shift = mode.shift;
        }
    }
}

