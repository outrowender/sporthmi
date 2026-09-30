/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_LaneGuidance;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE = 4;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE = 0;
    public static final int ASG_ID_INSTRUMENT_CLUSTER = 1;
    public static final int ASG_ID_HEAD_UP_DISPLAY = 2;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2 = 3;
    public static final int ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_AS_GS_DF4_4 = 9;
    public static final int ASG_ID_HEAD_UP_DISPLAY_TO_BE_EVALUATED_BY_ALL_AS_GS_DF4_4 = 10;
    public static final int ASG_ID_OPERATING_UNIT_REAR_TO_BE_EVALUATED_BY_ALL_AS_GS_DF4_4 = 11;
    public int taid;
    private static final int TAID_BITSIZE = 4;
    public int laneGuidanceOnOff;
    private static final int LANE_GUIDANCE_ON_OFF_BITSIZE = 8;
    public static final int LANE_GUIDANCE_ON_OFF_LANE_GUIDANCE_SHALL_NOT_BE_DISPLAYED = 0;
    public static final int LANE_GUIDANCE_ON_OFF_DISPLAY_LANE_GUIDANCE = 1;
    public static final int LANE_GUIDANCE_ON_OFF_NOT_SUPPORTED = 255;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData laneGuidance = new BAPArrayData(8);
    private static final int MAX_LANE_GUIDANCE_ELEMENTS = 8;

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

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setArrayData(BAPArrayData bAPArrayData) {
        this.laneGuidance = bAPArrayData;
    }

    public BAPArrayData getArrayData() {
        return this.laneGuidance;
    }

    public BAPArrayElement createArrayElement() {
        return new LaneGuidance_LaneGuidance(this.getArrayHeader());
    }

    public LaneGuidance_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.laneGuidanceOnOff = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.laneGuidance.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        LaneGuidance_StatusArray laneGuidance_StatusArray = (LaneGuidance_StatusArray)bAPEntity;
        return this.asg_Id == laneGuidance_StatusArray.asg_Id && this.taid == laneGuidance_StatusArray.taid && this.laneGuidanceOnOff == laneGuidance_StatusArray.laneGuidanceOnOff && this.arrayHeader.equalTo(laneGuidance_StatusArray.arrayHeader) && this.laneGuidance.equalTo(laneGuidance_StatusArray.laneGuidance);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LaneGuidance_StatusArray:");
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
                stringBuffer.append("0x3 (operating unit rear (DF4.2) )");
                break;
            }
            case 9: {
                stringBuffer.append("0x9 (instrument cluster, to be evaluated by all ASGs (DF4.4))");
                break;
            }
            case 10: {
                stringBuffer.append("0xA (head-up display, to be evaluated by all ASGs (DF4.4))");
                break;
            }
            case 11: {
                stringBuffer.append("0xB (operating unit rear, to be evaluated by all ASGs (DF4.4))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TAID - ");
        stringBuffer.append(this.taid);
        stringBuffer.append("\n - LaneGuidanceOnOff: ");
        switch (this.laneGuidanceOnOff) {
            case 0: {
                stringBuffer.append("0x00 (lane guidance shall not be displayed)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (display lane guidance)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (not supported)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - LaneGuidance:");
        stringBuffer.append(this.laneGuidance.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 8;
        n += this.arrayHeader.bitSize();
        return n += this.laneGuidance.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.laneGuidanceOnOff);
        this.arrayHeader.serialize(bitStream);
        this.laneGuidance.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.laneGuidanceOnOff = bitStream.popFrontByte();
        this.arrayHeader.deserialize(bitStream);
        this.laneGuidance.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.laneGuidance.add(new LaneGuidance_LaneGuidance(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return LaneGuidance_StatusArray.functionId();
    }

    public int getNumberOfElements() {
        return 0;
    }

    public void setNumberOfElements(int n) {
    }
}

