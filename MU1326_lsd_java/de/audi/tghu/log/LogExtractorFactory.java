/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.log.LogExtractorFactory$ByteArrayData;
import java.io.PrintStream;

public final class LogExtractorFactory {
    private LogExtractorFactory$ByteArrayData criticalData;
    private LogExtractorFactory$ByteArrayData errorData;
    private LogExtractorFactory$ByteArrayData warningData;
    private LogExtractorFactory$ByteArrayData infoData;
    private LogExtractorFactory$ByteArrayData debugData;
    private LogExtractorFactory$ByteArrayData debug2Data;
    private static final LogExtractorFactory INSTANCE = new LogExtractorFactory();
    private IFrameworkAccess framework = null;
    private long[] started = new long[]{0L, 0L, 0L, 0L, 0L, 0L};
    private long[] done = new long[]{0L, 0L, 0L, 0L, 0L, 0L};

    public static final LogExtractorFactory getInstance() {
        return INSTANCE;
    }

    private LogExtractorFactory() {
    }

    public void initFramework(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
    }

    private long getMonotonicTime() {
        if (this.framework != null) {
            return this.framework.getMonotonicTime();
        }
        return System.currentTimeMillis();
    }

    public String getMsg(int n, int n2) {
        String string = null;
        switch (n2) {
            case 1000: {
                if (this.criticalData == null) {
                    this.started[0] = this.getMonotonicTime();
                    this.criticalData = new LogExtractorFactory$ByteArrayData(this, "log_msg_critical.dat");
                    this.done[0] = this.getMonotonicTime();
                }
                string = this.criticalData.getString(n);
                break;
            }
            case 10000: {
                if (this.errorData == null) {
                    this.started[1] = this.getMonotonicTime();
                    this.errorData = new LogExtractorFactory$ByteArrayData(this, "log_msg_error.dat");
                    this.done[1] = this.getMonotonicTime();
                }
                string = this.errorData.getString(n);
                break;
            }
            case 100000: {
                if (this.warningData == null) {
                    this.started[2] = this.getMonotonicTime();
                    this.warningData = new LogExtractorFactory$ByteArrayData(this, "log_msg_warning.dat");
                    this.done[2] = this.getMonotonicTime();
                }
                string = this.warningData.getString(n);
                break;
            }
            case 1000000: {
                if (this.infoData == null) {
                    this.started[3] = this.getMonotonicTime();
                    this.infoData = new LogExtractorFactory$ByteArrayData(this, "log_msg_info.dat");
                    this.done[3] = this.getMonotonicTime();
                }
                string = this.infoData.getString(n);
                break;
            }
            case 10000000: {
                if (this.debugData == null) {
                    this.started[4] = this.getMonotonicTime();
                    this.debugData = new LogExtractorFactory$ByteArrayData(this, "log_msg_debug.dat");
                    this.done[4] = this.getMonotonicTime();
                }
                string = this.debugData.getString(n);
                break;
            }
            case 100000000: {
                if (this.debug2Data == null) {
                    this.started[5] = this.getMonotonicTime();
                    this.debug2Data = new LogExtractorFactory$ByteArrayData(this, "log_msg_debug2.dat");
                    this.done[5] = this.getMonotonicTime();
                }
                string = this.debug2Data.getString(n);
                break;
            }
            default: {
                string = "UNDEF";
            }
        }
        return string;
    }

    public void dumpLoadInfo(PrintStream printStream, String string, int n) {
        printStream.println(new StringBuffer().append(string).append(" from ").append(this.started[n]).append(" to ").append(this.done[n]).append(" needed ").append(this.done[n] - this.started[n]).toString());
    }

    public void dumpInfo(PrintStream printStream) {
        printStream.println("== Time consumed to read externalized log files ==");
        this.dumpLoadInfo(printStream, "log_msg_critical.dat", 0);
        this.dumpLoadInfo(printStream, "log_msg_error.dat", 1);
        this.dumpLoadInfo(printStream, "log_msg_warning.dat", 2);
        this.dumpLoadInfo(printStream, "log_msg_info.dat", 3);
        this.dumpLoadInfo(printStream, "log_msg_debug.dat", 4);
        this.dumpLoadInfo(printStream, "log_msg_debug2.dat", 5);
        printStream.println("==================================================\n");
    }

    private final ClassLoader getResourceClassLoader() {
        return super.getClass().getClassLoader() != null ? super.getClass().getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    static /* synthetic */ ClassLoader access$000(LogExtractorFactory logExtractorFactory) {
        return logExtractorFactory.getResourceClassLoader();
    }
}

