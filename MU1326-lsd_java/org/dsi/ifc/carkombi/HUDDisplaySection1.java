/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class HUDDisplaySection1 {
    public boolean speed;
    public boolean fasStatusIcon;
    public boolean fasScreen;
    public boolean trafficSign;
    public boolean navigation;
    public boolean additionalNavigation;
    public boolean gForce;
    public boolean gearIndication;

    public HUDDisplaySection1() {
        this.speed = false;
        this.fasStatusIcon = false;
        this.fasScreen = false;
        this.trafficSign = false;
        this.navigation = false;
        this.additionalNavigation = false;
        this.gForce = false;
        this.gearIndication = false;
    }

    public HUDDisplaySection1(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.speed = bl;
        this.fasStatusIcon = bl2;
        this.fasScreen = bl3;
        this.trafficSign = bl4;
        this.navigation = bl5;
        this.additionalNavigation = bl6;
        this.gForce = bl7;
        this.gearIndication = bl8;
    }

    public boolean isSpeed() {
        return this.speed;
    }

    public boolean isFasStatusIcon() {
        return this.fasStatusIcon;
    }

    public boolean isFasScreen() {
        return this.fasScreen;
    }

    public boolean isTrafficSign() {
        return this.trafficSign;
    }

    public boolean isNavigation() {
        return this.navigation;
    }

    public boolean isAdditionalNavigation() {
        return this.additionalNavigation;
    }

    public boolean isGForce() {
        return this.gForce;
    }

    public boolean isGearIndication() {
        return this.gearIndication;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("HUDDisplaySection1");
        stringBuffer.append('(');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(',');
        stringBuffer.append("fasStatusIcon");
        stringBuffer.append('=');
        stringBuffer.append(this.fasStatusIcon);
        stringBuffer.append(',');
        stringBuffer.append("fasScreen");
        stringBuffer.append('=');
        stringBuffer.append(this.fasScreen);
        stringBuffer.append(',');
        stringBuffer.append("trafficSign");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSign);
        stringBuffer.append(',');
        stringBuffer.append("navigation");
        stringBuffer.append('=');
        stringBuffer.append(this.navigation);
        stringBuffer.append(',');
        stringBuffer.append("additionalNavigation");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalNavigation);
        stringBuffer.append(',');
        stringBuffer.append("gForce");
        stringBuffer.append('=');
        stringBuffer.append(this.gForce);
        stringBuffer.append(',');
        stringBuffer.append("gearIndication");
        stringBuffer.append('=');
        stringBuffer.append(this.gearIndication);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

