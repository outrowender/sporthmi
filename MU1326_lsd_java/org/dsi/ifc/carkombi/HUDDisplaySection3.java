/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class HUDDisplaySection3 {
    public boolean rollAngle;
    public boolean hdc;
    public boolean sportResponse;
    public boolean boostAssist;
    public boolean heightIndication;
    public boolean junctionAssistant;
    public boolean trafficLightAssistant;
    public boolean curveAssistant;

    public HUDDisplaySection3() {
        this.rollAngle = false;
        this.hdc = false;
        this.sportResponse = false;
        this.boostAssist = false;
        this.heightIndication = false;
        this.junctionAssistant = false;
        this.trafficLightAssistant = false;
        this.curveAssistant = false;
    }

    public HUDDisplaySection3(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.rollAngle = bl;
        this.hdc = bl2;
        this.sportResponse = bl3;
        this.boostAssist = bl4;
        this.heightIndication = bl5;
        this.junctionAssistant = bl6;
        this.trafficLightAssistant = bl7;
        this.curveAssistant = bl8;
    }

    public boolean isRollAngle() {
        return this.rollAngle;
    }

    public boolean isHdc() {
        return this.hdc;
    }

    public boolean isSportResponse() {
        return this.sportResponse;
    }

    public boolean isBoostAssist() {
        return this.boostAssist;
    }

    public boolean isHeightIndication() {
        return this.heightIndication;
    }

    public boolean isJunctionAssistant() {
        return this.junctionAssistant;
    }

    public boolean isTrafficLightAssistant() {
        return this.trafficLightAssistant;
    }

    public boolean isCurveAssistant() {
        return this.curveAssistant;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("HUDDisplaySection3");
        stringBuffer.append('(');
        stringBuffer.append("rollAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.rollAngle);
        stringBuffer.append(',');
        stringBuffer.append("hdc");
        stringBuffer.append('=');
        stringBuffer.append(this.hdc);
        stringBuffer.append(',');
        stringBuffer.append("sportResponse");
        stringBuffer.append('=');
        stringBuffer.append(this.sportResponse);
        stringBuffer.append(',');
        stringBuffer.append("boostAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.boostAssist);
        stringBuffer.append(',');
        stringBuffer.append("heightIndication");
        stringBuffer.append('=');
        stringBuffer.append(this.heightIndication);
        stringBuffer.append(',');
        stringBuffer.append("junctionAssistant");
        stringBuffer.append('=');
        stringBuffer.append(this.junctionAssistant);
        stringBuffer.append(',');
        stringBuffer.append("trafficLightAssistant");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficLightAssistant);
        stringBuffer.append(',');
        stringBuffer.append("curveAssistant");
        stringBuffer.append('=');
        stringBuffer.append(this.curveAssistant);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

