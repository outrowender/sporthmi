/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

public final class Array {
    private Array() {
    }

    public static native Object get(Object var0, int var1);

    public static native boolean getBoolean(Object var0, int var1);

    public static native byte getByte(Object var0, int var1);

    public static native char getChar(Object var0, int var1);

    public static native double getDouble(Object var0, int var1);

    public static native float getFloat(Object var0, int var1);

    public static native int getInt(Object var0, int var1);

    public static native int getLength(Object var0);

    public static native long getLong(Object var0, int var1);

    public static native short getShort(Object var0, int var1);

    private static native Object multiNewArrayImpl(Class var0, int var1, int[] var2);

    private static native Object newArrayImpl(Class var0, int var1);

    public static Object newInstance(Class clazz, int[] nArray) throws NegativeArraySizeException, IllegalArgumentException {
        if (clazz == null) {
            throw new NullPointerException();
        }
        int n = nArray.length;
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int[] nArray2 = new int[n];
        int n2 = 0;
        while (n2 < n) {
            if (nArray[n2] < 0) {
                throw new NegativeArraySizeException();
            }
            nArray2[n - n2 - 1] = nArray[n2];
            ++n2;
        }
        return Array.multiNewArrayImpl(clazz, n, nArray2);
    }

    public static Object newInstance(Class clazz, int n) throws NegativeArraySizeException {
        if (clazz == null) {
            throw new NullPointerException();
        }
        if (n < 0) {
            throw new NegativeArraySizeException();
        }
        return Array.newArrayImpl(clazz, n);
    }

    public static native void set(Object var0, int var1, Object var2);

    public static native void setBoolean(Object var0, int var1, boolean var2);

    public static native void setByte(Object var0, int var1, byte var2);

    public static native void setChar(Object var0, int var1, char var2);

    public static native void setDouble(Object var0, int var1, double var2);

    public static native void setFloat(Object var0, int var1, float var2);

    public static native void setInt(Object var0, int var1, int var2);

    public static native void setLong(Object var0, int var1, long var2);

    public static native void setShort(Object var0, int var1, short var2);
}

