/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.audi.atip.utils.UtilText;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Preconditions {
    public static void checkArgument(boolean bl, Object object) {
        if (!bl) {
            throw new IllegalArgumentException(String.valueOf(object));
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static <T> T checkNotNull(T t, Object object) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(object));
        }
        return t;
    }

    public static void checkNotNull(Object object, Object[] objectArray) {
        if (object == null) {
            Preconditions.throwNullPointerException(objectArray);
        }
    }

    public static void checkNotNull(Object object, String string) {
        if (object == null) {
            throw new NullPointerException(string);
        }
    }

    public static <T> void checkNotContainsNulls(T[] TArray) {
        Preconditions.checkNotContainsNulls(TArray, null);
    }

    public static <T> void checkNotContainsNulls(T[] TArray, Object[] objectArray) {
        Preconditions.checkNotNull(TArray, objectArray);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            if (TArray[i2] != null) continue;
            Preconditions.throwNullPointerException(objectArray);
        }
    }

    public static void checkNotNullOrEmpty(byte[] byArray, Object[] objectArray) {
        if (byArray == null || byArray.length == 0) {
            Preconditions.throwNullPointerException(objectArray);
        }
    }

    public static void checkNotNullOrEmpty(int[] nArray, Object[] objectArray) {
        if (nArray == null || nArray.length == 0) {
            Preconditions.throwNullPointerException(objectArray);
        }
    }

    private static void throwNullPointerException(Object[] objectArray) {
        if (objectArray.length == 0) {
            throw new NullPointerException();
        }
        throw new NullPointerException(UtilText.buildString(objectArray));
    }

    public static <T> void checkNotNullOrEmpty(T[] TArray, Object[] objectArray) {
        if (TArray == null || TArray.length == 0) {
            Preconditions.throwNullPointerException(objectArray);
        }
    }

    public static void checkNotNullOrEmpty(String string) {
        if (UtilText.isEmpty(string)) {
            Preconditions.throwNullPointerException(new Object[0]);
        }
    }

    public static void checkNotNullOrEmpty(String string, Object[] objectArray) {
        if (UtilText.isEmpty(string)) {
            Preconditions.throwNullPointerException(objectArray);
        }
    }

    public static void checkArgument(boolean bl) {
        if (!bl) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkArgumentNotNull(T t, String string) {
        if (t == null) {
            throw new IllegalArgumentException(UtilText.buildString(new String[]{string, " must not be null!"}));
        }
        return t;
    }

    public static void checkArgument(boolean bl, Object[] objectArray) {
        if (!bl) {
            if (objectArray.length == 0) {
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException(UtilText.buildString(objectArray));
        }
    }

    public static void checkRange(long l, long l2, long l3) {
        Preconditions.checkRange(l, l2, l3, new Object[]{"value ", new Long(l), " is not in a range of <", new Long(l2), ",", new Long(l3), ">"});
    }

    public static void checkRange(long l, long l2, long l3, String string) {
        Preconditions.checkRange(l, l2, l3, new Object[]{string, ": ", new Long(l), " is not in a range of <", new Long(l2), ",", new Long(l3), ">"});
    }

    public static void checkRange(long l, long l2, long l3, Object[] objectArray) {
        if (l < l2 || l > l3) {
            throw new IllegalArgumentException(UtilText.buildString(objectArray));
        }
    }

    public static void checkState(boolean bl, Object[] objectArray) {
        if (!bl) {
            Preconditions.throwIllegalStateException(objectArray);
        }
    }

    public static void checkState(boolean bl) {
        if (!bl) {
            Preconditions.throwIllegalStateException(new Object[0]);
        }
    }

    private static void throwIllegalStateException(Object[] objectArray) {
        if (objectArray.length == 0) {
            throw new IllegalStateException();
        }
        throw new IllegalStateException(UtilText.buildString(objectArray));
    }
}

