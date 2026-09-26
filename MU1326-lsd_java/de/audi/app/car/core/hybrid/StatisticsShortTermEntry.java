/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.esolutions.fw.util.commons.Buffer;

public class StatisticsShortTermEntry
implements IMemoryBufferEntry {
    private static final long serialVersionUID;
    private int valueCounter;
    private int distanceUnit;
    private int zeroEmissionState;
    private double zeroEmissionValue;

    public StatisticsShortTermEntry() {
        this.valueCounter = 255;
        this.distanceUnit = 0;
        this.zeroEmissionState = 0;
        this.zeroEmissionValue = 255.0;
    }

    public StatisticsShortTermEntry(int n, int n2, int n3, double d2) {
        this.valueCounter = n;
        this.distanceUnit = n2;
        this.zeroEmissionState = n3;
        this.zeroEmissionValue = d2;
    }

    public int getValueCounter() {
        return this.valueCounter;
    }

    public void setValueCounter(int n) {
        this.valueCounter = n;
    }

    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    public void setDistanceUnit(int n) {
        this.distanceUnit = n;
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
        this.valueCounter = 255;
        this.distanceUnit = 0;
        this.zeroEmissionState = 0;
        this.zeroEmissionValue = 255.0;
    }

    @Override
    public IMemoryBufferEntry copy() {
        return new StatisticsShortTermEntry(this.valueCounter, this.distanceUnit, this.zeroEmissionState, this.zeroEmissionValue);
    }

    @Override
    public String[] getFields() {
        return new String[]{"valueCounter", "distanceUnit", "zeroEmissionState", "zeroEmissionValue"};
    }

    @Override
    public String[] getValuesAsString() {
        return new String[]{Integer.toHexString(this.valueCounter), Integer.toHexString(this.distanceUnit), Integer.toHexString(this.zeroEmissionState), Double.toString((double)this.zeroEmissionValue)};
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("StatisticsShortTermEntry(");
        buffer.append("valueCounter='").append(this.valueCounter).append("', ");
        buffer.append("distanceUnit='").append(this.distanceUnit).append("', ");
        buffer.append("zeroEmissionState='").append(this.zeroEmissionState).append("', ");
        buffer.append("zeroEmissionValue='").append(Double.toString((double)this.zeroEmissionValue)).append("')");
        return buffer.toString();
    }
}

