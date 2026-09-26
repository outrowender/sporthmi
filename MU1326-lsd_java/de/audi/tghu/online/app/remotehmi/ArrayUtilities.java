/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

public class ArrayUtilities {
    private ArrayUtilities() {
    }

    public static String getSafeArrayValue(String[] stringArray, int n) {
        if (stringArray == null || n < 0 || n >= stringArray.length) {
            return "";
        }
        String string = stringArray[n];
        if (string == null) {
            return "";
        }
        return string;
    }

    public static String getSafeArrayOfArraysValue(String[][] stringArray, int n, int n2) {
        if (stringArray == null || n < 0 || n >= stringArray.length) {
            return "";
        }
        String[] stringArray2 = stringArray[n];
        return ArrayUtilities.getSafeArrayValue(stringArray2, n2);
    }

    public static int getSafeArrayValue(int[] nArray, int n, int n2) {
        if (nArray == null || n >= nArray.length) {
            return n2;
        }
        return nArray[n];
    }

    public static int getSafeArrayValueAsInt(boolean[] blArray, int n) {
        return ArrayUtilities.getSafeArrayValue(blArray, n, false) ? 1 : 0;
    }

    public static boolean getSafeArrayValue(boolean[] blArray, int n, boolean bl) {
        if (blArray == null || n >= blArray.length) {
            return bl;
        }
        return blArray[n];
    }
}

