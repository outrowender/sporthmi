/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class MissedCalls_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PB_NAME_NUMBER_TYPE_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND;
    public static final int RECORD_ADDRESS_PB_NAME_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString pbName;
    private static final int MAX_PB_NAME_LENGTH;
    public int numberType;
    private static final int NUMBER_TYPE_BITSIZE;
    public static final int NUMBER_TYPE_UNKNOWN_NUMBER_TYPE;
    public static final int NUMBER_TYPE_GENERAL;
    public static final int NUMBER_TYPE_MOBILE;
    public static final int NUMBER_TYPE_OFFICE;
    public static final int NUMBER_TYPE_HOME;
    public static final int NUMBER_TYPE_FAX;
    public static final int NUMBER_TYPE_PAGER;
    public static final int NUMBER_TYPE_CAR;
    public static final int NUMBER_TYPE_SIM;
    public static final int NUMBER_TYPE_MAIN_OFFICE;
    public static final int NUMBER_TYPE_MAIN_HOME;
    public static final int NUMBER_TYPE_CELL_OFFICE;
    public static final int NUMBER_TYPE_CELL_HOME;
    public static final int NUMBER_TYPE_FAX_OFFICE;
    public static final int NUMBER_TYPE_FAX_HOME;
    public final BAPString telNumber;
    private static final int MAX_TEL_NUMBER_LENGTH;
    public int day;
    private static final int DAY_BITSIZE;
    public int month;
    private static final int MONTH_BITSIZE;
    public int year;
    private static final int YEAR_BITSIZE;
    public int hour;
    private static final int HOUR_BITSIZE;
    public int minute;
    private static final int MINUTE_BITSIZE;
    public int second;
    private static final int SECOND_BITSIZE;

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

    public MissedCalls_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.telNumber = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public MissedCalls_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.numberType = 0;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.pbName.reset();
        this.telNumber.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MissedCalls_Data missedCalls_Data = (MissedCalls_Data)bAPEntity;
        return this.arrayHeader.equalTo(missedCalls_Data.arrayHeader) && this.pos == missedCalls_Data.pos && this.pbName.equalTo(missedCalls_Data.pbName) && this.numberType == missedCalls_Data.numberType && this.telNumber.equalTo(missedCalls_Data.telNumber) && this.day == missedCalls_Data.day && this.month == missedCalls_Data.month && this.year == missedCalls_Data.year && this.hour == missedCalls_Data.hour && this.minute == missedCalls_Data.minute && this.second == missedCalls_Data.second;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MissedCalls_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - PbName - ");
        stringBuffer.append(this.pbName.toString());
        stringBuffer.append("\n - NumberType: ");
        switch (this.numberType) {
            case 0: {
                stringBuffer.append("0x00 (unknown NumberType)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (General)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Mobile)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Office)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Home)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (Fax)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (Pager)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (Car)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (SIM)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (Main office)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (Main home)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (Cell office)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (Cell home)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (Fax office)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (Fax home)");
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

    @Override
    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.pbName.bitSize();
                n += 8;
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
                n += 8;
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

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.pbName.serialize(bitStream);
                bitStream.pushByte((byte)this.numberType);
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
                bitStream.pushByte((byte)this.numberType);
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

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.pbName.deserialize(bitStream);
                this.numberType = bitStream.popFrontByte();
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
                this.numberType = bitStream.popFrontByte();
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

