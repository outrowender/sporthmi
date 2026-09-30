/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogServAdmin;
import java.util.Map;

public interface LogSink {
    public void registerServices(LogServAdmin var1);

    public Map getAvailableChannel();

    public void setConfiguration(Map var1);

    public void updateConfiguration(Map var1, String var2);

    public Map getConfiguration();

    public int getLogThreshold(String var1);

    public void writeLog(LogEntry var1);
}

