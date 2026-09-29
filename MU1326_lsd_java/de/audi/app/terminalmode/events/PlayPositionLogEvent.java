/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.atip.log.LogChannel;

public final class PlayPositionLogEvent {
    private final LogChannel logger;
    private final int logLevel;
    private final int maxAmountLogging;
    private volatile int counterLoggingplayPosition;

    public PlayPositionLogEvent(LogChannel logChannel, int n, int n2) {
        this.logger = logChannel;
        this.logLevel = n;
        this.maxAmountLogging = n2;
        this.counterLoggingplayPosition = 0;
    }

    void logUpdatePlayposition(String string) {
        if (this.maxAmountLogging > this.counterLoggingplayPosition) {
            this.logger.log(this.logLevel, "[PlayPositionLogger.updatePlayPosition] %1", (Object)string);
            ++this.counterLoggingplayPosition;
        }
    }

    void resetCounter() {
        this.counterLoggingplayPosition = 0;
    }
}

