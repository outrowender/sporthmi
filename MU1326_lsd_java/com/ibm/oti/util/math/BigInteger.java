/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util.math;

public class BigInteger {
    public static native long[] addImpl(long[] var0, long[] var1);

    public static native long[] subImpl(long[] var0, long[] var1);

    public static native long[] mulImpl(long[] var0, long[] var1);

    public static native long[] divImpl(long[] var0, long[] var1);

    public static native long[] remImpl(long[] var0, long[] var1);

    public static native long[] negImpl(long[] var0);

    public static native long[] shlImpl(long[] var0, int var1);

    public static native int compImpl(long[] var0, long[] var1);
}

