/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class HUDCollectiveTopics {
    public int acc;
    public int nightvision;
    public int roadsign;
    public int rgi;
    public int hca;
    public int gra;
    public int efficiencyAssist;
    public int speedLimiter;
    public int navInfoInHUD;

    public HUDCollectiveTopics() {
        this.acc = 0;
        this.nightvision = 0;
        this.roadsign = 0;
        this.rgi = 0;
        this.hca = 0;
        this.gra = 0;
        this.efficiencyAssist = 0;
        this.speedLimiter = 0;
        this.navInfoInHUD = 0;
    }

    public HUDCollectiveTopics(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        this.acc = n;
        this.nightvision = n2;
        this.roadsign = n3;
        this.rgi = n4;
        this.hca = n5;
        this.gra = n6;
        this.efficiencyAssist = n7;
        this.speedLimiter = n8;
        this.navInfoInHUD = n9;
    }

    public int getGra() {
        return this.gra;
    }

    public int getNightvision() {
        return this.nightvision;
    }

    public int getRoadsign() {
        return this.roadsign;
    }

    public int getRgi() {
        return this.rgi;
    }

    public int getNavInfoInHUD() {
        return this.navInfoInHUD;
    }

    public int getAcc() {
        return this.acc;
    }

    public int getHca() {
        return this.hca;
    }

    public int getEfficiencyAssist() {
        return this.efficiencyAssist;
    }

    public int getSpeedLimiter() {
        return this.speedLimiter;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("HUDCollectiveTopics");
        stringBuffer.append('(');
        stringBuffer.append("acc");
        stringBuffer.append('=');
        stringBuffer.append(this.acc);
        stringBuffer.append(',');
        stringBuffer.append("nightvision");
        stringBuffer.append('=');
        stringBuffer.append(this.nightvision);
        stringBuffer.append(',');
        stringBuffer.append("roadsign");
        stringBuffer.append('=');
        stringBuffer.append(this.roadsign);
        stringBuffer.append(',');
        stringBuffer.append("rgi");
        stringBuffer.append('=');
        stringBuffer.append(this.rgi);
        stringBuffer.append(',');
        stringBuffer.append("hca");
        stringBuffer.append('=');
        stringBuffer.append(this.hca);
        stringBuffer.append(',');
        stringBuffer.append("gra");
        stringBuffer.append('=');
        stringBuffer.append(this.gra);
        stringBuffer.append(',');
        stringBuffer.append("efficiencyAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.efficiencyAssist);
        stringBuffer.append(',');
        stringBuffer.append("speedLimiter");
        stringBuffer.append('=');
        stringBuffer.append(this.speedLimiter);
        stringBuffer.append(',');
        stringBuffer.append("navInfoInHUD");
        stringBuffer.append('=');
        stringBuffer.append(this.navInfoInHUD);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

