/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.esolutions.fw.util.commons.Buffer;

public class StatisticsZeroEmissionEntry
implements IMemoryBufferEntry {
    private static final long serialVersionUID;
    public static final int ZEROEMISSION_VALUESTATE_INVALID;
    public static final int ZEROEMISSION_VALUESTATE_VALID;
    private int zeroEmissionState;
    private double zeroEmissionValue;

    public StatisticsZeroEmissionEntry() {
        this.zeroEmissionState = 0;
        this.zeroEmissionValue = 0.0;
    }

    public StatisticsZeroEmissionEntry(int n, double d2) {
        this.zeroEmissionState = n;
        this.zeroEmissionValue = d2;
    }

    public int getZeroEmissionState() {
        return this.zeroEmissionState;
    }

    public void setZeroEmissionState(int n) {
        this.zeroEmissionState = n;
    }

    public double getZeroEmissionValue() {
        return this.zeroEmissionValue;
    }

    public void setZeroEmissionValue(double d2) {
        this.zeroEmissionValue = d2;
    }

    @Override
    public void setDefaultValues() {
        this.zeroEmissionState = 0;
        this.zeroEmissionValue = 0.0;
    }

    @Override
    public IMemoryBufferEntry copy() {
        return new StatisticsZeroEmissionEntry(this.zeroEmissionState, this.zeroEmissionValue);
    }

    @Override
    public String[] getFields() {
        return new String[]{"zeroEmissionState", "zeroEmissionValue"};
    }

    @Override
    public String[] getValuesAsString() {
        return new String[]{Integer.toHexString(this.zeroEmissionState), Double.toString((double)this.zeroEmissionValue)};
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("StatisticsZeroEmissionEntry(");
        buffer.append("zeroEmissionState='").append(Integer.toHexString(this.zeroEmissionState)).append("', ");
        buffer.append("zeroEmissionValue='").append(Double.toString((double)this.zeroEmissionValue)).append("')");
        return buffer.toString();
    }
}

