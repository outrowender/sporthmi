/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class CompassMetric
extends AbstractMetrics {
    private static final String TEXT_SPACE = " ";
    private static final String TEXT_DEGREE = "\u00b0";
    private static final String TEXT_N = "N";
    private static final String TEXT_NNO = "NNO";
    private static final String TEXT_NO = "NO";
    private static final String TEXT_ONO = "ONO";
    private static final String TEXT_O = "O";
    private static final String TEXT_OSO = "OSO";
    private static final String TEXT_SO = "SO";
    private static final String TEXT_SSO = "SSO";
    private static final String TEXT_S = "S";
    private static final String TEXT_SSW = "SSW";
    private static final String TEXT_SW = "SW";
    private static final String TEXT_WSW = "WSW";
    private static final String TEXT_W = "W";
    private static final String TEXT_WNW = "WNW";
    private static final String TEXT_NW = "NW";
    private static final String TEXT_NNW = "NNW";
    private static String TEXT_INVALID = "---";
    public static final int ORIENTATION_N = 1;
    public static final int ORIENTATION_NNO = 2;
    public static final int ORIENTATION_NO = 3;
    public static final int ORIENTATION_ONO = 4;
    public static final int ORIENTATION_O = 5;
    public static final int ORIENTATION_OSO = 6;
    public static final int ORIENTATION_SO = 7;
    public static final int ORIENTATION_SSO = 8;
    public static final int ORIENTATION_S = 9;
    public static final int ORIENTATION_SSW = 10;
    public static final int ORIENTATION_SW = 11;
    public static final int ORIENTATION_WSW = 12;
    public static final int ORIENTATION_W = 13;
    public static final int ORIENTATION_WNW = 14;
    public static final int ORIENTATION_NW = 15;
    public static final int ORIENTATION_NNW = 16;
    public static final int MODE_ORIENTATIONS_8 = 1;
    public static final int MODE_ORIENTATIONS_16 = 2;
    public static final int UNIT_DEGREE = 1;
    private int orientation;

    public CompassMetric(float f2, int n) {
        super(f2, 1);
        this.setValue(f2);
        this.setOrientation(n);
    }

    public void setOrientation(int n) {
        if (1 > n || n > 16) {
            throw new IllegalArgumentException("The given orientation (" + n + ") cannot be used to create a CompassMetric instance.");
        }
        this.orientation = n;
    }

    public void setValue(float f2) {
        if (!(0.0f <= f2) || !(f2 <= 360.0f)) {
            throw new IllegalArgumentException("The given angle (" + f2 + ") cannot be used to create a CompassMetric instance.");
        }
        this.value = f2;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getValue() {
        return this.value;
    }

    public float getValue(int n) {
        switch (n) {
            case 1: {
                return this.value;
            }
        }
        throw new IllegalArgumentException("The given unit (" + n + ") cannot be used for the CompassMetric.");
    }

    public String format() {
        Buffer buffer = new Buffer();
        buffer.append(Math.round(this.value));
        buffer.append(this.getFormattedMetricUnit());
        return buffer.toString();
    }

    public String format(int n) {
        return this.format();
    }

    public String getFormattedMetricUnit() {
        Buffer buffer = new Buffer();
        buffer.append(TEXT_DEGREE);
        buffer.append(TEXT_SPACE);
        buffer.append(this.getOrientationText(this.orientation));
        return buffer.toString();
    }

    public String getFormattedUnit(int n) {
        return this.getFormattedMetricUnit();
    }

    public String getFormattedValue() {
        Buffer buffer = new Buffer();
        buffer.append(Math.round(this.value));
        return this.isMetricvalid() ? buffer.toString() : this.getInvalidText();
    }

    public String getFormattedValue(int n) {
        return this.getFormattedValue();
    }

    private String getOrientationText(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 47;
                break;
            }
            case 2: {
                n2 = 70;
                break;
            }
            case 3: {
                n2 = 71;
                break;
            }
            case 4: {
                n2 = 72;
                break;
            }
            case 5: {
                n2 = 49;
                break;
            }
            case 6: {
                n2 = 73;
                break;
            }
            case 7: {
                n2 = 74;
                break;
            }
            case 8: {
                n2 = 75;
                break;
            }
            case 9: {
                n2 = 46;
                break;
            }
            case 10: {
                n2 = 76;
                break;
            }
            case 11: {
                n2 = 77;
                break;
            }
            case 12: {
                n2 = 78;
                break;
            }
            case 13: {
                n2 = 48;
                break;
            }
            case 14: {
                n2 = 79;
                break;
            }
            case 15: {
                n2 = 80;
                break;
            }
            case 16: {
                n2 = 81;
            }
        }
        return CompassMetric.getText(n2);
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 47: {
                    return TEXT_N;
                }
                case 70: {
                    return TEXT_NNO;
                }
                case 71: {
                    return TEXT_NO;
                }
                case 72: {
                    return TEXT_ONO;
                }
                case 49: {
                    return TEXT_O;
                }
                case 73: {
                    return TEXT_OSO;
                }
                case 74: {
                    return TEXT_SO;
                }
                case 75: {
                    return TEXT_SSO;
                }
                case 46: {
                    return TEXT_S;
                }
                case 76: {
                    return TEXT_SSW;
                }
                case 77: {
                    return TEXT_SW;
                }
                case 78: {
                    return TEXT_WSW;
                }
                case 48: {
                    return TEXT_W;
                }
                case 79: {
                    return TEXT_WNW;
                }
                case 80: {
                    return TEXT_NW;
                }
                case 81: {
                    return TEXT_NNW;
                }
            }
            return "";
        }
        return string;
    }

    public String getInvalidText() {
        return TEXT_INVALID;
    }
}

