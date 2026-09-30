/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

public interface IUGDOSynchronizationHandler {
    public void startSync(int var1);

    public void abortSync(int var1);

    public boolean isSyncRunning();

    public void setInitValueOfRollingCodeState();
}

