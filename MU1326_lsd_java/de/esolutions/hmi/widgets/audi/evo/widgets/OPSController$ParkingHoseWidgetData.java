/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.OPSController;

public class OPSController$ParkingHoseWidgetData {
    public int direction = 0;
    public int frontWheelRadius = 1300;
    public int rearWheelRadius = 500;
    public int trackDisplay = 0;
    public int wheelBase = 3;
    private final /* synthetic */ OPSController this$0;

    public OPSController$ParkingHoseWidgetData(OPSController oPSController) {
        this.this$0 = oPSController;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("parkingHoseData[direction = ");
        stringBuffer.append(this.direction);
        stringBuffer.append("; frontWheelRadius = ");
        stringBuffer.append(this.frontWheelRadius);
        stringBuffer.append("; rearWheelRadius = ");
        stringBuffer.append(this.rearWheelRadius);
        stringBuffer.append("; trackDisplay = ");
        stringBuffer.append(this.trackDisplay);
        stringBuffer.append("; wheelBase = ");
        stringBuffer.append(this.wheelBase);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}

