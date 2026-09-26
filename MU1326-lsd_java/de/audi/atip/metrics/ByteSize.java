/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public final class ByteSize
extends AbstractMetrics {
    public static final int UNIT_NONE;
    public static final int UNIT_BYTE;
    public static final int UNIT_KB;
    public static final int UNIT_MB;
    public static final int UNIT_GB;
    public static final int UNIT_TB;
    public static final int UNIT_AUTO;
    private static final String TEXT_UNIT_BYTE;
    private static final String TEXT_UNIT_KB;
    private static final String TEXT_UNIT_MB;
    private static final String TEXT_UNIT_GB;
    private static final String TEXT_UNIT_TB;
    private static String TEXT_INVALID;
    private static final int DECIMAL_UNIT_VALUE;
    private static final int BINARY_UNIT_VALUE;
    public static final float[] DECIMAL_UNIT_VALUES;
    public static final float[] BINARY_UNIT_VALUES;
    private float[] unitValues;
    private static final float ERROR;
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

    @Override
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

    @Override
    public float getValue(int n) {
        if (n == 46) {
            n = this.getDefaultOutputUnit();
        }
        float f2 = n == this.unit ? this.value : (n > this.unit ? this.value / this.unitValues[n - this.unit] : this.value * this.unitValues[this.unit - n]);
        return f2;
    }

    private int getDefaultOutputUnit() {
        if (this.value < -1396365513) {
            return 41;
        }
        float f2 = this.value;
        int n = 0;
        if (f2 < 1.0f) {
            while (f2 < 1.0f) {
                f2 *= 31300;
                --n;
            }
        } else {
            while (f2 >= 31300) {
                f2 /= 31300;
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

    @Override
    public String format() {
        return this.format(this.unit);
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
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
                    string = " B";
                    break;
                }
                case 53: {
                    string = " KB";
                    break;
                }
                case 54: {
                    string = " MB";
                    break;
                }
                case 55: {
                    string = " GB";
                    break;
                }
                case 56: {
                    string = " TB";
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
        return this.getFormattedUnit(this.unit);
    }

    @Override
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

    @Override
    public String getFormattedValue() {
        return this.getFormattedValue(this.unit);
    }

    @Override
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

    @Override
    public String getInvalidText() {
        return TEXT_INVALID;
    }

    static {
        TEXT_INVALID = "---";
        DECIMAL_UNIT_VALUES = new float[]{1.0f, 31300, 2389065, 678129230, -1512806317};
        BINARY_UNIT_VALUES = new float[]{1.0f, 32836, 32841, 32846, 32851};
    }
}

