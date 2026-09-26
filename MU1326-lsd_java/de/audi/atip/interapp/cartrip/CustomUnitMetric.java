/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.cartrip;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class CustomUnitMetric
extends AbstractMetrics {
    private static final String SEPARATOR;
    private static String TEXT_INVALID;
    public static final int VALUE_FORMAT_FLOAT;
    public static final int VALUE_FORMAT_INT;
    private int valueFormat = 0;
    private String unitString;

    public CustomUnitMetric(float f2, String string) {
        super(f2, 0);
        this.unitString = string;
    }

    public void setValueFormat(int n) {
        this.valueFormat = n;
    }

    @Override
    public void setValue(float f2) {
        this.value = f2;
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
    public float getValue(int n) {
        return this.value;
    }

    @Override
    public String format() {
        Buffer buffer = new Buffer();
        buffer.append(this.getFormattedValue());
        buffer.append(" ");
        buffer.append(this.unitString);
        if (!CustomUnitMetric.contentEquals(this.lastFormat, buffer)) {
            this.lastFormat = buffer.toString();
        }
        return this.lastFormat;
    }

    @Override
    public String format(int n) {
        return this.format();
    }

    @Override
    public String getFormattedMetricUnit() {
        return null != this.unitString ? this.unitString.trim() : "";
    }

    @Override
    public String getFormattedUnit(int n) {
        return this.getFormattedMetricUnit();
    }

    @Override
    public String getFormattedValue() {
        if (this.isMetricvalid()) {
            switch (this.valueFormat) {
                case 1: {
                    return Integer.toString((int)this.value);
                }
            }
            return Float.toString(this.value);
        }
        return this.getInvalidText();
    }

    @Override
    public String getFormattedValue(int n) {
        return this.getFormattedValue();
    }

    @Override
    public String getInvalidText() {
        return TEXT_INVALID;
    }

    @Override
    public String[] getStringValueAndUnit() {
        return new String[]{this.getFormattedValue(), this.unitString};
    }

    @Override
    public String[] getStringValueAndUnit(int n) {
        return this.getStringValueAndUnit();
    }

    static {
        TEXT_INVALID = "---";
    }
}

