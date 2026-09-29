/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_LaneGuidance
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_SIDESTREETS_LANE_TYPE_LANE_MARKING_LEFT_LANE_MARKING_RIGHT_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_SIDESTREETS_LANE_TYPE_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int laneDirection;
    private static final int LANE_DIRECTION_BITSIZE;
    public final BAPString laneSidestreets;
    private static final int MAX_LANE_SIDESTREETS_LENGTH;
    public int laneType;
    private static final int LANE_TYPE_BITSIZE;
    public static final int LANE_TYPE_UNSPECIFIC_LANE_TYPE;
    public static final int LANE_TYPE_NORMAL_LANE;
    public static final int LANE_TYPE_LANE_BLOCKED;
    public static final int LANE_TYPE_LANE_FORBIDDEN;
    public static final int LANE_TYPE_LANE_RESTRICTED;
    public static final int LANE_TYPE_BREAKDOWN_LANE;
    public static final int LANE_TYPE_DYNAMICALLY_CONTROLLED;
    public static final int LANE_TYPE_CAR_POOLS;
    public static final int LANE_TYPE_BUS_LANE;
    public static final int LANE_TYPE_BICYCLE_LANE;
    public static final int LANE_TYPE_TAXI_LANE;
    public static final int LANE_TYPE_TRUCK_LANE;
    public static final int LANE_TYPE_BUS_BICYCLE_LANE;
    public static final int LANE_TYPE_BUS_TAXI_LANE;
    public static final int LANE_TYPE_TAXI_BICYCLE_LANE;
    public static final int LANE_TYPE_BUS_TAXI_BICYCLE_LANE;
    public static final int LANE_TYPE_GREEN_STRIP;
    public static final int LANE_TYPE_MOTORWAY_HIGHWAY_LANE;
    public static final int LANE_TYPE_TRAMWAY_ON_NORMAL_ROAD;
    public static final int LANE_TYPE_SEPARATED_TRAMWAY;
    public static final int LANE_TYPE_EXIT_LANE;
    public static final int LANE_TYPE_ENTER_LANE;
    public static final int LANE_TYPE_TOLL_LANE;
    public static final int LANE_TYPE_FURTHER_LANES_ON_THE_LEFT_HAND_SIDE_NOT_SHOWN;
    public static final int LANE_TYPE_FURTHER_LANES_ON_THE_RIGHT_HAND_SIDE_NOT_SHOWN;
    public static final int LANE_TYPE_HIDE_LANE;
    public static final int LANE_TYPE_ETC_NON_ETC_MIXED_LANE_DF4_4;
    public int laneMarking_left;
    private static final int LANE_MARKING_LEFT_BITSIZE;
    public static final int LANE_MARKING_LEFT_NO_LANE_MARKING_AT_THE_LEFT_BORDER_OF_THE_LANE_NO_LINE;
    public static final int LANE_MARKING_LEFT_SOLID_DIVIDER_LINE;
    public static final int LANE_MARKING_LEFT_DASHED_DIVIDER_LINE;
    public int laneMarking_right;
    private static final int LANE_MARKING_RIGHT_BITSIZE;
    public static final int LANE_MARKING_RIGHT_NO_LANE_MARKING_AT_THE_RIGHT_BORDER_OF_THE_LANE;
    public static final int LANE_MARKING_RIGHT_SOLID_DIVIDER_LINE;
    public static final int LANE_MARKING_RIGHT_DASHED_DIVIDER_LINE;
    public int laneDescription;
    private static final int LANE_DESCRIPTION_BITSIZE;
    public static final int LANE_DESCRIPTION_LANE_AVAILABLE;
    public static final int LANE_DESCRIPTION_LANE_MERGING_TO_LEFT;
    public static final int LANE_DESCRIPTION_LANE_MERGING_TO_RIGHT;
    public static final int LANE_DESCRIPTION_LANE_ENDING_LATER;
    public static final int LANE_DESCRIPTION_FORBIDDEN_LANE;
    public static final int LANE_DESCRIPTION_LANE_EXPANDING_TO_LEFT;
    public static final int LANE_DESCRIPTION_LANE_EXPANDING_TO_RIGHT;
    public static final int LANE_DESCRIPTION_LANE_AVAILABLE_LATER;
    public static final int LANE_DESCRIPTION_MULTIPLE_ADDITIONAL_LANE_BEGIN;
    public static final int LANE_DESCRIPTION_MULTIPLE_CONTINUATION_WITH_LANE_ENDS;
    public static final int LANE_DESCRIPTION_LANE_BEGINS_IN_THE_MIDDLE;
    public static final int LANE_DESCRIPTION_NOT_SUPPORTED_NO_DESCRIPTION_AVAILABLE;
    public int guidanceInfo;
    private static final int GUIDANCE_INFO_BITSIZE;
    public static final int GUIDANCE_INFO_NOT_RECOMMENDED_LANE;
    public static final int GUIDANCE_INFO_RECOMMENDED_LANE;
    public static final int GUIDANCE_INFO_BEST_RECOMMENDATION;

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

    public LaneGuidance_LaneGuidance(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.laneSidestreets = new BAPString(17);
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_LaneGuidance(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.laneDirection = 0;
        this.laneType = 0;
        this.laneMarking_left = 0;
        this.laneMarking_right = 0;
        this.laneDescription = 0;
        this.guidanceInfo = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.laneSidestreets.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance = (LaneGuidance_LaneGuidance)bAPEntity;
        return this.arrayHeader.equalTo(laneGuidance_LaneGuidance.arrayHeader) && this.pos == laneGuidance_LaneGuidance.pos && this.laneDirection == laneGuidance_LaneGuidance.laneDirection && this.laneSidestreets.equalTo(laneGuidance_LaneGuidance.laneSidestreets) && this.laneType == laneGuidance_LaneGuidance.laneType && this.laneMarking_left == laneGuidance_LaneGuidance.laneMarking_left && this.laneMarking_right == laneGuidance_LaneGuidance.laneMarking_right && this.laneDescription == laneGuidance_LaneGuidance.laneDescription && this.guidanceInfo == laneGuidance_LaneGuidance.guidanceInfo;
    }

    private void customInitialization() {
        this.laneSidestreets.setRawContent();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LaneGuidance_LaneGuidance:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - LaneDirection - ");
        stringBuffer.append(this.laneDirection);
        stringBuffer.append("\n - LaneSidestreets - ");
        stringBuffer.append(this.laneSidestreets.toString());
        stringBuffer.append("\n - LaneType: ");
        switch (this.laneType) {
            case 0: {
                stringBuffer.append("0x00 (unspecific lane type)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (normal lane)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (lane blocked)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (lane forbidden)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (lane restricted)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (breakdown lane)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (dynamically controlled)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (car pools)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (bus lane)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (bicycle lane)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (taxi lane)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (truck lane)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (bus & bicycle lane)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (bus & taxi lane)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (taxi & bicycle lane)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (bus, taxi & bicycle lane)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (green strip)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (motorway/highway lane)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (tramway on normal road)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (separated tramway)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (exit lane)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (enter lane)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (toll lane)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (further lanes on the left hand side (not shown))");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (further lanes on the right hand side (not shown))");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (hide lane)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (ETC / non ETC mixed lane (DF4.4))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - LaneMarking_left: ");
        switch (this.laneMarking_left) {
            case 0: {
                stringBuffer.append("0x0 (no lane marking at the left border of the lane (no line))");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (solid divider line)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (dashed divider line)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - LaneMarking_right: ");
        switch (this.laneMarking_right) {
            case 0: {
                stringBuffer.append("0x0 (no lane marking at the right border of the lane (no line))");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (solid divider line)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (dashed divider line)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - LaneDescription: ");
        switch (this.laneDescription) {
            case 0: {
                stringBuffer.append("0x0 (lane available)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (lane merging to left)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (lane merging to right)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (lane ending later)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (forbidden lane)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (lane expanding to left)");
                break;
            }
            case 6: {
                stringBuffer.append("0x6 (lane expanding to right)");
                break;
            }
            case 7: {
                stringBuffer.append("0x7 (lane available later)");
                break;
            }
            case 8: {
                stringBuffer.append("0x8 (multiple additional lane begin )");
                break;
            }
            case 9: {
                stringBuffer.append("0x9 (multiple continuation with lane ends)");
                break;
            }
            case 10: {
                stringBuffer.append("0xA (lane begins in the middle)");
                break;
            }
            case 15: {
                stringBuffer.append("0xF (not supported - no description available)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - GuidanceInfo: ");
        switch (this.guidanceInfo) {
            case 0: {
                stringBuffer.append("0x0 (not recommended lane)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (recommended lane)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (best recommendation )");
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
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.laneSidestreets.bitSize();
                n += 8;
                n += 4;
                n += 4;
                n += 4;
                n += 4;
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.laneSidestreets.bitSize();
                n += 8;
                n += 4;
                n += 4;
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += 4;
                n += 4;
                break;
            }
            case 3: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 4;
                n += 4;
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
                bitStream.pushByte((byte)this.laneDirection);
                this.laneSidestreets.serialize(bitStream);
                bitStream.pushByte((byte)this.laneType);
                bitStream.pushBits(4, this.laneMarking_left);
                bitStream.pushBits(4, this.laneMarking_right);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.laneDirection);
                this.laneSidestreets.serialize(bitStream);
                bitStream.pushByte((byte)this.laneType);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.laneDirection);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
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
                this.laneDirection = bitStream.popFrontByte();
                this.laneSidestreets.deserialize(bitStream);
                this.laneType = bitStream.popFrontByte();
                this.laneMarking_left = bitStream.popFrontBits(4);
                this.laneMarking_right = bitStream.popFrontBits(4);
                this.laneDescription = bitStream.popFrontBits(4);
                this.guidanceInfo = bitStream.popFrontBits(4);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.laneDirection = bitStream.popFrontByte();
                this.laneSidestreets.deserialize(bitStream);
                this.laneType = bitStream.popFrontByte();
                this.laneDescription = bitStream.popFrontBits(4);
                this.guidanceInfo = bitStream.popFrontBits(4);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.laneDirection = bitStream.popFrontByte();
                this.laneDescription = bitStream.popFrontBits(4);
                this.guidanceInfo = bitStream.popFrontBits(4);
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.laneDescription = bitStream.popFrontBits(4);
                this.guidanceInfo = bitStream.popFrontBits(4);
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

