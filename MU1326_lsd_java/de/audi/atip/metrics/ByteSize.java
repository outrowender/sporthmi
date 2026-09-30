/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public final class ByteSize
extends AbstractMetrics {
    public static final int UNIT_NONE = 40;
    public static final int UNIT_BYTE = 41;
    public static final int UNIT_KB = 42;
    public static final int UNIT_MB = 43;
    public static final int UNIT_GB = 44;
    public static final int UNIT_TB = 45;
    public static final int UNIT_AUTO = 46;
    private static final String TEXT_UNIT_BYTE = " B";
    private static final String TEXT_UNIT_KB = " KB";
    private static final String TEXT_UNIT_MB = " MB";
    private static final String TEXT_UNIT_GB = " GB";
    private static final String TEXT_UNIT_TB = " TB";
    private static String TEXT_INVALID = "---";
    private static final int DECIMAL_UNIT_VALUE = 1000;
    private static final int BINARY_UNIT_VALUE = 1024;
    public static final float[] DECIMAL_UNIT_VALUES = new float[]{1.0f, 1000.0f, 1000000.0f, 1.0E9f, 1.0E12f};
    public static final float[] BINARY_UNIT_VALUES = new float[]{1.0f, 1024.0f, 1048576.0f, 1.0737418E9f, 1.0995116E12f};
    private float[] unitValues;
    private static final float ERROR = 1.0E-5f;
    private int fracDigitNumber;

    public ByteSize(float f2, int n) {
        super(f2, n);
        if (f2 < 0.0f || n < 40 || n > 45) {
            throw new IllegalArgumentException();
        }
        this.setDecimalUnitValues(true);
        this.setFractionalDigitNumber(2);
    }

    public ByteSize(long l, int n, boolean bl) {
        super(ByteSize.calculateOutputSize(l, bl ? 1000 : 1024), ByteSize.calculateOutputUnit(l, bl ? 1000 : 1024));
        this.setDecimalUnitValues(bl);
        this.setFractionalDigitNumber(n);
    }

    private void setDecimalUnitValues(boolean bl) {
        this.unitValues = bl ? DECIMAL_UNIT_VALUES : BINARY_UNIT_VALUES;
    }

    public String format(int n) {
        if (n < 40 || n > 46) {
            throw new IllegalArgumentException();
        }
        if (n == 46) {
            n = this.getDefaultOutputUnit();
        }
        float f2 = this.getValue(n);
        Buffer buffer = new Buffer(32);
        this.formatValue(buffer, f2);
        if (n != 40) {
            buffer.append(this.getUnitText(n));
        }
        return buffer.toString();
    }

    private void formatValue(Buffer buffer, float f2) {
        int n = (int)f2;
        float f3 = (float)Math.pow(10.0, this.fracDigitNumber);
        int n2 = (int)(f2 * f3 - (float)n * f3);
        buffer.append(n);
        if (n2 > 0) {
            buffer.append(ByteSize.getText(51));
            int n3 = this.fracDigitNumber - 1 - ByteSize.log10(n2);
            for (int i2 = 0; i2 < n3; ++i2) {
                buffer.append('0');
            }
            buffer.append(n2);
        }
    }

    public float getValue(int n) {
        if (n == 46) {
            n = this.getDefaultOutputUnit();
        }
        float f2 = n == this.unit ? this.value : (n > this.unit ? this.value / this.unitValues[n - this.unit] : this.value * this.unitValues[this.unit - n]);
        return f2;
    }

    private int getDefaultOutputUnit() {
        if (this.value < 1.0E-5f) {
            return 41;
        }
        float f2 = this.value;
        int n = 0;
        if (f2 < 1.0f) {
            while (f2 < 1.0f) {
                f2 *= 1000.0f;
                --n;
            }
        } else {
            while (f2 >= 1000.0f) {
                f2 /= 1000.0f;
                ++n;
            }
        }
        return Math.max(Math.min(this.unit + n, 45), 41);
    }

    private static int calculateOutputUnit(long l, int n) {
        int n2;
        for (n2 = 41; l >= (long)n && n2 < 45; l /= (long)n, ++n2) {
        }
        return n2;
    }

    private static float calculateOutputSize(long l, int n) {
        float f2 = l;
        for (int i2 = 41; f2 >= (float)n && i2 < 45; f2 /= (float)n, ++i2) {
        }
        return f2;
    }

    private static int log10(float f2) {
        return (int)(Math.log(f2) / Math.log(10.0) + (double)1.0E-5f);
    }

    private void setFractionalDigitNumber(int n) {
        if (n < 0 || n > 8) {
            throw new IllegalArgumentException();
        }
        this.fracDigitNumber = n;
    }

    public String format() {
        return this.format(this.unit);
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    private String getUnitText(int n) {
        int n2;
        if (n < 40 || n > 45) {
            throw new IllegalArgumentException();
        }
        switch (n) {
            case 41: {
                n2 = 52;
                break;
            }
            case 42: {
                n2 = 53;
                break;
            }
            case 43: {
                n2 = 54;
                break;
            }
            case 44: {
                n2 = 55;
                break;
            }
            case 45: {
                n2 = 56;
                break;
            }
            default: {
                n2 = 52;
            }
        }
        return ByteSize.getText(n2);
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 51: {
                    string = ",";
                    break;
                }
                case 52: {
                    string = TEXT_UNIT_BYTE;
                    break;
                }
                case 53: {
                    string = TEXT_UNIT_KB;
                    break;
                }
                case 54: {
                    string = TEXT_UNIT_MB;
                    break;
                }
                case 55: {
                    string = TEXT_UNIT_GB;
                    break;
                }
                case 56: {
                    string = TEXT_UNIT_TB;
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
        return this.getFormattedUnit(this.unit);
    }

    public String getFormattedUnit(int n) {
        String string;
        if (n < 40 || n > 46) {
            throw new IllegalArgumentException();
        }
        if (n == 46) {
            n = this.getDefaultOutputUnit();
        }
        return null != (string = this.getUnitText(n)) ? string.trim() : "";
    }

    public String getFormattedValue() {
        return this.getFormattedValue(this.unit);
    }

    public String getFormattedValue(int n) {
        if (n < 40 || n > 46) {
            throw new IllegalArgumentException();
        }
        if (n == 46) {
            n = this.getDefaultOutputUnit();
        }
        Buffer buffer = new Buffer(32);
        this.formatValue(buffer, this.getValue(n));
        return this.isMetricvalid() ? buffer.toString().trim() : this.getInvalidText();
    }

    public String getInvalidText() {
        return TEXT_INVALID;
    }
}

