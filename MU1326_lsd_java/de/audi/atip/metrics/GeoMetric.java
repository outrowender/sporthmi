/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.GeoConstants;
import de.esolutions.fw.util.commons.Buffer;
import java.text.DecimalFormat;

public class GeoMetric
extends AbstractMetrics
implements GeoConstants {
    private static final String TEXT_SEPARATOR_COORDINATES_DIRECTION = " ";
    private static final String TEXT_UNIT_SECONDS_AFTER_COMMA = "\"";
    private static final String TEXT_UNIT_SECONDS = ".";
    private static final String TEXT_UNIT_MINUTES = "'";
    private static final String TEXT_UNIT_DEGREE = "\u00b0";
    private static final String TEXT_DIRECTION_SOUTH = "S";
    private static final String TEXT_DIRECTION_NORTH = "N";
    private static final String TEXT_DIRECTION_WEST = "W";
    private static final String TEXT_DIRECTION_EAST = "E";
    private static final String TEXT_SEPARATOR_LATITUDE_LONGITUDE = ", ";
    private static final String TEXT_INVALID = "---";
    public static final int MODE_LATITUDE_ONLY = 20;
    public static final int MODE_LONGTITUDE_ONLY = 21;
    private int[][] geoValues;
    final DecimalFormat decimalFormat000 = new DecimalFormat("000");
    final DecimalFormat decimalFormat00 = new DecimalFormat("00");
    final DecimalFormat decimalFormat0 = new DecimalFormat("0");
    private boolean isSecondsVisible = true;

    public GeoMetric() {
        this(new int[2][5]);
    }

    public GeoMetric(int n, int n2) {
        this();
        this.setGeoValues(n, n2);
    }

    public GeoMetric(String string) {
        this();
        int n = string.indexOf(GeoMetric.getText(50));
        if (n < 0) {
            return;
        }
        String string2 = string.substring(0, n);
        String string3 = string.substring(n + 2);
        int[] nArray = this.importFormattedWGS84(string2);
        int[] nArray2 = this.importFormattedWGS84(string3);
        if (nArray2 == null || nArray == null) {
            return;
        }
        this.setGeoValues(new int[][]{nArray, nArray2});
    }

    private GeoMetric(int[][] nArray) {
        super(-1.0f, -1);
        this.geoValues = this.checkValues(nArray) ? nArray : new int[2][5];
    }

    public int[][] getGeoValues() {
        return this.geoValues;
    }

    public int getLongitude() {
        return this.retrieveWGS84(1);
    }

    public int getLatitude() {
        return this.retrieveWGS84(0);
    }

    private int retrieveWGS84(int n) {
        int n2 = this.geoValues[n][0];
        int n3 = this.geoValues[n][1];
        int n4 = this.geoValues[n][2];
        int n5 = this.geoValues[n][3];
        int n6 = this.geoValues[n][4];
        double d2 = (double)n4 + (double)n5 / Math.pow(10.0, 1.0);
        int n7 = n2 * 0xB60B60 + n3 * 198841 + (int)(d2 * 3314.0);
        return n7 * n6;
    }

    public final void setGeoValues(int n, int n2) {
        GeoMetric.wgs84ToDegree(n2, this.geoValues[1], 1);
        GeoMetric.wgs84ToDegree(n, this.geoValues[0], 1);
    }

    public final void setGeoValues(int[][] nArray) {
        this.geoValues = this.checkValues(nArray) ? nArray : new int[2][5];
    }

    private final boolean checkValues(int[][] nArray) {
        return nArray != null && nArray.length == 2 && nArray[0].length == 5;
    }

    public String toString() {
        return this.format();
    }

    public String format(int n) {
        return this.format();
    }

    public String format(int n, int n2) {
        if (n2 == 20) {
            return this.formatLatitude();
        }
        if (n2 == 21) {
            return this.formatLongitude();
        }
        return this.format();
    }

    public String format() {
        return new Buffer().append(this.formatLatitude()).append(GeoMetric.getText(50)).append(this.formatLongitude()).toString();
    }

    public String formatLatitude() {
        return this.formatValue(0);
    }

    public String formatLongitude() {
        return this.formatValue(1);
    }

    private String formatValue(int n) {
        this.decimalFormat000.setMinimumIntegerDigits(1);
        this.decimalFormat00.setMinimumIntegerDigits(2);
        String string = this.getDirectionString(n, this.geoValues[n][4]);
        Buffer buffer = new Buffer();
        buffer.append(this.decimalFormat000.format(this.geoValues[n][0]));
        buffer.append(GeoMetric.getText(45));
        buffer.append(this.decimalFormat00.format(this.geoValues[n][1]));
        buffer.append(GeoMetric.getText(44));
        buffer.append(this.decimalFormat00.format(this.geoValues[n][2]));
        if (this.isSecondsVisible) {
            buffer.append(GeoMetric.getText(43));
            buffer.append(this.decimalFormat0.format(this.geoValues[n][3]));
        }
        buffer.append(GeoMetric.getText(42));
        buffer.append(GeoMetric.getText(41));
        buffer.append(string);
        return buffer.toString();
    }

    public void setSecondsVisible(boolean bl) {
        this.isSecondsVisible = bl;
    }

    private String getDirectionString(int n, int n2) {
        if (n == 1) {
            return n2 == 1 ? GeoMetric.getText(49) : GeoMetric.getText(48);
        }
        return n2 == 1 ? GeoMetric.getText(47) : GeoMetric.getText(46);
    }

    public float getValue() {
        throw new UnsupportedOperationException("getValue() unsupported for GeoMetric! Use getGeoValues()");
    }

    public float getValue(int n) {
        throw new UnsupportedOperationException("getValue() unsupported for GeoMetric! Use getGeoValues()");
    }

    public void setValue(float f2) {
        throw new UnsupportedOperationException("getValue() unsupported for GeoMetric! Use setGeoValues(..)");
    }

    public static boolean wgs84ToDegree(int n, int[] nArray, int n2) {
        int n3 = n;
        if (n2 < 1) {
            return false;
        }
        if (nArray != null && nArray.length == 5) {
            int n4 = n3 < 0 ? -1 : 1;
            n3 = Math.abs(n3);
            nArray[0] = n3 / 0xB60B60;
            nArray[1] = (n3 %= 0xB60B60) / 198841;
            if (nArray[1] == 60) {
                nArray[1] = 59;
            }
            double d2 = (double)(n3 %= 198841) / 3314.0;
            double d3 = Math.pow(10.0, n2);
            d2 = (double)Math.round(d2 * d3) / d3;
            int n5 = (int)d2;
            int n6 = (int)Math.round((d2 - (double)n5) * d3);
            if (n5 == 60) {
                nArray[2] = 59;
                nArray[3] = 9;
            } else {
                nArray[2] = n5;
                nArray[3] = n6;
            }
            nArray[4] = n4;
            return true;
        }
        return false;
    }

    public final int[] importFormattedWGS84(String string) {
        int[] nArray = new int[4];
        int[] nArray2 = new int[5];
        nArray[0] = string.indexOf(GeoMetric.getText(45));
        nArray[1] = string.indexOf(GeoMetric.getText(44));
        nArray[2] = string.indexOf(GeoMetric.getText(43));
        nArray[3] = string.indexOf(GeoMetric.getText(42));
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] >= 0) continue;
            return null;
        }
        nArray2[0] = Integer.parseInt(string.substring(0, nArray[0]));
        nArray2[1] = Integer.parseInt(string.substring(nArray[0] + 1, nArray[1]));
        nArray2[2] = Integer.parseInt(string.substring(nArray[1] + 1, nArray[2]));
        nArray2[3] = Integer.parseInt(string.substring(nArray[2] + 1, nArray[3]));
        nArray2[4] = string.endsWith(GeoMetric.getText(47)) ? 1 : (string.endsWith(GeoMetric.getText(46)) ? -1 : (string.endsWith(GeoMetric.getText(48)) ? -1 : 1));
        return nArray2;
    }

    public static final String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 41: {
                    string = TEXT_SEPARATOR_COORDINATES_DIRECTION;
                    break;
                }
                case 42: {
                    string = TEXT_UNIT_SECONDS_AFTER_COMMA;
                    break;
                }
                case 43: {
                    string = TEXT_UNIT_SECONDS;
                    break;
                }
                case 44: {
                    string = TEXT_UNIT_MINUTES;
                    break;
                }
                case 45: {
                    string = TEXT_UNIT_DEGREE;
                    break;
                }
                case 46: {
                    string = TEXT_DIRECTION_SOUTH;
                    break;
                }
                case 47: {
                    string = TEXT_DIRECTION_NORTH;
                    break;
                }
                case 48: {
                    string = TEXT_DIRECTION_WEST;
                    break;
                }
                case 49: {
                    string = TEXT_DIRECTION_EAST;
                    break;
                }
                case 50: {
                    string = TEXT_SEPARATOR_LATITUDE_LONGITUDE;
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
        return this.format();
    }

    public String getFormattedUnit(int n) {
        return this.format();
    }

    public String getFormattedValue() {
        return this.isMetricvalid() ? this.format() : this.getInvalidText();
    }

    public String getFormattedValue(int n) {
        return this.getFormattedValue();
    }

    public String getInvalidText() {
        return TEXT_INVALID;
    }
}

