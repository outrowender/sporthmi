/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.MediaBrowser_Data;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE = 4;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE = 0;
    public static final int ASG_ID_INSTRUMENT_CLUSTER = 1;
    public static final int ASG_ID_HEAD_UP_DISPLAY = 2;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2 = 3;
    public int taid;
    private static final int TAID_BITSIZE = 4;
    public int totalNumListElements;
    private static final int TOTAL_NUM_LIST_ELEMENTS_BITSIZE = 16;
    public int activeListPos;
    private static final int ACTIVE_LIST_POS_BITSIZE = 16;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(65535);
    private static final int MAX_DATA_ELEMENTS = 65535;

    public int getAsgId() {
        return this.asg_Id & 7;
    }

    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    public int getTransactionId() {
        return this.taid;
    }

    public void setTransactionId(int n) {
        this.taid = n;
    }

    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    public BAPArrayData getArrayData() {
        return this.data;
    }

    public BAPArrayElement createArrayElement() {
        return new MediaBrowser_Data(this.getArrayHeader());
    }

    public MediaBrowser_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.totalNumListElements = 0;
        this.activeListPos = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_StatusArray mediaBrowser_StatusArray = (MediaBrowser_StatusArray)bAPEntity;
        return this.asg_Id == mediaBrowser_StatusArray.asg_Id && this.taid == mediaBrowser_StatusArray.taid && this.totalNumListElements == mediaBrowser_StatusArray.totalNumListElements && this.activeListPos == mediaBrowser_StatusArray.activeListPos && this.arrayHeader.equalTo(mediaBrowser_StatusArray.arrayHeader) && this.data.equalTo(mediaBrowser_StatusArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MediaBrowser_StatusArray:");
        stringBuffer.append("\n - ASG_ID: ");
        switch (this.asg_Id) {
            case 0: {
                stringBuffer.append("0x0 (default ASG (any ASG, spontaenous FSG message))");
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
                stringBuffer.append("0x3 (operating unit rear (DF4.2))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TAID - ");
        stringBuffer.append(this.taid);
        stringBuffer.append("\n - TotalNumListElements - ");
        stringBuffer.append(this.totalNumListElements);
        stringBuffer.append("\n - ActiveListPos - ");
        stringBuffer.append(this.activeListPos);
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Data:");
        stringBuffer.append(this.data.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 16;
        n += 16;
        n += this.arrayHeader.bitSize();
        return n += this.data.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushShort((short)this.totalNumListElements);
        bitStream.pushShort((short)this.activeListPos);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.totalNumListElements = bitStream.popFrontShort();
        this.activeListPos = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new MediaBrowser_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 36;
    }

    public int getFunctionId() {
        return MediaBrowser_StatusArray.functionId();
    }
}

