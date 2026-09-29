/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

public final class StopWatch {
    private boolean isRunning = false;
    private long startTime = 0L;
    private long elapsedTime = 0L;

    public void start() {
        if (!this.isRunning) {
            this.startTime = System.currentTimeMillis();
            this.isRunning = true;
        }
    }

    public void stop() {
        if (this.isRunning) {
            this.elapsedTime += System.currentTimeMillis() - this.startTime;
            this.isRunning = false;
        }
    }

    public void reset() {
        this.elapsedTime = 0L;
        if (this.isRunning) {
            this.startTime = System.currentTimeMillis();
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public long getElapsedTimeMillis() {
        if (this.isRunning) {
            return System.currentTimeMillis() - this.startTime;
        }
        return this.elapsedTime;
    }
}

