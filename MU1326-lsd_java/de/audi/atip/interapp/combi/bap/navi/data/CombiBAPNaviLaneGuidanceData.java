/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;

public final class CombiBAPNaviLaneGuidanceData
implements CombiBAPArrayElement {
    public short posID;
    public short laneDirection;
    public byte[] laneSideStreets;
    public short laneType;
    public byte laneMarkingLeft;
    public byte laneMarkingRight;
    public byte laneDescription;
    public byte guidanceInfo;

    public CombiBAPNaviLaneGuidanceData() {
        this.posID = 0;
        this.laneDirection = 0;
        this.laneSideStreets = null;
        this.laneType = 0;
        this.laneMarkingLeft = 0;
        this.laneMarkingRight = 0;
        this.laneDescription = 0;
        this.guidanceInfo = 0;
    }

    public CombiBAPNaviLaneGuidanceData(short s, short s2, byte[] byArray, short s3, byte by, byte by2, byte by3, byte by4) {
        this.posID = s;
        this.laneDirection = s2;
        this.laneSideStreets = byArray;
        this.laneType = s3;
        this.laneMarkingLeft = by;
        this.laneMarkingRight = by2;
        this.laneDescription = by3;
        this.guidanceInfo = by4;
    }

    @Override
    public int getPosID() {
        return this.posID;
    }

    public short getLaneDirection() {
        return this.laneDirection;
    }

    public byte[] getLaneSideStreets() {
        return this.laneSideStreets;
    }

    public short getLaneType() {
        return this.laneType;
    }

    public byte getLaneMarkingLeft() {
        return this.laneMarkingLeft;
    }

    public byte getLaneMarkingRight() {
        return this.laneMarkingRight;
    }

    public byte getLaneDescription() {
        return this.laneDescription;
    }

    public byte getGuidanceInfo() {
        return this.guidanceInfo;
    }

    @Override
    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPNaviLaneGuidanceData) {
            CombiBAPNaviLaneGuidanceData combiBAPNaviLaneGuidanceData = (CombiBAPNaviLaneGuidanceData)combiBAPArrayElement;
            return this.posID == combiBAPNaviLaneGuidanceData.posID && this.laneDirection == combiBAPNaviLaneGuidanceData.laneDirection && this.laneSideStreets == combiBAPNaviLaneGuidanceData.laneSideStreets && this.laneType == combiBAPNaviLaneGuidanceData.laneType && this.laneMarkingLeft == combiBAPNaviLaneGuidanceData.laneMarkingLeft && this.laneMarkingRight == combiBAPNaviLaneGuidanceData.laneMarkingRight && this.laneDescription == combiBAPNaviLaneGuidanceData.laneDescription && this.guidanceInfo == combiBAPNaviLaneGuidanceData.guidanceInfo;
        }
        return false;
    }

    @Override
    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (this.hasSameContent(combiBAPArrayElement)) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPNaviLaneGuidanceData) {
            CombiBAPNaviLaneGuidanceData combiBAPNaviLaneGuidanceData = (CombiBAPNaviLaneGuidanceData)combiBAPArrayElement;
            n = CombiBAPNaviLaneGuidanceData.getRecordAddress(this.posID != combiBAPNaviLaneGuidanceData.posID, this.laneDirection != combiBAPNaviLaneGuidanceData.laneDirection, this.laneSideStreets != combiBAPNaviLaneGuidanceData.laneSideStreets, this.laneType != combiBAPNaviLaneGuidanceData.laneType, this.laneMarkingLeft != combiBAPNaviLaneGuidanceData.laneMarkingLeft, this.laneMarkingRight != combiBAPNaviLaneGuidanceData.laneMarkingRight, this.laneDescription != combiBAPNaviLaneGuidanceData.laneDescription, this.guidanceInfo != combiBAPNaviLaneGuidanceData.guidanceInfo);
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        int n = 0;
        if (bl) {
            ++n;
        }
        if (bl2) {
            ++n;
        }
        if (bl3) {
            ++n;
        }
        if (bl4) {
            ++n;
        }
        if (bl5) {
            ++n;
        }
        if (bl6) {
            ++n;
        }
        if (bl7) {
            ++n;
        }
        if (bl8) {
            ++n;
        }
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n <= 2 && !bl && !bl2 && !bl3 && !bl4 && !bl5 && !bl6 ? 3 : (n <= 3 && !bl && !bl3 && !bl4 && !bl5 && !bl6 ? 2 : (n <= 5 && !bl5 && !bl6 ? 1 : 0))));
        return n2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("CombiBAPNaviLaneGuidanceData {posID=");
        stringBuffer.append(this.posID);
        stringBuffer.append(" (0x");
        stringBuffer.append(Integer.toHexString(this.posID));
        stringBuffer.append("), laneDirection=");
        stringBuffer.append(this.laneDirection);
        stringBuffer.append(", laneSideStreets");
        if (this.laneSideStreets != null) {
            stringBuffer.append('[');
            stringBuffer.append(this.laneSideStreets.length);
            stringBuffer.append("]={");
            for (int i2 = 0; i2 < this.laneSideStreets.length; ++i2) {
                stringBuffer.append(this.laneSideStreets[i2]);
                if (i2 >= this.laneSideStreets.length - 1) continue;
                stringBuffer.append(',');
            }
            stringBuffer.append('}');
        } else {
            stringBuffer.append("=null");
        }
        stringBuffer.append(", laneType=");
        stringBuffer.append(this.laneType);
        stringBuffer.append(", laneMarkingLeft=");
        stringBuffer.append(this.laneMarkingLeft);
        stringBuffer.append(", laneMarkingRight=");
        stringBuffer.append(this.laneMarkingRight);
        stringBuffer.append(", laneDescription=");
        stringBuffer.append(this.laneDescription);
        stringBuffer.append(", guidanceInfo=");
        stringBuffer.append(this.guidanceInfo);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

