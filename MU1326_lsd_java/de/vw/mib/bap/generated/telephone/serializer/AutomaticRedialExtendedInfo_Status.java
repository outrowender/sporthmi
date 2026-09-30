/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticRedialExtendedInfo_Status
implements StatusProperty {
    public int redial_TimeStamp;
    private static final int REDIAL_TIME_STAMP_BITSIZE = 16;
    public final BAPString pbName = new BAPString(100);
    private static final int MAX_PB_NAME_LENGTH = 100;
    public final BAPString telNumber = new BAPString(41);
    private static final int MAX_TEL_NUMBER_LENGTH = 41;
    public int category;
    private static final int CATEGORY_BITSIZE = 8;
    public static final int CATEGORY_UNKNOWN_NUMBER_TYPE = 0;
    public static final int CATEGORY_GENERAL = 1;
    public static final int CATEGORY_MOBILE = 2;
    public static final int CATEGORY_OFFICE = 3;
    public static final int CATEGORY_HOME = 4;
    public static final int CATEGORY_FAX = 5;
    public static final int CATEGORY_PAGER = 6;
    public static final int CATEGORY_CAR = 7;
    public static final int CATEGORY_SIM = 8;
    public static final int CATEGORY_MAIN_OFFICE = 9;
    public static final int CATEGORY_MAIN_HOME = 10;
    public static final int CATEGORY_CELL_OFFICE = 11;
    public static final int CATEGORY_CELL_HOME = 12;
    public static final int CATEGORY_FAX_OFFICE = 13;
    public static final int CATEGORY_FAX_HOME = 14;

    public AutomaticRedialExtendedInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticRedialExtendedInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.redial_TimeStamp = 0;
        this.category = 0;
    }

    public void reset() {
        this.internalReset();
        this.pbName.reset();
        this.telNumber.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticRedialExtendedInfo_Status automaticRedialExtendedInfo_Status = (AutomaticRedialExtendedInfo_Status)bAPEntity;
        return this.redial_TimeStamp == automaticRedialExtendedInfo_Status.redial_TimeStamp && this.pbName.equalTo(automaticRedialExtendedInfo_Status.pbName) && this.telNumber.equalTo(automaticRedialExtendedInfo_Status.telNumber) && this.category == automaticRedialExtendedInfo_Status.category;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AutomaticRedialExtendedInfo_Status:");
        stringBuffer.append("\n - Redial_TimeStamp - ");
        stringBuffer.append(this.redial_TimeStamp);
        stringBuffer.append("\n - PbName - ");
        stringBuffer.append(this.pbName.toString());
        stringBuffer.append("\n - TelNumber - ");
        stringBuffer.append(this.telNumber.toString());
        stringBuffer.append("\n - Category: ");
        switch (this.category) {
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
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 16;
        n += this.pbName.bitSize();
        n += this.telNumber.bitSize();
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.redial_TimeStamp);
        this.pbName.serialize(bitStream);
        this.telNumber.serialize(bitStream);
        bitStream.pushByte((byte)this.category);
    }

    public void deserialize(BitStream bitStream) {
        this.redial_TimeStamp = bitStream.popFrontShort();
        this.pbName.deserialize(bitStream);
        this.telNumber.deserialize(bitStream);
        this.category = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 58;
    }

    public int getFunctionId() {
        return AutomaticRedialExtendedInfo_Status.functionId();
    }
}

