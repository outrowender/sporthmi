/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.anim;

public class AnimUtils {
    public static final String NULL_PREFIX;
    public static final String NO_VALUE_TO_STRING_MAPPING;

    public static String valueToString(int n, String[] stringArray) {
        return new StringBuffer().append(n >= 0 && stringArray != null && n < stringArray.length ? stringArray[n] : "NO_VALUE_TO_STRING_MAPPING").append(" ( ").append(n).append(" )").toString();
    }

    public static float clamp(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f4), f3);
    }

    public static int clamp(int n, int n2, int n3) {
        return Math.min(Math.max(n, n3), n2);
    }

    public static float norm1(float f2, float f3, float f4) {
        float f5 = 1.0f;
        if (f2 != f3) {
            float f6 = Math.min(f2, f3);
            float f7 = Math.max(f2, f3);
            f5 = (f4 - f6) / (f7 - f6);
        }
        return f5;
    }

    public static float getNormalizedProgress(float f2, float f3, float f4) {
        float f5 = 1.0f;
        if (f2 != f3) {
            float f6 = Math.min(f2, f3);
            float f7 = Math.max(f2, f3);
            f5 = (f2 != f6 ? f7 - f4 : f4 - f6) / (f7 - f6);
        }
        return f5;
    }

    public static float lerp1(float f2, float f3, float f4) {
        float f5 = f2;
        float f6 = Math.min(f2, f3);
        float f7 = Math.max(f2, f3);
        float f8 = f7 - f6;
        float f9 = AnimUtils.clamp(0.0f, 1.0f, f4);
        f9 = f6 != f2 ? 1.0f - f9 : f9;
        f5 = f6 + f8 * f9;
        return f5;
    }

    public static boolean isValueInBounds(float f2, float f3, float f4) {
        return f4 >= Math.min(f2, f3) && f4 <= Math.max(f2, f3);
    }

    public static float idxMinMax(int n, float f2, float f3) {
        switch (n) {
            case 0: {
                return Math.min(f2, f3);
            }
            case 1: {
                return Math.max(f2, f3);
            }
        }
        return 0.0f;
    }

    public static float idxMaxMin(int n, float f2, float f3) {
        switch (n) {
            case 0: {
                return Math.max(f2, f3);
            }
            case 1: {
                return Math.min(f2, f3);
            }
        }
        return 0.0f;
    }
}

