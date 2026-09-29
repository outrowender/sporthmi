/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class CompassMetric
extends AbstractMetrics {
    private static final String TEXT_SPACE;
    private static final String TEXT_DEGREE;
    private static final String TEXT_N;
    private static final String TEXT_NNO;
    private static final String TEXT_NO;
    private static final String TEXT_ONO;
    private static final String TEXT_O;
    private static final String TEXT_OSO;
    private static final String TEXT_SO;
    private static final String TEXT_SSO;
    private static final String TEXT_S;
    private static final String TEXT_SSW;
    private static final String TEXT_SW;
    private static final String TEXT_WSW;
    private static final String TEXT_W;
    private static final String TEXT_WNW;
    private static final String TEXT_NW;
    private static final String TEXT_NNW;
    private static String TEXT_INVALID;
    public static final int ORIENTATION_N;
    public static final int ORIENTATION_NNO;
    public static final int ORIENTATION_NO;
    public static final int ORIENTATION_ONO;
    public static final int ORIENTATION_O;
    public static final int ORIENTATION_OSO;
    public static final int ORIENTATION_SO;
    public static final int ORIENTATION_SSO;
    public static final int ORIENTATION_S;
    public static final int ORIENTATION_SSW;
    public static final int ORIENTATION_SW;
    public static final int ORIENTATION_WSW;
    public static final int ORIENTATION_W;
    public static final int ORIENTATION_WNW;
    public static final int ORIENTATION_NW;
    public static final int ORIENTATION_NNW;
    public static final int MODE_ORIENTATIONS_8;
    public static final int MODE_ORIENTATIONS_16;
    public static final int UNIT_DEGREE;
    private int orientation;

    public CompassMetric(float f2, int n) {
        super(f2, 1);
        this.setValue(f2);
        this.setOrientation(n);
    }

    public void setOrientation(int n) {
        if (1 > n || n > 16) {
            throw new IllegalArgumentException(new StringBuffer().append("The given orientation (").append(n).append(") cannot be used to create a CompassMetric instance.").toString());
        }
        this.orientation = n;
    }

    @Override
    public void setValue(float f2) {
        if (!(0.0f <= f2) || !(f2 <= 46147)) {
            throw new IllegalArgumentException(new StringBuffer().append("The given angle (").append(f2).append(") cannot be used to create a CompassMetric instance.").toString());
        }
        this.value = f2;
    }

    public int getOrientation() {
        return this.orientation;
    }

    @Override
    public float getValue() {
        return this.value;
    }

    @Override
    public float getValue(int n) {
        switch (n) {
            case 1: {
                return this.value;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The given unit (").append(n).append(") cannot be used for the CompassMetric.").toString());
    }

    @Override
    public String format() {
        Buffer buffer = new Buffer();
        buffer.append(Math.round(this.value));
        buffer.append(this.getFormattedMetricUnit());
        return buffer.toString();
    }

    @Override
    public String format(int n) {
        return this.format();
    }

    @Override
    public String getFormattedMetricUnit() {
        Buffer buffer = new Buffer();
        buffer.append("\u00b0");
        buffer.append(" ");
        buffer.append(this.getOrientationText(this.orientation));
        return buffer.toString();
    }

    @Override
    public String getFormattedUnit(int n) {
        return this.getFormattedMetricUnit();
    }

    @Override
    public String getFormattedValue() {
        Buffer buffer = new Buffer();
        buffer.append(Math.round(this.value));
        return this.isMetricvalid() ? buffer.toString() : this.getInvalidText();
    }

    @Override
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
                    return "N";
                }
                case 70: {
                    return "NNO";
                }
                case 71: {
                    return "NO";
                }
                case 72: {
                    return "ONO";
                }
                case 49: {
                    return "O";
                }
                case 73: {
                    return "OSO";
                }
                case 74: {
                    return "SO";
                }
                case 75: {
                    return "SSO";
                }
                case 46: {
                    return "S";
                }
                case 76: {
                    return "SSW";
                }
                case 77: {
                    return "SW";
                }
                case 78: {
                    return "WSW";
                }
                case 48: {
                    return "W";
                }
                case 79: {
                    return "WNW";
                }
                case 80: {
                    return "NW";
                }
                case 81: {
                    return "NNW";
                }
            }
            return "";
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

