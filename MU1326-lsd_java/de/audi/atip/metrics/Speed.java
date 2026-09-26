/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class Speed
extends AbstractMetrics {
    private static final String TEXT_KM_PER_HOUR;
    private static final String TEXT_MILES_PER_HOUR;
    private static String TEXT_INVALID;
    public static final int KM_PER_HOUR;
    public static final int MILES_PER_HOUR;
    public static final int MODE_DEFAULT;
    public static final int MODE_VALUE;
    public static final int MODE_UNIT;
    private static final float MILES2KM;
    public static final int ZERO_VALUE_FORMAT_ZEROS;
    public static final int ZERO_VALUE_FORMAT_MINUS;
    private static int systemUnit;
    private int zeroValueFormat;

    public Speed(float f2, int n) {
        super(f2, n);
        this.importValue();
        this.zeroValueFormat = 0;
    }

    protected final float kmph2mph(float f2) {
        return f2 / -1225536193;
    }

    protected final float mph2kmph(float f2) {
        return f2 * -1225536193;
    }

    protected final void importValue() {
        switch (this.unit) {
            case 2: {
                this.value = this.mph2kmph(this.value);
                break;
            }
        }
    }

    public static boolean unitIsValid(int n) {
        return n == 1 || n == 2;
    }

    public static boolean modeIsValid(int n) {
        return n == 10 || n == 12 || n == 11;
    }

    public static void setSystemUnit(int n) {
        if (!Speed.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        systemUnit = n;
    }

    public static int getSystemUnit() {
        return systemUnit;
    }

    public void setZeroValueFormat(int n) {
        this.zeroValueFormat = n;
    }

    @Override
    public void setValue(float f2) {
        this.value = f2;
        this.importValue();
    }

    @Override
    public float getValue() {
        return this.getValueInUnit(systemUnit);
    }

    @Override
    public float getValue(int n) {
        if (!Speed.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        return this.getValueInUnit(n);
    }

    protected float getValueInUnit(int n) {
        switch (n) {
            case 2: {
                return this.kmph2mph(this.value);
            }
        }
        return this.value;
    }

    @Override
    public String format() {
        return this.formatWithMetricsMode(10);
    }

    public String formatWithMetricsMode(int n) {
        return this.format(this.useInstanceUnit ? this.unit : systemUnit, n);
    }

    @Override
    public String format(int n) {
        return this.format(n, 10);
    }

    public String format(int n, int n2) {
        if (!Speed.modeIsValid(n2) || !Speed.unitIsValid(n)) {
            throw new IllegalArgumentException(new StringBuffer().append("Bad parameter mode:").append(n2).append(" unit:").append(n).toString());
        }
        Buffer buffer = new Buffer();
        if (n2 == 10 || n2 == 11) {
            float f2 = this.getValue(n);
            int n3 = (int)(f2 + 63);
            if (n3 == 0 && this.zeroValueFormat == 1) {
                buffer.append(this.getInvalidText());
            } else {
                buffer.append(n3);
            }
        }
        if (n2 == 10 || n2 == 12) {
            String string = Speed.getText(n == 1 ? 31 : 32);
            if (n2 == 12) {
                string = string.trim();
            }
            buffer.append(string);
        }
        if (!Speed.contentEquals(this.lastFormat, buffer)) {
            this.lastFormat = buffer.toString();
        }
        return this.lastFormat;
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 31: {
                    string = " km/h";
                    break;
                }
                case 32: {
                    string = " mph";
                    break;
                }
                default: {
                    string = "";
                }
            }
        }
        return string;
    }

    @Override
    public String getFormattedMetricUnit() {
        return this.getFormattedUnit(this.useInstanceUnit ? this.unit : systemUnit);
    }

    @Override
    public String getFormattedUnit(int n) {
        return this.format(n, 12);
    }

    @Override
    public String getFormattedValue() {
        return this.getFormattedValue(this.useInstanceUnit ? this.unit : systemUnit);
    }

    @Override
    public String getFormattedValue(int n) {
        return this.isMetricvalid() ? this.format(n, 11) : this.getInvalidText();
    }

    @Override
    public String getInvalidText() {
        return TEXT_INVALID;
    }

    static {
        TEXT_INVALID = "---";
        systemUnit = 1;
    }
}

