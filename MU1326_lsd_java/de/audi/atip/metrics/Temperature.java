/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class Temperature
extends AbstractMetrics {
    public static final int CELSIUS = 1;
    public static final int FAHRENHEIT = 2;
    public static final int KELVIN = 3;
    private static final String TEXT_FAHRENHEIT = " \u00b0F";
    private static final String TEXT_KELVIN = " K";
    private static final String TEXT_CELSIUS = " \u00b0C";
    private static final String TEXT_NEGATIVE = "-";
    private static String TEXT_INVALID = "---";
    public static final int MODE_DEFAULT = 31;
    public static final int MODE_RDK = 32;
    public static final int MODE_VALUE_ONLY = 33;
    public static final int MODE_UNIT_ONLY = 34;
    private static final int NEGATIVE_SIGN = -1;
    private static final float CELSIUS2KELVIN = 273.15f;
    private static int systemUnit = 1;

    public Temperature(float f2, int n) {
        super(f2, n);
        this.importValue();
    }

    protected final float celsius2kelvin(float f2) {
        return f2 + 273.15f;
    }

    protected final float kelvin2celsius(float f2) {
        return f2 - 273.15f;
    }

    protected final float celsius2fahrenheit(float f2) {
        return (float)((double)f2 * 1.8) + 32.0f;
    }

    protected final float fahrenheit2celsius(float f2) {
        return (f2 - 32.0f) / 1.8f;
    }

    protected final void importValue() {
        switch (this.unit) {
            case 2: {
                this.value = this.fahrenheit2celsius(this.value);
                break;
            }
            case 3: {
                this.value = this.kelvin2celsius(this.value);
                break;
            }
        }
    }

    public static boolean unitIsValid(int n) {
        return n == 1 || n == 2 || n == 3;
    }

    protected static boolean modeIsValid(int n) {
        return n == 31 || n == 33 || n == 34 || n == 32;
    }

    public static void setSystemUnit(int n) {
        if (!Temperature.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        systemUnit = n;
    }

    public static int getSystemUnit() {
        return systemUnit;
    }

    public void setValue(float f2) {
        this.value = f2;
        this.importValue();
    }

    public void setValue(float f2, int n) {
        switch (n) {
            case 2: {
                this.value = this.fahrenheit2celsius(f2);
                break;
            }
            case 3: {
                this.value = this.kelvin2celsius(f2);
                break;
            }
        }
    }

    public float getValue() {
        return this.getValueInUnit(systemUnit);
    }

    public float getValue(int n) {
        if (!Temperature.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        return this.getValueInUnit(n);
    }

    protected float getValueInUnit(int n) {
        switch (n) {
            case 2: {
                return this.celsius2fahrenheit(this.value);
            }
            case 3: {
                return this.celsius2kelvin(this.value);
            }
        }
        return this.value;
    }

    public String format() {
        if (this.useInstanceUnit) {
            return this.format(this.unit);
        }
        return this.format(systemUnit);
    }

    public String formatWithMetricsMode(int n) {
        if (this.useInstanceUnit) {
            return this.format(this.unit, n);
        }
        return this.format(systemUnit, n);
    }

    public String format(int n) {
        return this.format(n, 31);
    }

    public String format(int n, int n2) {
        int n3;
        int n4;
        int n5;
        if (!Temperature.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        if (!Temperature.modeIsValid(n2)) {
            throw new IllegalArgumentException();
        }
        Buffer buffer = new Buffer();
        int n6 = 0;
        int n7 = 1;
        switch (n) {
            case 3: {
                float f2 = this.celsius2kelvin(this.value);
                n5 = (int)f2;
                n4 = 34;
                n3 = -1;
                break;
            }
            case 2: {
                float f3 = this.celsius2fahrenheit(this.value);
                if (f3 < 0.0f) {
                    f3 = -1.0f * f3;
                    n7 = -1;
                }
                n5 = Math.round(f3);
                n4 = 33;
                n3 = -1;
                break;
            }
            default: {
                float f4;
                if (this.value >= 0.0f) {
                    f4 = this.value;
                } else {
                    f4 = -1.0f * this.value;
                    n7 = -1;
                }
                n5 = (int)f4;
                n6 = (int)((double)(f4 * 10.0f) + 0.5) - n5 * 10;
                n5 += n6 / 10;
                n6 %= 10;
                n4 = 35;
                n3 = 36;
            }
        }
        if (n2 == 32) {
            buffer.append(n7 * n5).append(Temperature.getText(n4));
        } else if (n2 == 34) {
            buffer.append(Temperature.getText(n4).trim());
        } else {
            if (n5 == 0 && n7 == -1) {
                buffer.append(TEXT_NEGATIVE);
                buffer.append(n5);
            } else {
                buffer.append(n7 * n5);
            }
            if (n3 != -1) {
                buffer.append(Temperature.getText(36)).append(n6);
            }
            if (n2 == 31) {
                buffer.append(Temperature.getText(n4));
            }
        }
        if (!Temperature.contentEquals(this.lastFormat, buffer)) {
            this.lastFormat = buffer.toString();
        }
        return this.lastFormat;
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 35: {
                    string = TEXT_CELSIUS;
                    break;
                }
                case 34: {
                    string = TEXT_KELVIN;
                    break;
                }
                case 33: {
                    string = TEXT_FAHRENHEIT;
                    break;
                }
                case 36: {
                    string = ",";
                    break;
                }
                default: {
                    string = "";
                }
            }
        }
        return string;
    }

    public String getFormattedMetricUnit() {
        return this.getFormattedUnit(this.useInstanceUnit ? this.unit : systemUnit);
    }

    public String getFormattedUnit(int n) {
        return this.format(n, 34);
    }

    public String getFormattedValue() {
        return this.getFormattedValue(this.useInstanceUnit ? this.unit : systemUnit);
    }

    public String getFormattedValue(int n) {
        return this.isMetricvalid() ? this.format(n, 33) : this.getInvalidText();
    }

    public String getInvalidText() {
        return TEXT_INVALID;
    }
}

