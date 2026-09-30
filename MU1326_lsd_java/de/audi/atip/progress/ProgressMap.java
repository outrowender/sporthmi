/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.progress;

public interface ProgressMap {
    public void reset();

    public int getTaskCount();

    public int taskCompleted(int var1, boolean var2);

    public String taskIDToString(int var1);
}

