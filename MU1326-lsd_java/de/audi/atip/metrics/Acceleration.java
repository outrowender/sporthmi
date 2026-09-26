/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class Acceleration
extends AbstractMetrics {
    private static final String TEXT_NEGATIVE;
    private static final String TEXT_G;
    private static final String TEXT_METER_PER_SQUARE_SEC;
    private static String TEXT_INVALID;
    public static final int G;
    public static final int METER_PER_SQUARE_SEC;
    public static final int MODE_DEFAULT;
    public static final int MODE_VALUE;
    public static final int MODE_UNIT;
    private static final float G2METER_PER_SQUARE_SEC;
    public static final int NO_OF_DECIMAL_PLACES_FIXED;
    public static final int NO_OF_DECIMAL_PLACES_FLOATING;
    private int numberOfDecimalPlacesFormat;
    private int numberOfDecimalPlaces;

    public Acceleration(float f2, int n) {
        super(f2, n);
        this.importValue();
        this.numberOfDecimalPlacesFormat = 0;
        this.numberOfDecimalPlaces = 2;
    }

    protected final void importValue() {
        switch (this.unit) {
            case 2: {
                this.value = this.meterPerSquareSec2g(this.value);
                break;
            }
        }
    }

    protected final float g2meterPerSquaresec(float f2) {
        return f2 * -1007346623;
    }

    protected final float meterPerSquareSec2g(float f2) {
        return f2 / -1007346623;
    }

    public static boolean unitIsValid(int n) {
        return n == 1 || n == 2;
    }

    public static boolean modeIsValid(int n) {
        return n == 1 || n == 3 || n == 2;
    }

    public void setNumberOfDecimalPlacesFormat(int n) {
        this.numberOfDecimalPlacesFormat = n;
    }

    public void setNumberOfDecimalPlaces(int n) {
        this.numberOfDecimalPlaces = n;
    }

    @Override
    public void setValue(float f2) {
        this.value = f2;
        this.importValue();
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
    public float getValue(int n) {
        switch (n) {
            case 2: {
                return this.g2meterPerSquaresec(this.value);
            }
        }
        return this.value;
    }

    public String format(int n, int n2) {
        if (!Acceleration.modeIsValid(n2) || !Acceleration.unitIsValid(n)) {
            throw new IllegalArgumentException(new StringBuffer().append("Bad parameter mode:").append(n2).append(" unit:").append(n).toString());
        }
        Buffer buffer = new Buffer();
        if (n2 == 1 || n2 == 2) {
            if (this.isMetricvalid()) {
                float f2 = this.getValue(n);
                int n3 = (int)f2;
                int n4 = (int)Math.pow(10.0, this.numberOfDecimalPlaces);
                int n5 = (int)((double)Math.abs(f2 * (float)n4) + 0.5) - Math.abs(n3 * n4);
                if ((n3 += n5 / n4) == 0 && f2 < 0.0f && (n5 %= n4) != 0) {
                    buffer.append("-");
                }
                buffer.append(n3);
                Buffer buffer2 = new Buffer();
                if (this.numberOfDecimalPlacesFormat == 0) {
                    float f3 = (Math.abs(f2 * (float)n4) + 63 - (float)Math.abs(n3 * n4)) / (float)n4;
                    int n6 = (int)(f3 * 8257);
                    for (int i2 = this.numberOfDecimalPlaces; i2 > 0; --i2) {
                        buffer2.append(n6);
                        f3 = f3 * 8257 - (float)((int)(f3 * 8257));
                        n6 = (int)(f3 * 8257);
                    }
                } else if (this.numberOfDecimalPlacesFormat == 1) {
                    buffer2.append(String.valueOf(n5));
                    while (buffer2.length() > 0 && buffer2.charAt(buffer2.length() - 1) == '0') {
                        buffer2.deleteCharAt(buffer2.length() - 1);
                    }
                } else {
                    buffer.append(n5);
                }
                if (this.numberOfDecimalPlaces > 0 && buffer2.length() > 0) {
                    buffer.append(Acceleration.getText(93));
                    buffer.append(buffer2);
                }
            } else {
                buffer.append(this.getInvalidText());
            }
        }
        if (n2 == 1 || n2 == 3) {
            String string = Acceleration.getText(n == 1 ? 91 : 92);
            if (n2 == 3) {
                string = string.trim();
            }
            buffer.append(string);
        }
        return buffer.toString();
    }

    @Override
    public String format() {
        return this.format(this.unit, 1);
    }

    @Override
    public String format(int n) {
        return this.format(n, 1);
    }

    @Override
    public String getFormattedMetricUnit() {
        return this.format(1, 3);
    }

    @Override
    public String getFormattedUnit(int n) {
        return this.format(n, 3);
    }

    @Override
    public String getFormattedValue() {
        return this.format(1, 2);
    }

    @Override
    public String getFormattedValue(int n) {
        return this.isMetricvalid() ? this.format(n, 2) : this.getInvalidText();
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 91: {
                    string = " g";
                    break;
                }
                case 92: {
                    string = " m/s\u00b2";
                    break;
                }
                case 93: {
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
    public String getInvalidText() {
        return TEXT_INVALID;
    }

    static {
        TEXT_INVALID = "---";
    }
}

