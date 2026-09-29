/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IHybridStatisticsConfig;
import de.esolutions.fw.util.commons.Buffer;

public class HybridStatisticsConfigSTS
implements IHybridStatisticsConfig {
    private static final long serialVersionUID;
    private int distanceUnit;
    private float intervalValue;
    private int bufferValidDataSize;

    public HybridStatisticsConfigSTS() {
        this.distanceUnit = 0;
        this.intervalValue = 0.0f;
        this.bufferValidDataSize = 0;
    }

    public HybridStatisticsConfigSTS(int n, float f2, int n2) {
        this.distanceUnit = n;
        this.intervalValue = f2;
        this.bufferValidDataSize = n2;
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

    public int getBufferValidDataSize() {
        return this.bufferValidDataSize;
    }

    public void setBufferValidDataSize(int n) {
        this.bufferValidDataSize = n;
    }

    @Override
    public String[] getFields() {
        return new String[]{"distanceUnit", "intervalValue", "bufferValidDataSize"};
    }

    @Override
    public String[] getValuesAsString() {
        return new String[]{Integer.toHexString(this.distanceUnit), Float.toString(this.intervalValue), Integer.toString(this.bufferValidDataSize)};
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("HybridStatisticsConfigSTS(");
        buffer.append("distanceUnit='").append(this.distanceUnit).append("', ");
        buffer.append("intervalValue='").append(this.intervalValue).append("', ");
        buffer.append("bufferValidDataSize='").append(this.bufferValidDataSize).append("')");
        return buffer.toString();
    }
}

