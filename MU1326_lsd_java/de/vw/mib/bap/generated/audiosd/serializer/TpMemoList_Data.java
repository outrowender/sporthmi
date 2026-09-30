/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_ATTRIBUTES_MESSAGE_TIME_HOUR_MESSAGE_TIME_MINUTE_STATION_NAME = 0;
    public static final int RECORD_ADDRESS_ATTRIBUTES_MESSAGE_TIME_HOUR_MESSAGE_TIME_MINUTE = 1;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public final Attributes attributes;
    public int messageTime_Hour;
    private static final int MESSAGE_TIME_HOUR_BITSIZE = 8;
    public int messageTime_Minute;
    private static final int MESSAGE_TIME_MINUTE_BITSIZE = 8;
    public final BAPString stationName;
    private static final int MAX_STATION_NAME_LENGTH = 49;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }

    public TpMemoList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new Attributes();
        this.stationName = new BAPString(49);
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.messageTime_Hour = 0;
        this.messageTime_Minute = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.stationName.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoList_Data tpMemoList_Data = (TpMemoList_Data)bAPEntity;
        return this.arrayHeader.equalTo(tpMemoList_Data.arrayHeader) && this.pos == tpMemoList_Data.pos && this.attributes.equalTo(tpMemoList_Data.attributes) && this.messageTime_Hour == tpMemoList_Data.messageTime_Hour && this.messageTime_Minute == tpMemoList_Data.messageTime_Minute && this.stationName.equalTo(tpMemoList_Data.stationName);
    }

    private void customInitialization() {
        this.stationName.setLimitingLengthByCharacters();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TpMemoList_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - Attributes - ");
        stringBuffer.append(this.attributes.toString());
        stringBuffer.append("\n - MessageTime_Hour - ");
        stringBuffer.append(this.messageTime_Hour);
        stringBuffer.append("\n - MessageTime_Minute - ");
        stringBuffer.append(this.messageTime_Minute);
        stringBuffer.append("\n - StationName - ");
        stringBuffer.append(this.stationName.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.attributes.bitSize();
                n += 8;
                n += 8;
                n += this.stationName.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.attributes.bitSize();
                n += 8;
                n += 8;
                break;
            }
            case 15: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                break;
            }
        }
        return n;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.messageTime_Hour);
                bitStream.pushByte((byte)this.messageTime_Minute);
                this.stationName.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.messageTime_Hour);
                bitStream.pushByte((byte)this.messageTime_Minute);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                this.messageTime_Hour = bitStream.popFrontByte();
                this.messageTime_Minute = bitStream.popFrontByte();
                this.stationName.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                this.messageTime_Hour = bitStream.popFrontByte();
                this.messageTime_Minute = bitStream.popFrontByte();
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    public static final class Attributes
    implements BAPEntity {
        private static final int RESERVED_BIT_3__7_BITSIZE = 5;
        public boolean reserved_bit_2;
        public boolean reserved_bit_1;
        public boolean newMessage;
        private static final int ATTRIBUTES_BITSIZE = 8;

        public Attributes() {
            this.internalReset();
            this.customInitialization();
        }

        public Attributes(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_2 = false;
            this.reserved_bit_1 = false;
            this.newMessage = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Attributes attributes = (Attributes)bAPEntity;
            return this.reserved_bit_2 == attributes.reserved_bit_2 && this.reserved_bit_1 == attributes.reserved_bit_1 && this.newMessage == attributes.newMessage;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attributes:");
            stringBuffer.append("\n - Bit 2: ");
            if (this.reserved_bit_2) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.reserved_bit_1) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.newMessage) {
                stringBuffer.append("true  (new message");
            } else {
                stringBuffer.append("false  (message is not new");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(5);
            bitStream.pushBoolean(this.reserved_bit_2);
            bitStream.pushBoolean(this.reserved_bit_1);
            bitStream.pushBoolean(this.newMessage);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(5);
            this.reserved_bit_2 = bitStream.popFrontBoolean();
            this.reserved_bit_1 = bitStream.popFrontBoolean();
            this.newMessage = bitStream.popFrontBoolean();
        }
    }
}

