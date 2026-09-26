/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.listhandling;

import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class BatteryControlPowerProviderRAx {
    public int pos;
    public String client;
    public String provider;
    public BatteryControlWeekdays nrWeekday;
    public int nrStartHour;
    public int nrStartMinute;
    public int nrEndHour;
    public int nrEndMinute;

    public BatteryControlPowerProviderRAx() {
        this.pos = 0;
        this.client = "";
        this.provider = "";
        this.nrWeekday = null;
        this.nrStartHour = 0;
        this.nrStartMinute = 0;
        this.nrEndHour = 0;
        this.nrEndMinute = 0;
    }

    public BatteryControlPowerProviderRAx(int n, String string, String string2, BatteryControlWeekdays batteryControlWeekdays, int n2, int n3, int n4, int n5) {
        this.pos = n;
        this.client = string;
        this.provider = string2;
        this.nrWeekday = batteryControlWeekdays;
        this.nrStartHour = n2;
        this.nrStartMinute = n3;
        this.nrEndHour = n4;
        this.nrEndMinute = n5;
    }

    public int getPos() {
        return this.pos;
    }

    public String getClient() {
        return this.client;
    }

    public String getProvider() {
        return this.provider;
    }

    public BatteryControlWeekdays getNrWeekday() {
        return this.nrWeekday;
    }

    public int getNrStartHour() {
        return this.nrStartHour;
    }

    public int getNrStartMinute() {
        return this.nrStartMinute;
    }

    public int getNrEndHour() {
        return this.nrEndHour;
    }

    public int getNrEndMinute() {
        return this.nrEndMinute;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("BatteryControlPowerProviderRAx(pos=");
        stringBuffer.append(this.pos);
        stringBuffer.append(",client=\"");
        stringBuffer.append(this.client);
        stringBuffer.append("\",provider=\"");
        stringBuffer.append(this.provider);
        stringBuffer.append("\",nrWeekday=");
        stringBuffer.append(this.nrWeekday);
        stringBuffer.append(",nrStartHour=");
        stringBuffer.append(this.nrStartHour);
        stringBuffer.append(",nrStartMinute=");
        stringBuffer.append(this.nrStartMinute);
        stringBuffer.append(",nrEndHour=");
        stringBuffer.append(this.nrEndHour);
        stringBuffer.append(",nrEndMinute=");
        stringBuffer.append(this.nrEndMinute);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

