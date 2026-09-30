/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.cartrip;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class CustomUnitMetric
extends AbstractMetrics {
    private static final String SEPARATOR = " ";
    private static String TEXT_INVALID = "---";
    public static final int VALUE_FORMAT_FLOAT = 0;
    public static final int VALUE_FORMAT_INT = 1;
    private int valueFormat = 0;
    private String unitString;

    public CustomUnitMetric(float f2, String string) {
        super(f2, 0);
        this.unitString = string;
    }

    public void setValueFormat(int n) {
        this.valueFormat = n;
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public float getValue() {
        return this.value;
    }

    public float getValue(int n) {
        return this.value;
    }

    public String format() {
        Buffer buffer = new Buffer();
        buffer.append(this.getFormattedValue());
        buffer.append(SEPARATOR);
        buffer.append(this.unitString);
        if (!CustomUnitMetric.contentEquals(this.lastFormat, buffer)) {
            this.lastFormat = buffer.toString();
        }
        return this.lastFormat;
    }

    public String format(int n) {
        return this.format();
    }

    public String getFormattedMetricUnit() {
        return null != this.unitString ? this.unitString.trim() : "";
    }

    public String getFormattedUnit(int n) {
        return this.getFormattedMetricUnit();
    }

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

    public String getFormattedValue(int n) {
        return this.getFormattedValue();
    }

    public String getInvalidText() {
        return TEXT_INVALID;
    }

    public String[] getStringValueAndUnit() {
        return new String[]{this.getFormattedValue(), this.unitString};
    }

    public String[] getStringValueAndUnit(int n) {
        return this.getStringValueAndUnit();
    }
}

