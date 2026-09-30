/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.util.Arrays;

public final class Sorter {
    public static void sort(Object[] objectArray, Comparator comparator) {
        Arrays.sort(objectArray, comparator);
    }

    public static interface Comparator
    extends java.util.Comparator {
    }
}

