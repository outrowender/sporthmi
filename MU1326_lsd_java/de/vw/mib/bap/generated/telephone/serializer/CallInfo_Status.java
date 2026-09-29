/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CallInfo_Status
implements StatusProperty {
    public final BAPString pbName0 = new BAPString(100);
    private static final int MAX_PB_NAME0_LENGTH;
    public final BAPString telNumber0 = new BAPString(41);
    private static final int MAX_TEL_NUMBER0_LENGTH;
    public int category0;
    private static final int CATEGORY0_BITSIZE;
    public static final int CATEGORY0_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY0_GENERAL;
    public static final int CATEGORY0_MOBILE;
    public static final int CATEGORY0_OFFICE;
    public static final int CATEGORY0_HOME;
    public static final int CATEGORY0_FAX;
    public static final int CATEGORY0_PAGER;
    public static final int CATEGORY0_CAR;
    public static final int CATEGORY0_SIM;
    public static final int CATEGORY0_MAIN_OFFICE;
    public static final int CATEGORY0_MAIN_HOME;
    public static final int CATEGORY0_CELL_OFFICE;
    public static final int CATEGORY0_CELL_HOME;
    public static final int CATEGORY0_FAX_OFFICE;
    public static final int CATEGORY0_FAX_HOME;
    public final BAPString pbName1 = new BAPString(100);
    private static final int MAX_PB_NAME1_LENGTH;
    public final BAPString telNumber1 = new BAPString(41);
    private static final int MAX_TEL_NUMBER1_LENGTH;
    public int category1;
    private static final int CATEGORY1_BITSIZE;
    public static final int CATEGORY1_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY1_GENERAL;
    public static final int CATEGORY1_MOBILE;
    public static final int CATEGORY1_OFFICE;
    public static final int CATEGORY1_HOME;
    public static final int CATEGORY1_FAX;
    public static final int CATEGORY1_PAGER;
    public static final int CATEGORY1_CAR;
    public static final int CATEGORY1_SIM;
    public static final int CATEGORY1_MAIN_OFFICE;
    public static final int CATEGORY1_MAIN_HOME;
    public static final int CATEGORY1_CELL_OFFICE;
    public static final int CATEGORY1_CELL_HOME;
    public static final int CATEGORY1_FAX_OFFICE;
    public static final int CATEGORY1_FAX_HOME;
    public final BAPString pbName2 = new BAPString(100);
    private static final int MAX_PB_NAME2_LENGTH;
    public final BAPString telNumber2 = new BAPString(41);
    private static final int MAX_TEL_NUMBER2_LENGTH;
    public int category2;
    private static final int CATEGORY2_BITSIZE;
    public static final int CATEGORY2_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY2_GENERAL;
    public static final int CATEGORY2_MOBILE;
    public static final int CATEGORY2_OFFICE;
    public static final int CATEGORY2_HOME;
    public static final int CATEGORY2_FAX;
    public static final int CATEGORY2_PAGER;
    public static final int CATEGORY2_CAR;
    public static final int CATEGORY2_SIM;
    public static final int CATEGORY2_MAIN_OFFICE;
    public static final int CATEGORY2_MAIN_HOME;
    public static final int CATEGORY2_CELL_OFFICE;
    public static final int CATEGORY2_CELL_HOME;
    public static final int CATEGORY2_FAX_OFFICE;
    public static final int CATEGORY2_FAX_HOME;
    public final BAPString pbName3 = new BAPString(100);
    private static final int MAX_PB_NAME3_LENGTH;
    public final BAPString telNumber3 = new BAPString(41);
    private static final int MAX_TEL_NUMBER3_LENGTH;
    public int category3;
    private static final int CATEGORY3_BITSIZE;
    public static final int CATEGORY3_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY3_GENERAL;
    public static final int CATEGORY3_MOBILE;
    public static final int CATEGORY3_OFFICE;
    public static final int CATEGORY3_HOME;
    public static final int CATEGORY3_FAX;
    public static final int CATEGORY3_PAGER;
    public static final int CATEGORY3_CAR;
    public static final int CATEGORY3_SIM;
    public static final int CATEGORY3_MAIN_OFFICE;
    public static final int CATEGORY3_MAIN_HOME;
    public static final int CATEGORY3_CELL_OFFICE;
    public static final int CATEGORY3_CELL_HOME;
    public static final int CATEGORY3_FAX_OFFICE;
    public static final int CATEGORY3_FAX_HOME;
    public final BAPString pbName4 = new BAPString(100);
    private static final int MAX_PB_NAME4_LENGTH;
    public final BAPString telNumber4 = new BAPString(41);
    private static final int MAX_TEL_NUMBER4_LENGTH;
    public int category4;
    private static final int CATEGORY4_BITSIZE;
    public static final int CATEGORY4_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY4_GENERAL;
    public static final int CATEGORY4_MOBILE;
    public static final int CATEGORY4_OFFICE;
    public static final int CATEGORY4_HOME;
    public static final int CATEGORY4_FAX;
    public static final int CATEGORY4_PAGER;
    public static final int CATEGORY4_CAR;
    public static final int CATEGORY4_SIM;
    public static final int CATEGORY4_MAIN_OFFICE;
    public static final int CATEGORY4_MAIN_HOME;
    public static final int CATEGORY4_CELL_OFFICE;
    public static final int CATEGORY4_CELL_HOME;
    public static final int CATEGORY4_FAX_OFFICE;
    public static final int CATEGORY4_FAX_HOME;
    public final BAPString pbName5 = new BAPString(100);
    private static final int MAX_PB_NAME5_LENGTH;
    public final BAPString telNumber5 = new BAPString(41);
    private static final int MAX_TEL_NUMBER5_LENGTH;
    public int category5;
    private static final int CATEGORY5_BITSIZE;
    public static final int CATEGORY5_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY5_GENERAL;
    public static final int CATEGORY5_MOBILE;
    public static final int CATEGORY5_OFFICE;
    public static final int CATEGORY5_HOME;
    public static final int CATEGORY5_FAX;
    public static final int CATEGORY5_PAGER;
    public static final int CATEGORY5_CAR;
    public static final int CATEGORY5_SIM;
    public static final int CATEGORY5_MAIN_OFFICE;
    public static final int CATEGORY5_MAIN_HOME;
    public static final int CATEGORY5_CELL_OFFICE;
    public static final int CATEGORY5_CELL_HOME;
    public static final int CATEGORY5_FAX_OFFICE;
    public static final int CATEGORY5_FAX_HOME;
    public final BAPString pbName6 = new BAPString(100);
    private static final int MAX_PB_NAME6_LENGTH;
    public final BAPString telNumber6 = new BAPString(41);
    private static final int MAX_TEL_NUMBER6_LENGTH;
    public int category6;
    private static final int CATEGORY6_BITSIZE;
    public static final int CATEGORY6_UNKNOWN_NUMBER_TYPE;
    public static final int CATEGORY6_GENERAL;
    public static final int CATEGORY6_MOBILE;
    public static final int CATEGORY6_OFFICE;
    public static final int CATEGORY6_HOME;
    public static final int CATEGORY6_FAX;
    public static final int CATEGORY6_PAGER;
    public static final int CATEGORY6_CAR;
    public static final int CATEGORY6_SIM;
    public static final int CATEGORY6_MAIN_OFFICE;
    public static final int CATEGORY6_MAIN_HOME;
    public static final int CATEGORY6_CELL_OFFICE;
    public static final int CATEGORY6_CELL_HOME;
    public static final int CATEGORY6_FAX_OFFICE;
    public static final int CATEGORY6_FAX_HOME;

    public CallInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CallInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.category0 = 0;
        this.category1 = 0;
        this.category2 = 0;
        this.category3 = 0;
        this.category4 = 0;
        this.category5 = 0;
        this.category6 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.pbName0.reset();
        this.telNumber0.reset();
        this.pbName1.reset();
        this.telNumber1.reset();
        this.pbName2.reset();
        this.telNumber2.reset();
        this.pbName3.reset();
        this.telNumber3.reset();
        this.pbName4.reset();
        this.telNumber4.reset();
        this.pbName5.reset();
        this.telNumber5.reset();
        this.pbName6.reset();
        this.telNumber6.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallInfo_Status callInfo_Status = (CallInfo_Status)bAPEntity;
        return this.pbName0.equalTo(callInfo_Status.pbName0) && this.telNumber0.equalTo(callInfo_Status.telNumber0) && this.category0 == callInfo_Status.category0 && this.pbName1.equalTo(callInfo_Status.pbName1) && this.telNumber1.equalTo(callInfo_Status.telNumber1) && this.category1 == callInfo_Status.category1 && this.pbName2.equalTo(callInfo_Status.pbName2) && this.telNumber2.equalTo(callInfo_Status.telNumber2) && this.category2 == callInfo_Status.category2 && this.pbName3.equalTo(callInfo_Status.pbName3) && this.telNumber3.equalTo(callInfo_Status.telNumber3) && this.category3 == callInfo_Status.category3 && this.pbName4.equalTo(callInfo_Status.pbName4) && this.telNumber4.equalTo(callInfo_Status.telNumber4) && this.category4 == callInfo_Status.category4 && this.pbName5.equalTo(callInfo_Status.pbName5) && this.telNumber5.equalTo(callInfo_Status.telNumber5) && this.category5 == callInfo_Status.category5 && this.pbName6.equalTo(callInfo_Status.pbName6) && this.telNumber6.equalTo(callInfo_Status.telNumber6) && this.category6 == callInfo_Status.category6;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallInfo_Status:");
        stringBuffer.append("\n - PbName0 - ");
        stringBuffer.append(this.pbName0.toString());
        stringBuffer.append("\n - TelNumber0 - ");
        stringBuffer.append(this.telNumber0.toString());
        stringBuffer.append("\n - Category0: ");
        switch (this.category0) {
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
        stringBuffer.append("\n - PbName1 - ");
        stringBuffer.append(this.pbName1.toString());
        stringBuffer.append("\n - TelNumber1 - ");
        stringBuffer.append(this.telNumber1.toString());
        stringBuffer.append("\n - Category1: ");
        switch (this.category1) {
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
        stringBuffer.append("\n - PbName2 - ");
        stringBuffer.append(this.pbName2.toString());
        stringBuffer.append("\n - TelNumber2 - ");
        stringBuffer.append(this.telNumber2.toString());
        stringBuffer.append("\n - Category2: ");
        switch (this.category2) {
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
        stringBuffer.append("\n - PbName3 - ");
        stringBuffer.append(this.pbName3.toString());
        stringBuffer.append("\n - TelNumber3 - ");
        stringBuffer.append(this.telNumber3.toString());
        stringBuffer.append("\n - Category3: ");
        switch (this.category3) {
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
        stringBuffer.append("\n - PbName4 - ");
        stringBuffer.append(this.pbName4.toString());
        stringBuffer.append("\n - TelNumber4 - ");
        stringBuffer.append(this.telNumber4.toString());
        stringBuffer.append("\n - Category4: ");
        switch (this.category4) {
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
        stringBuffer.append("\n - PbName5 - ");
        stringBuffer.append(this.pbName5.toString());
        stringBuffer.append("\n - TelNumber5 - ");
        stringBuffer.append(this.telNumber5.toString());
        stringBuffer.append("\n - Category5: ");
        switch (this.category5) {
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
        stringBuffer.append("\n - PbName6 - ");
        stringBuffer.append(this.pbName6.toString());
        stringBuffer.append("\n - TelNumber6 - ");
        stringBuffer.append(this.telNumber6.toString());
        stringBuffer.append("\n - Category6: ");
        switch (this.category6) {
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

    @Override
    public int bitSize() {
        int n = 0;
        n += this.pbName0.bitSize();
        n += this.telNumber0.bitSize();
        n += 8;
        n += this.pbName1.bitSize();
        n += this.telNumber1.bitSize();
        n += 8;
        n += this.pbName2.bitSize();
        n += this.telNumber2.bitSize();
        n += 8;
        n += this.pbName3.bitSize();
        n += this.telNumber3.bitSize();
        n += 8;
        n += this.pbName4.bitSize();
        n += this.telNumber4.bitSize();
        n += 8;
        n += this.pbName5.bitSize();
        n += this.telNumber5.bitSize();
        n += 8;
        n += this.pbName6.bitSize();
        n += this.telNumber6.bitSize();
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.pbName0.serialize(bitStream);
        this.telNumber0.serialize(bitStream);
        bitStream.pushByte((byte)this.category0);
        this.pbName1.serialize(bitStream);
        this.telNumber1.serialize(bitStream);
        bitStream.pushByte((byte)this.category1);
        this.pbName2.serialize(bitStream);
        this.telNumber2.serialize(bitStream);
        bitStream.pushByte((byte)this.category2);
        this.pbName3.serialize(bitStream);
        this.telNumber3.serialize(bitStream);
        bitStream.pushByte((byte)this.category3);
        this.pbName4.serialize(bitStream);
        this.telNumber4.serialize(bitStream);
        bitStream.pushByte((byte)this.category4);
        this.pbName5.serialize(bitStream);
        this.telNumber5.serialize(bitStream);
        bitStream.pushByte((byte)this.category5);
        this.pbName6.serialize(bitStream);
        this.telNumber6.serialize(bitStream);
        bitStream.pushByte((byte)this.category6);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.pbName0.deserialize(bitStream);
        this.telNumber0.deserialize(bitStream);
        this.category0 = bitStream.popFrontByte();
        this.pbName1.deserialize(bitStream);
        this.telNumber1.deserialize(bitStream);
        this.category1 = bitStream.popFrontByte();
        this.pbName2.deserialize(bitStream);
        this.telNumber2.deserialize(bitStream);
        this.category2 = bitStream.popFrontByte();
        this.pbName3.deserialize(bitStream);
        this.telNumber3.deserialize(bitStream);
        this.category3 = bitStream.popFrontByte();
        this.pbName4.deserialize(bitStream);
        this.telNumber4.deserialize(bitStream);
        this.category4 = bitStream.popFrontByte();
        this.pbName5.deserialize(bitStream);
        this.telNumber5.deserialize(bitStream);
        this.category5 = bitStream.popFrontByte();
        this.pbName6.deserialize(bitStream);
        this.telNumber6.deserialize(bitStream);
        this.category6 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return CallInfo_Status.functionId();
    }
}

