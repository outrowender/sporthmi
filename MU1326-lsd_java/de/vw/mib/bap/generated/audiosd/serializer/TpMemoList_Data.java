/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoList_Data$Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_ATTRIBUTES_MESSAGE_TIME_HOUR_MESSAGE_TIME_MINUTE_STATION_NAME;
    public static final int RECORD_ADDRESS_ATTRIBUTES_MESSAGE_TIME_HOUR_MESSAGE_TIME_MINUTE;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final TpMemoList_Data$Attributes attributes;
    public int messageTime_Hour;
    private static final int MESSAGE_TIME_HOUR_BITSIZE;
    public int messageTime_Minute;
    private static final int MESSAGE_TIME_MINUTE_BITSIZE;
    public final BAPString stationName;
    private static final int MAX_STATION_NAME_LENGTH;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    public TpMemoList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new TpMemoList_Data$Attributes();
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

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.stationName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoList_Data tpMemoList_Data = (TpMemoList_Data)bAPEntity;
        return this.arrayHeader.equalTo(tpMemoList_Data.arrayHeader) && this.pos == tpMemoList_Data.pos && this.attributes.equalTo(tpMemoList_Data.attributes) && this.messageTime_Hour == tpMemoList_Data.messageTime_Hour && this.messageTime_Minute == tpMemoList_Data.messageTime_Minute && this.stationName.equalTo(tpMemoList_Data.stationName);
    }

    private void customInitialization() {
        this.stationName.setLimitingLengthByCharacters();
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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
}

