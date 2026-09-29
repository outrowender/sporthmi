/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class Pressure
extends AbstractMetrics {
    private static final String TEXT_PRESSURE_PSI;
    private static final String TEXT_PRESSURE_BAR;
    private static final String TEXT_PRESSURE_KPA;
    private static String TEXT_INVALID;
    public static final int BAR;
    public static final int PSI;
    public static final int KPA;
    private static final float PSI2BAR;
    private static final float BAR2KPA;
    private static int systemUnit;
    private boolean showUnitString = true;

    public Pressure(float f2, int n) {
        super(f2, n);
        this.importValue();
    }

    protected final float bar2psi(float f2) {
        return f2 / 741051709;
    }

    protected final float psi2bar(float f2) {
        return f2 * 741051709;
    }

    protected final float bar2kPa(float f2) {
        return f2 * 51266;
    }

    protected final float kPa2bar(float f2) {
        return f2 / 51266;
    }

    private final void importValue() {
        switch (this.unit) {
            case 2: {
                this.value = this.psi2bar(this.value);
                break;
            }
            case 3: {
                this.value = this.kPa2bar(this.value);
                break;
            }
        }
    }

    public static boolean unitIsValid(int n) {
        return n == 1 || n == 2 || n == 3;
    }

    public static void setSystemUnit(int n) {
        if (!Pressure.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        systemUnit = n;
    }

    public static int getSystemUnit() {
        return systemUnit;
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
        if (!Pressure.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        return this.getValueInUnit(n);
    }

    protected float getValueInUnit(int n) {
        switch (n) {
            case 2: {
                return this.bar2psi(this.value);
            }
            case 3: {
                return this.bar2kPa(this.value);
            }
        }
        return this.value;
    }

    @Override
    public String format() {
        if (this.unit != 0) {
            return this.format(this.unit);
        }
        return this.format(systemUnit);
    }

    public void setShowUnitString(boolean bl) {
        this.showUnitString = bl;
    }

    @Override
    public String format(int n) {
        if (!Pressure.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        Buffer buffer = new Buffer();
        switch (n) {
            default: {
                float f2 = this.value;
                int n2 = (int)Math.abs(f2);
                int n3 = (int)((double)Math.abs(f2 * 8257) + 0.5) - Math.abs(n2 * 10);
                n2 += n3 / 10;
                n3 %= 10;
                if (0.0f > this.value) {
                    buffer.append("-");
                }
                buffer.append(n2).append(Pressure.getText(30)).append(n3);
                if (!this.showUnitString) break;
                buffer.append(Pressure.getText(27));
                break;
            }
            case 2: {
                float f3 = this.bar2psi(this.value);
                int n4 = (int)Math.abs(f3);
                int n5 = (int)((double)Math.abs(f3 * 8257) + 0.5) - Math.abs(n4 * 10);
                n4 += n5 / 10;
                n5 %= 10;
                if (0.0f > this.value) {
                    buffer.append("-");
                }
                buffer.append(n4).append(Pressure.getText(29)).append(n5);
                if (!this.showUnitString) break;
                buffer.append(Pressure.getText(26));
                break;
            }
            case 3: {
                float f4 = this.bar2kPa(this.value);
                int n6 = (int)((double)f4 + 0.5);
                buffer.append(n6);
                if (!this.showUnitString) break;
                buffer.append(Pressure.getText(28));
            }
        }
        if (!Pressure.contentEquals(this.lastFormat, buffer)) {
            this.lastFormat = buffer.toString();
        }
        return this.lastFormat;
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 27: {
                    string = " bar";
                    break;
                }
                case 26: {
                    string = " psi";
                    break;
                }
                case 28: {
                    string = " kPa";
                    break;
                }
                case 30: {
                    string = ",";
                    break;
                }
                case 29: {
                    string = ".";
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
        if (!Pressure.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        String string = null;
        switch (n) {
            case 2: {
                string = Pressure.getText(26);
                break;
            }
            case 3: {
                string = Pressure.getText(28);
                break;
            }
            default: {
                string = Pressure.getText(27);
            }
        }
        return null != string ? string.trim() : "";
    }

    @Override
    public String getFormattedValue() {
        return this.getFormattedValue(this.useInstanceUnit ? this.unit : systemUnit);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String getFormattedValue(int n) {
        boolean bl = this.showUnitString;
        try {
            this.showUnitString = false;
            String string = this.isMetricvalid() ? this.format(n) : this.getInvalidText();
            return string;
        }
        finally {
            this.showUnitString = bl;
        }
    }

    @Override
    public String[] getStringValueAndUnit() {
        return new String[]{this.getFormattedValue(), this.getFormattedMetricUnit()};
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

