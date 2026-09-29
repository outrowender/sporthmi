/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogServAdmin;
import java.util.Map;

public interface LogSink {
    default public void registerServices(LogServAdmin logServAdmin) {
    }

    default public Map getAvailableChannel() {
    }

    default public void setConfiguration(Map map) {
    }

    default public void updateConfiguration(Map map, String string) {
    }

    default public Map getConfiguration() {
    }

    default public int getLogThreshold(String string) {
    }

    default public void writeLog(LogEntry logEntry) {
    }
}

