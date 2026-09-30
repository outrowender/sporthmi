/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.progress;

public interface IProgressMonitor {
    public void start();

    public void stop();

    public void taskCompleted(int var1, boolean var2);
}

