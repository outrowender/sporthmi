/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

public interface IExlapWorker {
    default public void sendUpdates() {
    }

    default public int getInterval() {
    }

    default public long getLastExecution() {
    }

    default public boolean hasNewData() {
    }

    default public void setNewData(boolean bl) {
    }

    default public void setLastExecution(long l) {
    }

    default public void registerListener() {
    }

    default public void stop() {
    }

    default public void enable(int n) {
    }

    default public void disable() {
    }
}

