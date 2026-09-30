/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.storage;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageStatistic;
import de.audi.atip.storage.NoSuchDataException;
import de.audi.atip.storage.ProviderFailedException;
import de.audi.tghu.storage.FlushValuesDict;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

final class StorageStatistic
implements IStorageStatistic,
DumpInfoProvider {
    private final LogChannel chan;
    private final LogChannel chanExtStartup;
    private long time2Wait4DSI;
    private Buffer providerFailedExceptions;
    private IFrameworkAccess fw;

    StorageStatistic(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.chan = iFrameworkAccess.getLogChannel("Fw.Storage.Statistic");
        this.chanExtStartup = iFrameworkAccess.getLogChannel("Ext.Startup");
    }

    protected boolean isEnabled() {
        return this.chan.isDebug();
    }

    protected void readStart(int n, int n2) {
        this.chan.log(10000000, "Start read # Namespace=%1, Key=%2", (long)n, (long)n2);
    }

    protected void readOK(int n, int n2, String string) {
        this.chan.log(10000000, "Read result: [OK] # Namespace=%2, Key=%3 # Value=%1", (Object)string, (long)n, (long)n2);
    }

    protected void readError(NoSuchDataException noSuchDataException, String string) {
        this.chan.log(10000000, "Read result: [ERROR] # %1 # Use default=%2", (Object)noSuchDataException, (Object)string);
        if (noSuchDataException instanceof ProviderFailedException) {
            this.chan.log(10000, "Read result: [ERROR] # %1 # Use default=%2", (Object)noSuchDataException, (Object)string);
            if (this.providerFailedExceptions == null) {
                this.providerFailedExceptions = new Buffer();
                this.providerFailedExceptions.append("ProviderFailedExceptions:").append('\n').append('\n');
            }
            this.providerFailedExceptions.append('[').append(this.fw.getMonotonicTime()).append(']').append(' ').append(noSuchDataException).append('\n');
        }
    }

    protected void writeStart(int n, int n2, String string) {
        this.chan.log(10000000, "Start write # Namespace=%2, Key=%3 # Value=%1", (Object)string, (long)n, (long)n2);
    }

    protected void writeOK(int n, long l) {
        this.chan.log(10000000, "Write result: [OK] # Namespace=%1, Key=%2", (long)n, l);
    }

    protected void writeError(NoSuchDataException noSuchDataException) {
        this.chan.log(10000, "Write result: [ERROR] # %1", (Object)noSuchDataException.getMessage());
    }

    protected void writeWarning(NoSuchDataException noSuchDataException) {
        this.chan.log(100000, "Write result: [WARNING] # %1", (Throwable)noSuchDataException);
    }

    protected void flush(int n, int n2) {
        this.chan.log(10000000, "flush(namespace=%1, key=%2)", (long)n, (long)n2);
    }

    protected void flush() {
        this.chan.log(10000000, "flush()");
    }

    void addLongRunningRead(int n, int n2, long l, long l2) {
        Buffer buffer = new Buffer();
        buffer.append("started: ").append(l).append(" done: ").append(l2).append(" needed: ").append(l2 - l).append(" namespace = ").append(n).append(", key = ").append(n2);
        this.chanExtStartup.log(100000, "Slow storage read: %1", (Object)buffer);
    }

    public void dump(PrintStream printStream, String string) {
        int n;
        Buffer buffer = new Buffer(500);
        buffer.append("Time2Wait4DSI: ").append(this.time2Wait4DSI).append('\n').append('\n');
        if (this.providerFailedExceptions != null) {
            buffer.append(this.providerFailedExceptions).append('\n').append('\n');
        }
        buffer.append("[namespace/key_prefix]  [flush_counter]").append(Formatter.LINE_SEPARATOR);
        for (n = 0; n < FlushValuesDict.values.length; ++n) {
            buffer.append("    ").append(FlushValuesDict.values[n][0]).append('/');
            buffer.append(FlushValuesDict.values[n][1]).append("                    ");
            buffer.append(FlushValuesDict.values[n][2]).append(Formatter.LINE_SEPARATOR);
        }
        for (n = 0; n < FlushValuesDict.valuesSetup.length; ++n) {
            buffer.append("    ").append(FlushValuesDict.valuesSetup[n][0]).append('/');
            buffer.append(FlushValuesDict.valuesSetup[n][1]).append("                    ");
            buffer.append(FlushValuesDict.valuesSetup[n][2]).append(Formatter.LINE_SEPARATOR);
        }
        printStream.print(buffer);
    }

    public String getName() {
        return "storage_statistic";
    }

    public void setTime2Wait4DSI(long l) {
        this.time2Wait4DSI = l;
    }
}

