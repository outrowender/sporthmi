/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.base.IFrameworkAccess;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public final class LogExtractorFactory {
    private ByteArrayData criticalData;
    private ByteArrayData errorData;
    private ByteArrayData warningData;
    private ByteArrayData infoData;
    private ByteArrayData debugData;
    private ByteArrayData debug2Data;
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
                    this.criticalData = new ByteArrayData("log_msg_critical.dat");
                    this.done[0] = this.getMonotonicTime();
                }
                string = this.criticalData.getString(n);
                break;
            }
            case 10000: {
                if (this.errorData == null) {
                    this.started[1] = this.getMonotonicTime();
                    this.errorData = new ByteArrayData("log_msg_error.dat");
                    this.done[1] = this.getMonotonicTime();
                }
                string = this.errorData.getString(n);
                break;
            }
            case 100000: {
                if (this.warningData == null) {
                    this.started[2] = this.getMonotonicTime();
                    this.warningData = new ByteArrayData("log_msg_warning.dat");
                    this.done[2] = this.getMonotonicTime();
                }
                string = this.warningData.getString(n);
                break;
            }
            case 1000000: {
                if (this.infoData == null) {
                    this.started[3] = this.getMonotonicTime();
                    this.infoData = new ByteArrayData("log_msg_info.dat");
                    this.done[3] = this.getMonotonicTime();
                }
                string = this.infoData.getString(n);
                break;
            }
            case 10000000: {
                if (this.debugData == null) {
                    this.started[4] = this.getMonotonicTime();
                    this.debugData = new ByteArrayData("log_msg_debug.dat");
                    this.done[4] = this.getMonotonicTime();
                }
                string = this.debugData.getString(n);
                break;
            }
            case 100000000: {
                if (this.debug2Data == null) {
                    this.started[5] = this.getMonotonicTime();
                    this.debug2Data = new ByteArrayData("log_msg_debug2.dat");
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
        return this.getClass().getClassLoader() != null ? this.getClass().getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    private class ByteArrayData {
        private String charset = "UTF-8";
        private int nrStrings;
        private int[] offset;
        private byte[] data;

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public ByteArrayData(String string) {
            InputStream inputStream = null;
            FilterInputStream filterInputStream = null;
            try {
                inputStream = LogExtractorFactory.this.getResourceClassLoader().getResourceAsStream(string);
                if (inputStream == null) {
                    System.err.println(new StringBuffer().append("[ERROR] cannot open file: ").append(string).toString());
                    System.err.println("[ERROR] ext_log.zip is not in the CLASSPATH!!!");
                    return;
                }
                filterInputStream = new DataInputStream(new BufferedInputStream(inputStream, 40960));
                this.nrStrings = ((DataInputStream)filterInputStream).readInt();
                if (this.nrStrings < 0) throw new IOException("Stream data corrupted!");
                this.offset = new int[this.nrStrings + 1];
                for (int i2 = 0; i2 <= this.nrStrings; ++i2) {
                    this.offset[i2] = ((DataInputStream)filterInputStream).readInt();
                }
                if (this.offset[this.nrStrings] > 0) {
                    this.data = new byte[this.offset[this.nrStrings]];
                    ((DataInputStream)filterInputStream).readFully(this.data);
                    return;
                }
                if (this.offset[this.nrStrings] != 0) throw new IOException("Stream data corrupted!");
                this.data = new byte[0];
                return;
            }
            catch (Exception exception) {
                System.err.println(new StringBuffer().append("[ERROR] cannot open file: ").append(string).toString());
                System.err.println("[ERROR] ext_log.zip is not in the CLASSPATH!!!");
                return;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return;
            }
            finally {
                if (filterInputStream != null) {
                    try {
                        filterInputStream.close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
            }
        }

        public String getString(int n) {
            if (n >= 0 && n < this.nrStrings) {
                try {
                    return new String(this.data, this.offset[n], this.offset[n + 1] - this.offset[n], this.charset);
                }
                catch (Exception exception) {
                    return "[ERROR] ext_log.zip is not in the CLASSPATH!!!";
                }
            }
            return "[ERROR] ext_log.zip is not in the CLASSPATH!!!";
        }
    }
}

