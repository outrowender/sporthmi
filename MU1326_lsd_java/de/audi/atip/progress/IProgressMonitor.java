/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.progress;

public interface IProgressMonitor {
    default public void start() {
    }

    default public void stop() {
    }

    default public void taskCompleted(int n, boolean bl) {
    }
}

