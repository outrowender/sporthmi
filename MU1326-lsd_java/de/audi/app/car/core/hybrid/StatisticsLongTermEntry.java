/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IMemoryBufferEntry;
import de.esolutions.fw.util.commons.Buffer;

public class StatisticsLongTermEntry
implements IMemoryBufferEntry {
    private static final long serialVersionUID;
    private int valueCounter;
    private int distanceUnit;
    private double distanceCombustion;
    private double distanceElectrical;
    private double distanceEfficiency;

    public StatisticsLongTermEntry() {
        this.valueCounter = 255;
        this.distanceUnit = 0;
        this.distanceCombustion = 255.0;
        this.distanceElectrical = 255.0;
        this.distanceEfficiency = 255.0;
    }

    public StatisticsLongTermEntry(int n, int n2, double d2, double d3, double d4) {
        this.valueCounter = n;
        this.distanceUnit = n2;
        this.distanceCombustion = d2;
        this.distanceElectrical = d3;
        this.distanceEfficiency = d4;
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

    public double getDistanceCombustion() {
        return this.distanceCombustion;
    }

    public void setDistanceCombustion(double d2) {
        this.distanceCombustion = d2;
    }

    public double getDistanceElectrical() {
        return this.distanceElectrical;
    }

    public void setDistanceElectrical(double d2) {
        this.distanceElectrical = d2;
    }

    public double getDistanceEfficiency() {
        return this.distanceEfficiency;
    }

    public void setDistanceEfficiency(double d2) {
        this.distanceEfficiency = d2;
    }

    @Override
    public void setDefaultValues() {
        this.valueCounter = 255;
        this.distanceUnit = 0;
        this.distanceCombustion = 255.0;
        this.distanceElectrical = 255.0;
        this.distanceEfficiency = 255.0;
    }

    @Override
    public IMemoryBufferEntry copy() {
        return new StatisticsLongTermEntry(this.valueCounter, this.distanceUnit, this.distanceCombustion, this.distanceElectrical, this.distanceEfficiency);
    }

    @Override
    public String[] getFields() {
        return new String[]{"valueCounter", "distanceUnit", "distanceCombustion", "distanceElectrical", "distanceEfficiency"};
    }

    @Override
    public String[] getValuesAsString() {
        return new String[]{Integer.toHexString(this.valueCounter), Integer.toHexString(this.distanceUnit), Double.toString((double)this.distanceCombustion), Double.toString((double)this.distanceElectrical), Double.toString((double)this.distanceEfficiency)};
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("StatisticsLongTermEntry(");
        buffer.append("valueCounter='").append(this.valueCounter).append("', ");
        buffer.append("distanceUnit='").append(this.distanceUnit).append("', ");
        buffer.append("distanceCombustion='").append(Double.toString((double)this.distanceCombustion)).append("', ");
        buffer.append("distanceElectrical='").append(Double.toString((double)this.distanceElectrical)).append("', ");
        buffer.append("distanceEfficiency='").append(Double.toString((double)this.distanceEfficiency)).append("')");
        return buffer.toString();
    }
}

