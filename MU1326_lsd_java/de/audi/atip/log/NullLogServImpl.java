/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogServAdmin;
import de.audi.atip.log.LogSink;
import de.audi.atip.log.NullLogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NullLogServImpl
implements LogChannelFactory,
LogServAdmin {
    private static NullLogServImpl instance = new NullLogServImpl();

    public static NullLogServImpl getInstance() {
        return instance;
    }

    private NullLogServImpl() {
    }

    public long getTimeStamp() {
        return 0L;
    }

    public Map getAvailableChannels() {
        return new HashMap();
    }

    public LogChannel getLogChannel(String string) {
        return NullLogChannel.getInstance();
    }

    public void updateChannelConfiguration() {
    }

    public void updateChannelConfiguration(String string) {
    }

    public synchronized void deinit() {
    }

    public LogSink addLogSink(LogSink logSink) {
        return logSink;
    }

    public void removeLogSink(LogSink logSink) {
    }

    public List getAllLogSinks() {
        return new ArrayList(10);
    }

    public void log(LogEntry logEntry) {
    }

    public void updateChannelConfiguration(LogSink logSink) {
    }

    public void initDebugSPIConfig() {
    }

    public long getTimeStamp(boolean bl) {
        return 0L;
    }
}

