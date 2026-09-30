/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public final class Byte
extends Number
implements Comparable {
    private static final long serialVersionUID = -7183698231559129828L;
    final byte value;
    public static final byte MAX_VALUE = 127;
    public static final byte MIN_VALUE = -128;
    public static final Class TYPE = new byte[0].getClass().getComponentType();

    public Byte(byte by) {
        this.value = by;
    }

    public Byte(String string) throws NumberFormatException {
        this(Byte.parseByte(string));
    }

    public byte byteValue() {
        return this.value;
    }

    public int compareTo(Byte by) {
        return this.value > by.value ? 1 : (this.value < by.value ? -1 : 0);
    }

    public int compareTo(Object object) {
        return this.compareTo((Byte)object);
    }

    public static Byte decode(String string) throws NumberFormatException {
        int n = Integer.decode(string);
        byte by = (byte)n;
        if (by == n) {
            return new Byte(by);
        }
        throw new NumberFormatException();
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Byte && this.value == ((Byte)object).value;
    }

    public float floatValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return this.value;
    }

    public static byte parseByte(String string) throws NumberFormatException {
        int n = Integer.parseInt(string);
        byte by = (byte)n;
        if (by == n) {
            return by;
        }
        throw new NumberFormatException();
    }

    public static byte parseByte(String string, int n) throws NumberFormatException {
        int n2 = Integer.parseInt(string, n);
        byte by = (byte)n2;
        if (by == n2) {
            return by;
        }
        throw new NumberFormatException();
    }

    public short shortValue() {
        return this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public static String toString(byte by) {
        return Integer.toString(by);
    }

    public static Byte valueOf(String string) throws NumberFormatException {
        return new Byte(Byte.parseByte(string));
    }

    public static Byte valueOf(String string, int n) throws NumberFormatException {
        return new Byte(Byte.parseByte(string, n));
    }
}

