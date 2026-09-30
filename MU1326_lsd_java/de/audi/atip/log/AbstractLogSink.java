/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogServAdmin;
import de.audi.atip.log.LogSink;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLogSink
implements LogSink {
    private static final int DEFAULT_LEVEL = 0;
    private Map config = new HashMap();
    private LogServAdmin owner;

    public String toString() {
        return this.getClass().getName();
    }

    public final void registerServices(LogServAdmin logServAdmin) {
        this.owner = logServAdmin;
    }

    public Map getAvailableChannel() {
        if (this.owner != null) {
            return this.owner.getAvailableChannels();
        }
        return null;
    }

    public void setConfiguration(Map map) {
        if (map == null) {
            throw new IllegalArgumentException();
        }
        this.config = map;
        if (this.owner != null) {
            this.owner.updateChannelConfiguration();
        }
    }

    public void updateConfiguration(Map map, String string) {
        if (map == null) {
            throw new IllegalArgumentException();
        }
        this.config = map;
        if (this.owner != null) {
            this.owner.updateChannelConfiguration(string);
        }
    }

    public Map getConfiguration() {
        return this.config;
    }

    public int getLogThreshold(String string) {
        Object object = this.getConfiguration().get(string);
        if (object == null) {
            object = this.getConfiguration().get("all");
        }
        return object != null ? (Integer)object : 0;
    }

    public abstract void writeLog(LogEntry var1);
}

