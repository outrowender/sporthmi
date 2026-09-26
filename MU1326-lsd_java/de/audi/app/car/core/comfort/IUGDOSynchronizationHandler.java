/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

public interface IUGDOSynchronizationHandler {
    default public void startSync(int n) {
    }

    default public void abortSync(int n) {
    }

    default public boolean isSyncRunning() {
    }

    default public void setInitValueOfRollingCodeState() {
    }
}

