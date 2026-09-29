/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogSink;
import java.util.List;
import java.util.Map;

public interface LogServAdmin {
    default public long getTimeStamp(boolean bl) {
    }

    default public LogSink addLogSink(LogSink logSink) {
    }

    default public void removeLogSink(LogSink logSink) {
    }

    default public List getAllLogSinks() {
    }

    default public void updateChannelConfiguration() {
    }

    default public void updateChannelConfiguration(String string) {
    }

    default public Map getAvailableChannels() {
    }

    default public void log(LogEntry logEntry) {
    }
}

