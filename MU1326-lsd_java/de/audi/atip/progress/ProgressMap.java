/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.progress;

public interface ProgressMap {
    default public void reset() {
    }

    default public int getTaskCount() {
    }

    default public int taskCompleted(int n, boolean bl) {
    }

    default public String taskIDToString(int n) {
    }
}

