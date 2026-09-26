/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class FavoriteList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_NAME_NUMBER_TYPE_TEL_NUMBER;
    public static final int RECORD_ADDRESS_NAME_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_NAME_TEL_NUMBER;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH;
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

    public FavoriteList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.name = new BAPString(100);
        this.telNumber = new BAPString(41);
        this.internalReset();
        this.customInitialization();
    }

    public FavoriteList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.numberType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.name.reset();
        this.telNumber.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FavoriteList_Data favoriteList_Data = (FavoriteList_Data)bAPEntity;
        return this.arrayHeader.equalTo(favoriteList_Data.arrayHeader) && this.pos == favoriteList_Data.pos && this.name.equalTo(favoriteList_Data.name) && this.numberType == favoriteList_Data.numberType && this.telNumber.equalTo(favoriteList_Data.telNumber);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FavoriteList_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - Name - ");
        stringBuffer.append(this.name.toString());
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
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.name.bitSize();
                n += 8;
                n += this.telNumber.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.name.bitSize();
                n += 8;
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.name.bitSize();
                n += this.telNumber.bitSize();
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
                this.name.serialize(bitStream);
                bitStream.pushByte((byte)this.numberType);
                this.telNumber.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                bitStream.pushByte((byte)this.numberType);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                this.telNumber.serialize(bitStream);
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
                this.name.deserialize(bitStream);
                this.numberType = bitStream.popFrontByte();
                this.telNumber.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                this.numberType = bitStream.popFrontByte();
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                this.telNumber.deserialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

