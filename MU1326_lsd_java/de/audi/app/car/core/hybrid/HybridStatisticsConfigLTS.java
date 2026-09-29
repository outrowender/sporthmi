/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IHybridStatisticsConfig;
import de.esolutions.fw.util.commons.Buffer;

public class HybridStatisticsConfigLTS
implements IHybridStatisticsConfig {
    private static final long serialVersionUID;
    private int distanceUnit;
    private float intervalValue;

    public HybridStatisticsConfigLTS() {
        this.distanceUnit = 0;
        this.intervalValue = 0.0f;
    }

    public HybridStatisticsConfigLTS(int n, float f2) {
        this.distanceUnit = n;
        this.intervalValue = f2;
    }

    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    public void setDistanceUnit(int n) {
        this.distanceUnit = n;
    }

    public float getIntervalValue() {
        return this.intervalValue;
    }

    public void setIntervalValue(float f2) {
        this.intervalValue = f2;
    }

    @Override
    public String[] getFields() {
        return new String[]{"distanceUnit", "intervalValue"};
    }

    @Override
    public String[] getValuesAsString() {
        return new String[]{Integer.toHexString(this.distanceUnit), Float.toString(this.intervalValue)};
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("HybridStatisticsConfigLTS(");
        buffer.append("distanceUnit='").append(this.distanceUnit).append("', ");
        buffer.append("intervalValue='").append(this.intervalValue).append("')");
        return buffer.toString();
    }
}

