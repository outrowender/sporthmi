/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi.exchange;

import de.esolutions.fw.util.commons.Buffer;

public class MMICombiRequestAnimationInfo {
    int screenType;
    int screenSubType;
    int leadTime;
    int additionalInfo;
    int animationSpeed;

    public MMICombiRequestAnimationInfo() {
        this(0, 0, 0, 0, 0);
    }

    public MMICombiRequestAnimationInfo(int n, int n2, int n3, int n4, int n5) {
        this.screenType = n;
        this.screenSubType = n2;
        this.leadTime = n3;
        this.additionalInfo = n4;
        this.animationSpeed = n5;
    }

    public int getScreenType() {
        return this.screenType;
    }

    public void setScreenType(int n) {
        this.screenType = n;
    }

    public int getScreenSubType() {
        return this.screenSubType;
    }

    public void setScreenSubType(int n) {
        this.screenSubType = n;
    }

    public int getLeadTime() {
        return this.leadTime;
    }

    public void setLeadTime(int n) {
        this.leadTime = n;
    }

    public int getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(int n) {
        this.additionalInfo = n;
    }

    public int getAnimationSpeed() {
        return this.animationSpeed;
    }

    public void setAnimationSpeed(int n) {
        this.animationSpeed = n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("MMICombiAnimationInfo {");
        buffer.append("\nscreenType=").append(this.screenType);
        buffer.append("\nscreenSubType=").append(this.screenSubType);
        buffer.append("\nleadTime=").append(this.leadTime);
        buffer.append("\nadditionalInfo=").append(this.additionalInfo);
        buffer.append("\nanimationSpeed=").append(this.animationSpeed);
        buffer.append('}');
        return buffer.toString();
    }

    public boolean equals(Object object) {
        if (object instanceof MMICombiRequestAnimationInfo) {
            MMICombiRequestAnimationInfo mMICombiRequestAnimationInfo = (MMICombiRequestAnimationInfo)object;
            return this.screenType == mMICombiRequestAnimationInfo.getScreenType() && this.screenSubType == mMICombiRequestAnimationInfo.getScreenSubType() && this.leadTime == mMICombiRequestAnimationInfo.getLeadTime() && this.additionalInfo == mMICombiRequestAnimationInfo.getAdditionalInfo() && this.animationSpeed == mMICombiRequestAnimationInfo.getAnimationSpeed();
        }
        return false;
    }

    public int hashCode() {
        int n = 13;
        n = 37 * n + this.screenType;
        n = 37 * n + this.screenSubType;
        n = 37 * n + this.leadTime;
        n = 37 * n + this.additionalInfo;
        n = 37 * n + this.animationSpeed;
        return n;
    }
}

