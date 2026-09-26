/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ResultReceiver;

public interface ExlapService {
    public static final String SERVICE_NAME;

    default public void addListener(int n, ExlapListener exlapListener) {
    }

    default public void addListener(int[] nArray, ExlapListener exlapListener) {
    }

    default public void removeListener(int n, ExlapListener exlapListener) {
    }

    default public void removeListener(int[] nArray, ExlapListener exlapListener) {
    }

    default public void setResultReceiver(ResultReceiver resultReceiver) {
    }

    default public void init() {
    }
}

