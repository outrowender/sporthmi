/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

public interface IExlapWorker {
    public void sendUpdates();

    public int getInterval();

    public long getLastExecution();

    public boolean hasNewData();

    public void setNewData(boolean var1);

    public void setLastExecution(long var1);

    public void registerListener();

    public void stop();

    public void enable(int var1);

    public void disable();
}

