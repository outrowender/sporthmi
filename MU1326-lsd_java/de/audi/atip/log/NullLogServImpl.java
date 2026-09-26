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

    @Override
    public Map getAvailableChannels() {
        return new HashMap();
    }

    @Override
    public LogChannel getLogChannel(String string) {
        return NullLogChannel.getInstance();
    }

    @Override
    public void updateChannelConfiguration() {
    }

    @Override
    public void updateChannelConfiguration(String string) {
    }

    public synchronized void deinit() {
    }

    @Override
    public LogSink addLogSink(LogSink logSink) {
        return logSink;
    }

    @Override
    public void removeLogSink(LogSink logSink) {
    }

    @Override
    public List getAllLogSinks() {
        return new ArrayList(10);
    }

    @Override
    public void log(LogEntry logEntry) {
    }

    public void updateChannelConfiguration(LogSink logSink) {
    }

    public void initDebugSPIConfig() {
    }

    @Override
    public long getTimeStamp(boolean bl) {
        return 0L;
    }
}

