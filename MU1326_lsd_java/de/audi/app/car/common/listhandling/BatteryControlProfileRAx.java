/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.listhandling;

import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation2;

public class BatteryControlProfileRAx {
    public int pos;
    public BatteryControlProfileOperation profileOperation;
    public BatteryControlProfileOperation2 profileOperation2;
    public int maxCurrent;
    public int targetChargeLevel;
    public int providerDataId;
    public String name;

    public BatteryControlProfileRAx() {
        this.pos = 0;
        this.profileOperation = null;
        this.profileOperation2 = null;
        this.maxCurrent = 0;
        this.targetChargeLevel = 0;
        this.providerDataId = 0;
        this.name = null;
    }

    public BatteryControlProfileRAx(int n, BatteryControlProfileOperation batteryControlProfileOperation, BatteryControlProfileOperation2 batteryControlProfileOperation2, int n2, int n3, int n4, String string) {
        this.pos = n;
        this.profileOperation = batteryControlProfileOperation;
        this.profileOperation2 = batteryControlProfileOperation2;
        this.maxCurrent = n2;
        this.targetChargeLevel = n3;
        this.providerDataId = n4;
        this.name = string;
    }

    public int getPos() {
        return this.pos;
    }

    public BatteryControlProfileOperation getProfileOperation() {
        return this.profileOperation;
    }

    public BatteryControlProfileOperation2 getProfileOperation2() {
        return this.profileOperation2;
    }

    public int getMaxCurrent() {
        return this.maxCurrent;
    }

    public int getTargetChargeLevel() {
        return this.targetChargeLevel;
    }

    public int getProviderDataId() {
        return this.providerDataId;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2250);
        stringBuffer.append("BatteryControlProfileRAx(pos=");
        stringBuffer.append(this.pos);
        stringBuffer.append(",profileOperation=");
        stringBuffer.append(this.profileOperation);
        stringBuffer.append(",profileOperation2=");
        stringBuffer.append(this.profileOperation2);
        stringBuffer.append(",maxCurrent=");
        stringBuffer.append(this.maxCurrent);
        stringBuffer.append(",targetChargeLevel=");
        stringBuffer.append(this.targetChargeLevel);
        stringBuffer.append(",name=");
        stringBuffer.append(this.name);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

