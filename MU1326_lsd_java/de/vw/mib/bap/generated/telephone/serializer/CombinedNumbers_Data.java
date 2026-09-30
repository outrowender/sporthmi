/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class CombinedNumbers_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PB_NAME_NUMBER_TYPE_CALL_MODE_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND = 0;
    public static final int RECORD_ADDRESS_PB_NAME_NUMBER_TYPE_CALL_MODE = 1;
    public static final int RECORD_ADDRESS_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND = 2;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public final BAPString pbName;
    private static final int MAX_PB_NAME_LENGTH = 100;
    public int numberType;
    private static final int NUMBER_TYPE_BITSIZE = 4;
    public static final int NUMBER_TYPE_UNKNOWN_NUMBER_TYPE = 0;
    public static final int NUMBER_TYPE_GENERAL = 1;
    public static final int NUMBER_TYPE_MOBILE = 2;
    public static final int NUMBER_TYPE_OFFICE = 3;
    public static final int NUMBER_TYPE_HOME = 4;
    public static final int NUMBER_TYPE_FAX = 5;
    public static final int NUMBER_TYPE_PAGER = 6;
    public static final int NUMBER_TYPE_CELL_OFFICE = 11;
    public static final int NUMBER_TYPE_CELL_HOME = 12;
    public static final int NUMBER_TYPE_FAX_OFFICE = 13;
    public static final int NUMBER_TYPE_FAX_HOME = 14;
    public int callMode;
    private static final int CALL_MODE_BITSIZE = 4;
    public static final int CALL_MODE_UNKNOWN_CALL_MODE = 0;
    public static final int CALL_MODE_MISSED_CALL = 1;
    public static final int CALL_MODE_RECEIVED_CALL = 2;
    public static final int CALL_MODE_DIALED_NUMBER = 3;
    public final BAPString telNumber;
    private static final int MAX_TEL_NUMBER_LENGTH = 41;
    public int day;
    private static final int DAY_BITSIZE = 8;
    public int month;
    private static final int MONTH_BITSIZE = 8;
    public int year;
    private static final int YEAR_BITSIZE = 8;
    public int hour;
    private static final int HOUR_BITSIZE = 8;
    public int minute;
    private static final int MINUTE_BITSIZE = 8;
    public int second;
    private static final int SECOND_BITSIZE = 8;

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

    public CombinedNumbers_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.telNumber = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public CombinedNumbers_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.numberType = 0;
        this.callMode = 0;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.pbName.reset();
        this.telNumber.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CombinedNumbers_Data combinedNumbers_Data = (CombinedNumbers_Data)bAPEntity;
        return this.arrayHeader.equalTo(combinedNumbers_Data.arrayHeader) && this.pos == combinedNumbers_Data.pos && this.pbName.equalTo(combinedNumbers_Data.pbName) && this.numberType == combinedNumbers_Data.numberType && this.callMode == combinedNumbers_Data.callMode && this.telNumber.equalTo(combinedNumbers_Data.telNumber) && this.day == combinedNumbers_Data.day && this.month == combinedNumbers_Data.month && this.year == combinedNumbers_Data.year && this.hour == combinedNumbers_Data.hour && this.minute == combinedNumbers_Data.minute && this.second == combinedNumbers_Data.second;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CombinedNumbers_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - PbName - ");
        stringBuffer.append(this.pbName.toString());
        stringBuffer.append("\n - NumberType: ");
        switch (this.numberType) {
            case 0: {
                stringBuffer.append("0x0 (unknown NumberType)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (General)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (Mobile)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (Office)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (Home)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (Fax)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (Pager)");
                break;
            }
            case 11: {
                stringBuffer.append("0xB (Cell office)");
                break;
            }
            case 12: {
                stringBuffer.append("0xC (Cell home)");
                break;
            }
            case 13: {
                stringBuffer.append("0xD (Fax office)");
                break;
            }
            case 14: {
                stringBuffer.append("0xE (Fax home)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - CallMode: ");
        switch (this.callMode) {
            case 0: {
                stringBuffer.append("0x0 (unknown call mode)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (missed call)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (received call)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (dialed number)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TelNumber - ");
        stringBuffer.append(this.telNumber.toString());
        stringBuffer.append("\n - Day - ");
        stringBuffer.append(this.day);
        stringBuffer.append("\n - Month - ");
        stringBuffer.append(this.month);
        stringBuffer.append("\n - Year - ");
        stringBuffer.append(this.year);
        stringBuffer.append("\n - Hour - ");
        stringBuffer.append(this.hour);
        stringBuffer.append("\n - Minute - ");
        stringBuffer.append(this.minute);
        stringBuffer.append("\n - Second - ");
        stringBuffer.append(this.second);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.pbName.bitSize();
                n += 4;
                n += 4;
                n += this.telNumber.bitSize();
                n += 8;
                n += 8;
                n += 8;
                n += 8;
                n += 8;
                n += 8;
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.pbName.bitSize();
                n += 4;
                n += 4;
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.telNumber.bitSize();
                n += 8;
                n += 8;
                n += 8;
                n += 8;
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
                this.pbName.serialize(bitStream);
                bitStream.pushBits(4, this.numberType);
                bitStream.pushBits(4, this.callMode);
                this.telNumber.serialize(bitStream);
                bitStream.pushByte((byte)this.day);
                bitStream.pushByte((byte)this.month);
                bitStream.pushByte((byte)this.year);
                bitStream.pushByte((byte)this.hour);
                bitStream.pushByte((byte)this.minute);
                bitStream.pushByte((byte)this.second);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.pbName.serialize(bitStream);
                bitStream.pushBits(4, this.numberType);
                bitStream.pushBits(4, this.callMode);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.telNumber.serialize(bitStream);
                bitStream.pushByte((byte)this.day);
                bitStream.pushByte((byte)this.month);
                bitStream.pushByte((byte)this.year);
                bitStream.pushByte((byte)this.hour);
                bitStream.pushByte((byte)this.minute);
                bitStream.pushByte((byte)this.second);
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
                this.pbName.deserialize(bitStream);
                this.numberType = bitStream.popFrontBits(4);
                this.callMode = bitStream.popFrontBits(4);
                this.telNumber.deserialize(bitStream);
                this.day = bitStream.popFrontByte();
                this.month = bitStream.popFrontByte();
                this.year = bitStream.popFrontByte();
                this.hour = bitStream.popFrontByte();
                this.minute = bitStream.popFrontByte();
                this.second = bitStream.popFrontByte();
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.pbName.deserialize(bitStream);
                this.numberType = bitStream.popFrontBits(4);
                this.callMode = bitStream.popFrontBits(4);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.telNumber.deserialize(bitStream);
                this.day = bitStream.popFrontByte();
                this.month = bitStream.popFrontByte();
                this.year = bitStream.popFrontByte();
                this.hour = bitStream.popFrontByte();
                this.minute = bitStream.popFrontByte();
                this.second = bitStream.popFrontByte();
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

