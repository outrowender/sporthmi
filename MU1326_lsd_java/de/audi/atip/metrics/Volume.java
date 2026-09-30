/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class Volume
extends AbstractMetrics {
    private static final String TEXT_VOLUME_QUARTS = " qt";
    private static final String TEXT_VOLUME_LITER = " l";
    private static String TEXT_INVALID = "---";
    public static final int LITER = 1;
    public static final int GAL_US = 2;
    public static final int GAL_UK = 3;
    private static int systemUnit = 1;

    public Volume(float f2, int n) {
        super(f2, n);
        this.importValue();
    }

    private final void importValue() {
        switch (this.unit) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
        }
    }

    public static boolean unitIsValid(int n) {
        return n == 1 || n == 2 || n == 3;
    }

    public static void setSystemUnit(int n) {
        if (!Volume.unitIsValid(n)) {
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

    public float getValue() {
        return this.getValueInUnit(systemUnit);
    }

    public float getValue(int n) {
        if (!Volume.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        return this.getValueInUnit(n);
    }

    protected float getValueInUnit(int n) {
        switch (n) {
            default: 
        }
        return this.value;
    }

    public String format() {
        if (this.useInstanceUnit) {
            return this.format(this.unit);
        }
        return this.format(systemUnit);
    }

    public String format(int n) {
        if (!Volume.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        Buffer buffer = new Buffer();
        switch (n) {
            case 2: {
                float f2 = this.value;
                this.formatValue(buffer, f2, Volume.getText(39));
                buffer.append(Volume.getText(37));
                break;
            }
            default: {
                float f3 = this.value;
                this.formatValue(buffer, f3, Volume.getText(40));
                buffer.append(Volume.getText(38));
            }
        }
        if (!Volume.contentEquals(this.lastFormat, buffer)) {
            this.lastFormat = buffer.toString();
        }
        return this.lastFormat;
    }

    public String[] getStringValueAndUnit(int n) {
        return new String[]{this.getFormattedValue(n), this.getFormattedUnit(n)};
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 37: {
                    string = TEXT_VOLUME_QUARTS;
                    break;
                }
                case 38: {
                    string = TEXT_VOLUME_LITER;
                    break;
                }
                case 39: {
                    string = ".";
                    break;
                }
                case 40: {
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

    private void formatValue(Buffer buffer, float f2, String string) {
        int n = 100;
        int n2 = (int)f2;
        int n3 = (int)((double)(f2 * (float)n) + 0.5) - n2 * n;
        n2 += n3 / n;
        int n4 = (n3 %= n) / 10;
        int n5 = n3 - n4 * 10;
        buffer.append(n2);
        if (n5 != 0) {
            buffer.append(string).append(n4).append(n5);
        } else if (n4 != 0) {
            buffer.append(string).append(n4);
        }
    }

    public String getFormattedUnit(int n) {
        if (!Volume.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        String string = null;
        switch (n) {
            case 2: {
                string = Volume.getText(37);
                break;
            }
            default: {
                string = Volume.getText(38);
            }
        }
        return null != string ? string.trim() : "";
    }

    public String getFormattedMetricUnit() {
        return this.getFormattedUnit(this.useInstanceUnit ? this.unit : systemUnit);
    }

    public String getFormattedValue() {
        return this.getFormattedValue(this.useInstanceUnit ? this.unit : systemUnit);
    }

    public String getFormattedValue(int n) {
        if (!Volume.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        Buffer buffer = new Buffer();
        String string = null;
        switch (n) {
            case 2: {
                string = Volume.getText(39);
                break;
            }
            default: {
                string = Volume.getText(40);
            }
        }
        this.formatValue(buffer, this.value, string);
        return this.isMetricvalid() ? buffer.toString().trim() : this.getInvalidText();
    }

    public String getInvalidText() {
        return TEXT_INVALID;
    }
}

