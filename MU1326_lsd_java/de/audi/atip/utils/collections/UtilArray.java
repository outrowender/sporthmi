/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.collections;

import de.audi.atip.utils.Preconditions;
import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class UtilArray {
    private UtilArray() {
    }

    public static boolean hasValue(int[] nArray, int n) {
        if (nArray == null) {
            return false;
        }
        Arrays.sort(nArray);
        return Arrays.binarySearch(nArray, n) >= 0;
    }

    public static <T> boolean hasValue(T[] TArray, T t) {
        if (TArray == null) {
            return false;
        }
        Arrays.sort(TArray);
        return Arrays.binarySearch(TArray, t) >= 0;
    }

    public static byte[] getUpdatedArray(byte[] byArray, byte[] byArray2) {
        int n = byArray != null ? byArray.length : 0;
        int n2 = byArray2 != null ? byArray2.length : 0;
        byte[] byArray3 = new byte[Math.max(n, n2)];
        if (n > 0) {
            System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, n);
        }
        if (n2 > n) {
            System.arraycopy((Object)byArray2, n, (Object)byArray3, n, n2 - n);
        }
        return byArray3;
    }

    public static int[] getUpdatedArray(int[] nArray, int[] nArray2) {
        int n = nArray != null ? nArray.length : 0;
        int n2 = nArray2 != null ? nArray2.length : 0;
        int[] nArray3 = new int[Math.max(n, n2)];
        if (n > 0) {
            System.arraycopy((Object)nArray, 0, (Object)nArray3, 0, n);
        }
        if (n2 > n) {
            System.arraycopy((Object)nArray2, n, (Object)nArray3, n, n2 - n);
        }
        return nArray3;
    }

    public static int[] concat(int[] nArray, int[] nArray2) {
        Preconditions.checkNotNull((Object)nArray, "cannot concatenate with null");
        Preconditions.checkNotNull((Object)nArray2, "cannot concatenate with null");
        int[] nArray3 = new int[nArray.length + nArray2.length];
        System.arraycopy((Object)nArray, 0, (Object)nArray3, 0, nArray.length);
        System.arraycopy((Object)nArray2, 0, (Object)nArray3, nArray.length, nArray2.length);
        return nArray3;
    }

    public static <T> T[] concat(T[] TArray, T[] TArray2, Class clazz) {
        Preconditions.checkNotNull(TArray, "cannot concatenate with null");
        Preconditions.checkNotNull(TArray2, "cannot concatenate with null");
        Preconditions.checkNotNull(TArray2, "class of element has to be provided");
        Object[] objectArray = (Object[])Array.newInstance(clazz, TArray.length + TArray2.length);
        System.arraycopy(TArray, 0, (Object)objectArray, 0, TArray.length);
        System.arraycopy(TArray2, 0, (Object)objectArray, TArray.length, TArray2.length);
        return objectArray;
    }

    public static <T> boolean isEmptyOrNull(T[] TArray) {
        return TArray == null || TArray.length == 0;
    }

    public static boolean isEmptyOrNull(int[] nArray) {
        return nArray == null || nArray.length == 0;
    }

    public static int hashCode(int[] nArray) {
        return UtilArray.hashCode(7, nArray);
    }

    public static int hashCode(int n, int[] nArray) {
        if (nArray == null) {
            return 0;
        }
        int n2 = n;
        for (int n3 : nArray) {
            n2 = 3 * n2 + n3;
        }
        return n2;
    }

    public static int hashCode(long[] lArray) {
        return UtilArray.hashCode(7, lArray);
    }

    public static int hashCode(int n, long[] lArray) {
        if (lArray == null) {
            return 0;
        }
        int n2 = n;
        for (long l : lArray) {
            int n3 = (int)(l ^ l >>> 32);
            n2 = 3 * n2 + n3;
        }
        return n2;
    }

    public static int hashCode(short[] sArray) {
        return UtilArray.hashCode(7, sArray);
    }

    public static int hashCode(int n, short[] sArray) {
        if (sArray == null) {
            return 0;
        }
        int n2 = n;
        for (short s : sArray) {
            n2 = 3 * n2 + s;
        }
        return n2;
    }

    public static int hashCode(char[] cArray) {
        return UtilArray.hashCode(7, cArray);
    }

    public static int hashCode(int n, char[] cArray) {
        if (cArray == null) {
            return 0;
        }
        int n2 = n;
        for (char c2 : cArray) {
            n2 = 3 * n2 + c2;
        }
        return n2;
    }

    public static int hashCode(byte[] byArray) {
        return UtilArray.hashCode(7, byArray);
    }

    public static int hashCode(int n, byte[] byArray) {
        if (byArray == null) {
            return 0;
        }
        int n2 = n;
        for (byte by : byArray) {
            n2 = 3 * n2 + by;
        }
        return n2;
    }

    public static int hashCode(boolean[] blArray) {
        return UtilArray.hashCode(7, blArray);
    }

    public static int hashCode(int n, boolean[] blArray) {
        if (blArray == null) {
            return 0;
        }
        int n2 = n;
        for (boolean bl : blArray) {
            n2 = 3 * n2 + (bl ? 1231 : 1237);
        }
        return n2;
    }

    public static int hashCode(float[] fArray) {
        return UtilArray.hashCode(7, fArray);
    }

    public static int hashCode(int n, float[] fArray) {
        if (fArray == null) {
            return 0;
        }
        int n2 = n;
        for (float f2 : fArray) {
            n2 = 3 * n2 + Float.floatToIntBits(f2);
        }
        return n2;
    }

    public static int hashCode(double[] dArray) {
        return UtilArray.hashCode(7, dArray);
    }

    public static int hashCode(int n, double[] dArray) {
        if (dArray == null) {
            return 0;
        }
        int n2 = n;
        for (double d2 : dArray) {
            long l = Double.doubleToLongBits(d2);
            int n3 = (int)(l ^ l >>> 32);
            n2 = 3 * n2 + n3;
        }
        return n2;
    }

    public static int hashCode(Object[] objectArray) {
        return UtilArray.hashCode(7, objectArray);
    }

    public static int hashCode(int n, Object[] objectArray) {
        if (objectArray == null) {
            return 0;
        }
        int n2 = n;
        for (Object object : objectArray) {
            n2 = 31 * n2 + (object == null ? 0 : object.hashCode());
        }
        return n2;
    }
}

