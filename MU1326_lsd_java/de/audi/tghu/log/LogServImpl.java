/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogServAdmin;
import de.audi.atip.log.LogSink;
import de.audi.atip.log.NullLogChannel;
import de.audi.tghu.log.LogChannelImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class LogServImpl
implements LogChannelFactory,
LogServAdmin {
    private static final int[] logLevelValues = new int[]{0, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    static int defaultLevel = 10000;
    private static final boolean DEBUG_DEV = false;
    private final IFrameworkAccess framework;
    private final Map allChannels;
    private final List allLogSinks;
    private LogChannel lc;

    LogServImpl(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.lc = NullLogChannel.getInstance();
        this.allChannels = new HashMap(400);
        this.allLogSinks = new ArrayList(5);
        this.lc = this.getLogChannel("Fw.Log.Main");
    }

    public long getTimeStamp(boolean bl) {
        return bl ? this.framework.getKombiTime() : this.framework.getMonotonicTime();
    }

    public synchronized Map getAvailableChannels() {
        return new HashMap(this.allChannels);
    }

    public synchronized List getAllLogSinks() {
        return new ArrayList(this.allLogSinks);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public LogChannel getLogChannel(String string) {
        LogChannelImpl logChannelImpl;
        if (string == null || string.equals("")) {
            return null;
        }
        LogServImpl logServImpl = this;
        synchronized (logServImpl) {
            logChannelImpl = (LogChannelImpl)this.allChannels.get(string);
        }
        if (logChannelImpl != null) {
            this.lc.log(10000000, "LogChannel: %1 already exists, returning INSTANCE.", (Object)string);
        } else {
            logChannelImpl = new LogChannelImpl(this, false);
            logChannelImpl.name = string;
            logChannelImpl.setLogThreshold(defaultLevel);
            logServImpl = this;
            synchronized (logServImpl) {
                this.allChannels.put(string, logChannelImpl);
                this.updateChannelConfiguration(logChannelImpl);
            }
            this.lc.log(10000000, "LogChannel: %1 created.", (Object)string);
        }
        return logChannelImpl;
    }

    public void log(LogEntry logEntry) {
        String string = logEntry.getChannelName();
        if (string != null) {
            int n = this.allLogSinks.size();
            for (int i2 = 0; i2 < n; ++i2) {
                LogSink logSink;
                try {
                    logSink = (LogSink)this.allLogSinks.get(i2);
                    if (logEntry.getLevel() > logSink.getLogThreshold(string)) continue;
                    logSink.writeLog(logEntry);
                    continue;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    logSink = null;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public LogSink addLogSink(LogSink logSink) {
        LogServImpl logServImpl = this;
        synchronized (logServImpl) {
            if (!this.allLogSinks.contains(logSink)) {
                this.allLogSinks.add(logSink);
            }
            this.updateChannelConfiguration(logSink);
        }
        logSink.registerServices(this);
        this.lc.log(10000000, "[LogServImpl#addLogSink] LogSink %1 detected and added.", (Object)logSink);
        return logSink;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeLogSink(LogSink logSink) {
        logSink.registerServices(null);
        LogServImpl logServImpl = this;
        synchronized (logServImpl) {
            this.allLogSinks.remove(logSink);
            this.updateChannelConfiguration();
        }
        this.lc.log(1000000, "LogSink %1 removed.", (Object)logSink);
    }

    private void setLogThreshold(LogChannelImpl logChannelImpl, int n) {
        logChannelImpl.setLogThreshold(n);
    }

    private void updateChannelConfiguration(LogChannelImpl logChannelImpl, LogSink logSink) {
        int n = logSink.getLogThreshold(logChannelImpl.name);
        if (n > logChannelImpl.getCurrentLogThreshold()) {
            this.setLogThreshold(logChannelImpl, n);
        }
    }

    private void updateChannelConfiguration(LogChannelImpl logChannelImpl) {
        this.setLogThreshold(logChannelImpl, defaultLevel);
        int n = this.allLogSinks.size();
        for (int i2 = 0; i2 < n; ++i2) {
            this.updateChannelConfiguration(logChannelImpl, (LogSink)this.allLogSinks.get(i2));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateChannelConfiguration() {
        LogServImpl logServImpl = this;
        synchronized (logServImpl) {
            Iterator iterator = this.allChannels.values().iterator();
            while (iterator.hasNext()) {
                this.updateChannelConfiguration((LogChannelImpl)iterator.next());
            }
        }
    }

    public void updateChannelConfiguration(String string) {
        LogChannelImpl logChannelImpl = (LogChannelImpl)this.getLogChannel(string);
        if (logChannelImpl != null) {
            this.updateChannelConfiguration(logChannelImpl);
        }
    }

    private void updateChannelConfiguration(LogSink logSink) {
        if (logSink.getConfiguration() == null || logSink.getConfiguration().isEmpty()) {
            return;
        }
        Iterator iterator = this.allChannels.values().iterator();
        while (iterator.hasNext()) {
            this.updateChannelConfiguration((LogChannelImpl)iterator.next(), logSink);
        }
    }

    public static Map decodeLogConfig(String string) {
        HashMap hashMap = new HashMap();
        if (string != null) {
            int n = 0;
            boolean bl = true;
            int n2 = 0;
            try {
                while (bl) {
                    int n3 = string.indexOf(61, n2);
                    if (n3 == -1) {
                        bl = false;
                        break;
                    }
                    int n4 = string.indexOf(44, n3);
                    String string2 = string.substring(n2, n3);
                    if (n4 != -1) {
                        n = Integer.parseInt(string.substring(n3 + 1, n4));
                    } else {
                        n = Integer.parseInt(string.substring(n3 + 1));
                        bl = false;
                    }
                    if (n >= 0 && n < logLevelValues.length) {
                        n = logLevelValues[n];
                    }
                    hashMap.put(string2, new Integer(n));
                    n2 = n4 + 1;
                    n4 = 0;
                }
            }
            catch (NumberFormatException numberFormatException) {
                System.out.println("LogSink configuration failure!");
            }
        }
        return hashMap;
    }
}

