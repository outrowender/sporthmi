/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class HUDDisplaySection2 {
    public boolean shiftIndicator;
    public boolean trackInfo;
    public boolean lapTimer;
    public boolean temperature;
    public boolean telephone;
    public boolean sds;
    public boolean tireAngle;
    public boolean pitchAngle;

    public HUDDisplaySection2() {
        this.shiftIndicator = false;
        this.trackInfo = false;
        this.lapTimer = false;
        this.temperature = false;
        this.telephone = false;
        this.sds = false;
        this.tireAngle = false;
        this.pitchAngle = false;
    }

    public HUDDisplaySection2(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.shiftIndicator = bl;
        this.trackInfo = bl2;
        this.lapTimer = bl3;
        this.temperature = bl4;
        this.telephone = bl5;
        this.sds = bl6;
        this.tireAngle = bl7;
        this.pitchAngle = bl8;
    }

    public boolean isShiftIndicator() {
        return this.shiftIndicator;
    }

    public boolean isTrackInfo() {
        return this.trackInfo;
    }

    public boolean isLapTimer() {
        return this.lapTimer;
    }

    public boolean isTemperature() {
        return this.temperature;
    }

    public boolean isTelephone() {
        return this.telephone;
    }

    public boolean isSds() {
        return this.sds;
    }

    public boolean isTireAngle() {
        return this.tireAngle;
    }

    public boolean isPitchAngle() {
        return this.pitchAngle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("HUDDisplaySection2");
        stringBuffer.append('(');
        stringBuffer.append("shiftIndicator");
        stringBuffer.append('=');
        stringBuffer.append(this.shiftIndicator);
        stringBuffer.append(',');
        stringBuffer.append("trackInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.trackInfo);
        stringBuffer.append(',');
        stringBuffer.append("lapTimer");
        stringBuffer.append('=');
        stringBuffer.append(this.lapTimer);
        stringBuffer.append(',');
        stringBuffer.append("temperature");
        stringBuffer.append('=');
        stringBuffer.append(this.temperature);
        stringBuffer.append(',');
        stringBuffer.append("telephone");
        stringBuffer.append('=');
        stringBuffer.append(this.telephone);
        stringBuffer.append(',');
        stringBuffer.append("sds");
        stringBuffer.append('=');
        stringBuffer.append(this.sds);
        stringBuffer.append(',');
        stringBuffer.append("tireAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.tireAngle);
        stringBuffer.append(',');
        stringBuffer.append("pitchAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.pitchAngle);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

