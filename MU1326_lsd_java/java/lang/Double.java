/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.FloatingPointParser;
import com.ibm.oti.util.NumberConverter;

public final class Double
extends Number
implements Comparable {
    private static final long serialVersionUID = -9172774392245257468L;
    final double value;
    public static final double MAX_VALUE = 1.7976931348623157E308;
    public static final double MIN_VALUE = 2.121995791E-314;
    public static final double NaN = 0.0 / 0.0;
    public static final double POSITIVE_INFINITY = 1.0 / 0.0;
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
    public static final Class TYPE = new double[0].getClass().getComponentType();

    public Double(double d2) {
        this.value = d2;
    }

    public Double(String string) throws NumberFormatException {
        this(Double.parseDouble(string));
    }

    public int compareTo(Double d2) {
        long l = Double.doubleToLongBits(Double.NaN);
        long l2 = Double.doubleToLongBits(this.value);
        if (l2 == l) {
            if (Double.doubleToLongBits(d2.value) == l) {
                return 0;
            }
            return 1;
        }
        long l3 = Double.doubleToLongBits(d2.value);
        if (l3 == l) {
            return -1;
        }
        if (this.value == d2.value) {
            if (l2 == l3) {
                return 0;
            }
            return l2 > l3 ? 1 : -1;
        }
        return this.value > d2.value ? 1 : -1;
    }

    public int compareTo(Object object) {
        return this.compareTo((Double)object);
    }

    public byte byteValue() {
        return (byte)this.value;
    }

    public static native long doubleToLongBits(double var0);

    public static native long doubleToRawLongBits(double var0);

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Double && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((Double)object).value);
    }

    public float floatValue() {
        return (float)this.value;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.value);
        return (int)(l ^ l >>> 32);
    }

    public int intValue() {
        return (int)this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public static boolean isInfinite(double d2) {
        return d2 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY;
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    public static boolean isNaN(double d2) {
        return d2 != d2;
    }

    public static native double longBitsToDouble(long var0);

    public long longValue() {
        return (long)this.value;
    }

    public static double parseDouble(String string) throws NumberFormatException {
        return FloatingPointParser.parseDouble(string);
    }

    public short shortValue() {
        return (short)this.value;
    }

    public String toString() {
        return Double.toString(this.value);
    }

    public static String toString(double d2) {
        return NumberConverter.convert(d2);
    }

    public static Double valueOf(String string) throws NumberFormatException {
        return new Double(Double.parseDouble(string));
    }

    public static int compare(double d2, double d3) {
        long l = Double.doubleToLongBits(Double.NaN);
        long l2 = Double.doubleToLongBits(d2);
        if (l2 == l) {
            if (Double.doubleToLongBits(d3) == l) {
                return 0;
            }
            return 1;
        }
        long l3 = Double.doubleToLongBits(d3);
        if (l3 == l) {
            return -1;
        }
        if (d2 == d3) {
            if (l2 == l3) {
                return 0;
            }
            return l2 > l3 ? 1 : -1;
        }
        return d2 > d3 ? 1 : -1;
    }
}

