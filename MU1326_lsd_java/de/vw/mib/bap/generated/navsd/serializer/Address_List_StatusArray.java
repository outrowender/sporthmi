/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_Data;
import de.vw.mib.bap.stream.BitStream;

public final class Address_List_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE;
    public static final int ASG_ID_INSTRUMENT_CLUSTER;
    public static final int ASG_ID_HEAD_UP_DISPLAY;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2;
    public static final int ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UP_DISPLAY_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_OPERATING_UNIT_REAR_TO_BE_EVALUATED_BY_ALL_ASGS;
    public int taid;
    private static final int TAID_BITSIZE;
    public int otherListType;
    private static final int OTHER_LIST_TYPE_BITSIZE;
    public static final int OTHER_LIST_TYPE_LAST_DESTINATIONS_LIST_FUNCTION_0X1D;
    public static final int OTHER_LIST_TYPE_FAVORITE_DESTINATIONS_LIST_FUNCTION_0X1E;
    public static final int OTHER_LIST_TYPE_NAV_BOOK_FUNCTION_0X20;
    public static final int OTHER_LIST_TYPE_PHONE_BOOK_BAP_FUNCTION_CATALOGUE_PHONE;
    public static final int OTHER_LIST_TYPE_HOME_ADDRESS_DF4_1;
    public static final int OTHER_LIST_TYPE_COMPLETE_LIST_DF4_1;
    public int otherList_Reference;
    private static final int OTHER_LIST_REFERENCE_BITSIZE;
    public int totalNumListElements;
    private static final int TOTAL_NUM_LIST_ELEMENTS_BITSIZE;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(-16842752);
    private static final int MAX_DATA_ELEMENTS;

    @Override
    public int getAsgId() {
        return this.asg_Id & 7;
    }

    @Override
    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    @Override
    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    @Override
    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    @Override
    public int getTransactionId() {
        return this.taid;
    }

    @Override
    public void setTransactionId(int n) {
        this.taid = n;
    }

    @Override
    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    @Override
    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.data;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return new Address_List_Data(this.getArrayHeader());
    }

    public Address_List_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public Address_List_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.otherListType = 0;
        this.otherList_Reference = 0;
        this.totalNumListElements = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Address_List_StatusArray address_List_StatusArray = (Address_List_StatusArray)bAPEntity;
        return this.asg_Id == address_List_StatusArray.asg_Id && this.taid == address_List_StatusArray.taid && this.otherListType == address_List_StatusArray.otherListType && this.otherList_Reference == address_List_StatusArray.otherList_Reference && this.totalNumListElements == address_List_StatusArray.totalNumListElements && this.arrayHeader.equalTo(address_List_StatusArray.arrayHeader) && this.data.equalTo(address_List_StatusArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Address_List_StatusArray:");
        stringBuffer.append("\n - ASG_ID: ");
        switch (this.asg_Id) {
            case 0: {
                stringBuffer.append("0x0 (default ASG (any ASG, spontaneous FSG message))");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (instrument cluster)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (head-up display)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (operating unit rear (DF4.2) )");
                break;
            }
            case 9: {
                stringBuffer.append("0x9 (instrument cluster, to be evaluated by all ASGs)");
                break;
            }
            case 10: {
                stringBuffer.append("0xA (head-up display, to be evaluated by all ASGs)");
                break;
            }
            case 11: {
                stringBuffer.append("0xB (operating unit rear, to be evaluated by all ASGs (DF4.2) )");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TAID - ");
        stringBuffer.append(this.taid);
        stringBuffer.append("\n - OtherListType: ");
        switch (this.otherListType) {
            case 0: {
                stringBuffer.append("0x00 (LastDestinations_List (function 0x1D))");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (FavoriteDestinations_List (function 0x1E))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (NavBook (function 0x20))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (PhoneBook (BAP function catalogue Phone))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (HomeAddress (DF4.1))");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (completeList (DF4.1))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - OtherList_Reference - ");
        stringBuffer.append(this.otherList_Reference);
        stringBuffer.append("\n - TotalNumListElements - ");
        stringBuffer.append(this.totalNumListElements);
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Data:");
        stringBuffer.append(this.data.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 8;
        n += 16;
        n += 16;
        n += this.arrayHeader.bitSize();
        return n += this.data.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.otherListType);
        bitStream.pushShort((short)this.otherList_Reference);
        bitStream.pushShort((short)this.totalNumListElements);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.otherListType = bitStream.popFrontByte();
        this.otherList_Reference = bitStream.popFrontShort();
        this.totalNumListElements = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new Address_List_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return Address_List_StatusArray.functionId();
    }
}

