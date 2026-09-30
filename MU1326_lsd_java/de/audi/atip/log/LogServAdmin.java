/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogSink;
import java.util.List;
import java.util.Map;

public interface LogServAdmin {
    public long getTimeStamp(boolean var1);

    public LogSink addLogSink(LogSink var1);

    public void removeLogSink(LogSink var1);

    public List getAllLogSinks();

    public void updateChannelConfiguration();

    public void updateChannelConfiguration(String var1);

    public Map getAvailableChannels();

    public void log(LogEntry var1);
}

