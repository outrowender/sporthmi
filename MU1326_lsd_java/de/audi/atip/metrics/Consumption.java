/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class Consumption
extends AbstractMetrics {
    public static final int L_PER_100KM;
    public static final int MPG_US;
    public static final int MPG_UK;
    public static final int KM_PER_L;
    public static final int KWHPM;
    public static final int KWHP100KM;
    public static final int KMPKWH;
    public static final int MPKWH;
    public static final int L_PER_H;
    public static final int GAL_PER_H;
    public static final int KG_PER_H;
    public static final int KWH_PER_H;
    private static final String TEXT_CONSUMPTION_KM_PER_LITER;
    private static final String TEXT_CONSUMPTION_MILES_PER_GALLON;
    private static final String TEXT_CONSUMPTION_LITER_PER_100KM;
    private static final String TEXT_CONSUMPTION_KWHPM;
    private static final String TEXT_CONSUMPTION_KWHP100KM;
    private static final String TEXT_CONSUMPTION_KMPKWH;
    private static final String TEXT_CONSUMPTION_MPKWH;
    private static final String TEXT_CONSUMPTION_LITER_PER_HOUR;
    private static final String TEXT_CONSUMPTION_GALLON_PER_HOUR;
    private static final String TEXT_CONSUMPTION_KILOGRAM_PER_HOUR;
    private static final String TEXT_CONSUMPTION_KILOWATTHOUR_PER_HOUR;
    private static String TEXT_INVALID;
    private static int systemUnit;
    private static int systemUnitElektro;
    public static final boolean REFERENCE_UNIT_PETROL;
    public static final boolean REFERENCE_UNIT_ELEKTRO;
    private boolean referenceUnit = true;
    public static final int ZERO_VALUE_FORMAT_ZEROS;
    public static final int ZERO_VALUE_FORMAT_MINUS;
    private int zeroValueFormat;
    private int numberOfMajorPlacesMax;

    public Consumption(float f2, int n) {
        super(f2, n);
        this.importValue();
        this.zeroValueFormat = 0;
        this.numberOfMajorPlacesMax = 2;
    }

    public Consumption(float f2, int n, boolean bl) {
        this(f2, n);
        this.referenceUnit = bl;
    }

    private static float convertData(float f2, int n, int n2) {
        if (n != n2) {
            throw new IllegalArgumentException("Data conversion between different units is not supported!");
        }
        return f2;
    }

    private void importValue() {
        switch (this.unit) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
        }
    }

    public static boolean unitIsValid(int n) {
        return n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 10 || n == 11 || n == 12;
    }

    public static void setSystemUnit(int n) {
        if (!Consumption.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        systemUnit = n;
    }

    public static void setSystemUnitElektro(int n) {
        if (!Consumption.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        systemUnitElektro = n;
    }

    public static int getSystemUnit() {
        return systemUnit;
    }

    public static int getSystemUnitElektro() {
        return systemUnitElektro;
    }

    public void setZeroValueFormat(int n) {
        this.zeroValueFormat = n;
    }

    public void setNumberOfMajorPlacesMax(int n) {
        this.numberOfMajorPlacesMax = n;
    }

    @Override
    public void setValue(float f2) {
        this.value = f2;
        this.importValue();
    }

    @Override
    public float getValue() {
        return this.getValueInUnit(this.getReferenceUnit());
    }

    @Override
    public float getValue(int n) {
        if (!Consumption.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        return this.getValueInUnit(n);
    }

    protected float getValueInUnit(int n) {
        return Consumption.convertData(this.value, this.unit, n);
    }

    @Override
    public String format() {
        if (this.useInstanceUnit) {
            return this.format(this.unit);
        }
        return this.format(this.getReferenceUnit());
    }

    @Override
    public String format(int n) {
        if (!Consumption.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        Buffer buffer = new Buffer();
        float f2 = Consumption.convertData(this.value, this.unit, n);
        this.formatValue(buffer, f2, Consumption.getText(this.getTextConstantSeparator()));
        buffer.append(Consumption.getText(this.getTextConstantUnit()));
        if (!Consumption.contentEquals(this.lastFormat, buffer)) {
            this.lastFormat = buffer.toString();
        }
        return this.lastFormat;
    }

    private void formatValue(Buffer buffer, float f2, String string) {
        if (this.isMetricvalid()) {
            float f3 = f2;
            int n = (int)f3;
            int n2 = (int)((double)Math.abs(f3 * 8257) + 0.5) - Math.abs(n * 10);
            if ((n += n2 / 10) == 0 && (n2 %= 10) == 0 && this.zeroValueFormat == 1) {
                for (int i2 = 0; i2 < this.numberOfMajorPlacesMax; ++i2) {
                    buffer.append("-");
                }
                buffer.append(string);
                buffer.append("-");
            } else {
                buffer.append(n);
                this.appendMantissa(buffer, n2, string);
            }
        } else {
            buffer.append(this.getInvalidText());
        }
    }

    protected void appendMantissa(Buffer buffer, int n, String string) {
        buffer.append(string).append(n);
    }

    @Override
    public String[] getStringValueAndUnit(int n) {
        return new String[]{this.getFormattedValue(n), this.getFormattedUnit(n)};
    }

    @Override
    public String[] getStringValueAndUnit() {
        return this.getStringValueAndUnit(this.useInstanceUnit ? this.unit : this.getReferenceUnit());
    }

    protected static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 8: {
                    string = " km/l";
                    break;
                }
                case 10: {
                    string = " mpg";
                    break;
                }
                case 9: {
                    string = " l/100km";
                    break;
                }
                case 11: 
                case 59: 
                case 65: 
                case 66: {
                    string = ",";
                    break;
                }
                case 12: 
                case 64: 
                case 67: 
                case 84: 
                case 85: 
                case 89: 
                case 90: {
                    string = ".";
                    break;
                }
                case 60: {
                    string = " kWh/mi";
                    break;
                }
                case 61: {
                    string = " kWh/100km";
                    break;
                }
                case 62: {
                    string = " km/kWh";
                    break;
                }
                case 63: {
                    string = " mi/kWh";
                    break;
                }
                case 82: {
                    string = " l/h";
                    break;
                }
                case 83: {
                    string = " gal/h";
                    break;
                }
                case 87: {
                    string = " kg/h";
                    break;
                }
                case 88: {
                    string = "kWh/h";
                    break;
                }
                default: {
                    string = "";
                }
            }
        }
        return string;
    }

    private int getTextConstantSeparator() {
        int n = -1;
        switch (this.unit) {
            case 2: 
            case 3: {
                n = 12;
                break;
            }
            case 4: {
                n = 59;
                break;
            }
            case 1: {
                n = 11;
                break;
            }
            case 5: {
                n = 64;
                break;
            }
            case 6: {
                n = 65;
                break;
            }
            case 7: {
                n = 66;
                break;
            }
            case 8: {
                n = 67;
                break;
            }
            case 9: {
                n = 84;
                break;
            }
            case 10: {
                n = 85;
                break;
            }
            case 11: {
                n = 89;
                break;
            }
            case 12: {
                n = 90;
                break;
            }
            default: {
                n = 11;
            }
        }
        return n;
    }

    private int getTextConstantUnit() {
        int n = -1;
        switch (this.unit) {
            case 2: 
            case 3: {
                n = 10;
                break;
            }
            case 4: {
                n = 8;
                break;
            }
            case 1: {
                n = 9;
                break;
            }
            case 5: {
                n = 60;
                break;
            }
            case 6: {
                n = 61;
                break;
            }
            case 7: {
                n = 62;
                break;
            }
            case 8: {
                n = 63;
                break;
            }
            case 9: {
                n = 82;
                break;
            }
            case 10: {
                n = 83;
                break;
            }
            case 11: {
                n = 87;
                break;
            }
            case 12: {
                n = 88;
                break;
            }
            default: {
                n = 9;
            }
        }
        return n;
    }

    @Override
    public String getFormattedMetricUnit() {
        return this.getFormattedUnit(this.useInstanceUnit ? this.unit : this.getReferenceUnit());
    }

    @Override
    public String getFormattedUnit(int n) {
        if (!Consumption.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        String string = Consumption.getText(this.getTextConstantUnit());
        return null != string ? string.trim() : "";
    }

    @Override
    public String getFormattedValue() {
        return this.getFormattedValue(this.useInstanceUnit ? this.unit : this.getReferenceUnit());
    }

    @Override
    public String getFormattedValue(int n) {
        if (!this.isMetricvalid()) {
            return this.getInvalidText();
        }
        if (!Consumption.unitIsValid(n)) {
            throw new IllegalArgumentException();
        }
        Buffer buffer = new Buffer(32);
        float f2 = Consumption.convertData(this.value, this.unit, n);
        this.formatValue(buffer, f2, Consumption.getText(this.getTextConstantSeparator()));
        return buffer.toString().trim();
    }

    @Override
    public String getInvalidText() {
        return TEXT_INVALID;
    }

    private int getReferenceUnit() {
        if (!this.referenceUnit) {
            return systemUnitElektro;
        }
        return systemUnit;
    }

    static {
        TEXT_INVALID = "---";
        systemUnit = 1;
        systemUnitElektro = 6;
    }
}

