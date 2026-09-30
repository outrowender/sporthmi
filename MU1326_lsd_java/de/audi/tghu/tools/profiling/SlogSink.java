/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tools.profiling;

import de.audi.atip.log.AbstractLogSink;
import de.audi.atip.log.ISLOGSink;
import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogSink;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class SlogSink
extends AbstractLogSink
implements LogSink,
ISLOGSink {
    private static final int MAX_BUFFER = 160;
    int[] intHeaderDefault = new int[]{13, 1058779, 1};
    int[] intHeaderStartup = new int[]{13, 1049634683, 1};
    private FileOutputStream slog;
    private boolean writerReady;

    public SlogSink() {
        String string = System.getProperty("os.arch");
        if ("sh4".equals(string) || "arm".equals(string)) {
            this.intHeaderDefault[0] = this.convertToLittleEndian(this.intHeaderDefault[0]);
            this.intHeaderDefault[1] = this.convertToLittleEndian(this.intHeaderDefault[1]);
            this.intHeaderDefault[2] = this.convertToLittleEndian(this.intHeaderDefault[2]);
            this.intHeaderStartup[0] = this.convertToLittleEndian(this.intHeaderStartup[0]);
            this.intHeaderStartup[1] = this.convertToLittleEndian(this.intHeaderStartup[1]);
            this.intHeaderStartup[2] = this.convertToLittleEndian(this.intHeaderStartup[2]);
        }
        this.addDefaultSettings(this.getConfiguration());
        this.openSlogDevice();
    }

    private Map addDefaultSettings(Map map) {
        if (map.get("all") == null) {
            map.put("all", new Integer(1000));
        }
        if (map.get("Profiling") == null) {
            map.put("Profiling", new Integer(100000000));
        }
        if (map.get("Ext.Profiling") == null) {
            map.put("Ext.Profiling", new Integer(100000000));
        }
        return map;
    }

    public void setConfiguration(Map map) {
        super.setConfiguration(this.addDefaultSettings(map));
    }

    public void writeString(String string) {
        if (this.writerReady) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this.intHeaderDefault[0]);
                dataOutputStream.writeInt(this.intHeaderDefault[1]);
                dataOutputStream.writeInt(this.intHeaderDefault[2]);
                dataOutputStream.writeBytes("BENCHMARK: ");
                dataOutputStream.writeBytes("[");
                dataOutputStream.writeBytes(String.valueOf(System.currentTimeMillis()));
                dataOutputStream.writeBytes("] ");
                if (string.length() > 160) {
                    dataOutputStream.writeBytes(string.substring(0, 160));
                    dataOutputStream.writeBytes(" ...");
                } else {
                    dataOutputStream.writeBytes(string);
                }
                dataOutputStream.write(0);
                this.slog.write(byteArrayOutputStream.toByteArray());
                this.slog.flush();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public void writeLog(LogEntry logEntry) {
        if (this.writerReady) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                if (logEntry.getChannelName().equals("Ext.Startup")) {
                    dataOutputStream.writeInt(this.intHeaderStartup[0]);
                    dataOutputStream.writeInt(this.intHeaderStartup[1]);
                    dataOutputStream.writeInt(this.intHeaderStartup[2]);
                    dataOutputStream.writeBytes(logEntry.getFormatedTimestamp());
                    dataOutputStream.writeBytes(" MMX BENCH_Startup: ");
                    String string = logEntry.getLogMessage(null);
                    int n = string.indexOf("\n");
                    if (string.length() > 100 || n > 0) {
                        string = n > 0 && n < 100 ? string.substring(0, n) : string.substring(0, 100);
                        string = string.concat(" [...]");
                    }
                    dataOutputStream.writeBytes(string);
                    dataOutputStream.write(0);
                } else {
                    dataOutputStream.writeInt(this.intHeaderDefault[0]);
                    dataOutputStream.writeInt(this.intHeaderDefault[1]);
                    dataOutputStream.writeInt(this.intHeaderDefault[2]);
                    if (logEntry.getChannelName().equals("Ext.Benchmark")) {
                        dataOutputStream.writeBytes("BENCHMARK: ");
                    } else {
                        dataOutputStream.writeBytes("[");
                        dataOutputStream.writeBytes(String.valueOf(logEntry.getTimeStamp()));
                        dataOutputStream.writeBytes("] ");
                    }
                    String string = logEntry.getMsg();
                    if (string.length() > 160) {
                        dataOutputStream.writeBytes(string.substring(0, 160));
                        dataOutputStream.writeBytes(" ...");
                    } else {
                        dataOutputStream.writeBytes(string);
                    }
                    dataOutputStream.write(0);
                }
                this.slog.write(byteArrayOutputStream.toByteArray());
                this.slog.flush();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    protected void deinit() {
        this.writerReady = false;
        try {
            this.slog.flush();
            this.slog.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private int convertToLittleEndian(int n) {
        int n2 = n >> 0 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n >> 16 & 0xFF;
        int n5 = n >> 24 & 0xFF;
        return n2 << 24 | n3 << 16 | n4 << 8 | n5 << 0;
    }

    private void openSlogDevice() {
        try {
            this.slog = new FileOutputStream("/dev/slog", true);
        }
        catch (IOException iOException) {
            this.writerReady = false;
            iOException.printStackTrace();
            return;
        }
        this.writerReady = true;
    }
}

