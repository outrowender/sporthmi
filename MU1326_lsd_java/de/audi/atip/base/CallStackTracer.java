/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.FrameworkException;
import de.esolutions.fw.util.commons.Buffer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CallStackTracer {
    private static final String DEFAULT_TRACE_PATH = new StringBuffer().append("c:").append(File.separator).append("Temp").append(File.separator).append("CallTraces").append(File.separator).toString();
    private static final String DEFAULT_FILE_NAME_PREFIX = "callStack_";
    private static final String DEFAULT_FILE_SUFFIX = ".txt";
    private static SimpleDateFormat dateFormat;
    private String traceFilePath;
    private String traceFilePrefix;
    private String traceFileSuffix;

    private CallStackTracer() {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
    }

    public static CallStackTracer getInstance() {
        return InstanceHolder.instance;
    }

    private String getTraceFilePath() {
        if (this.traceFilePath == null) {
            return DEFAULT_TRACE_PATH;
        }
        return this.traceFilePath;
    }

    private String getTraceFilePrefix() {
        if (this.traceFilePrefix == null) {
            return DEFAULT_FILE_NAME_PREFIX;
        }
        return this.traceFilePrefix;
    }

    private String getTraceFileSuffix() {
        if (this.traceFileSuffix == null) {
            return DEFAULT_FILE_SUFFIX;
        }
        return this.traceFileSuffix;
    }

    public void setTraceFilePath(String string) {
        if (!string.endsWith(File.separator)) {
            string = new StringBuffer().append(string).append(File.separator).toString();
        }
        this.traceFilePath = string;
    }

    public void setTraceFilePrefix(String string) {
        if (!string.endsWith("_")) {
            string = new StringBuffer().append(string).append("_").toString();
        }
        this.traceFilePrefix = string;
    }

    public void setTraceFileSuffix(String string) {
        this.traceFileSuffix = string;
    }

    public synchronized void trace(String string) {
        File file = this.getTraceFile(string);
        FrameworkException frameworkException = new FrameworkException("CallStackTrace");
        StackTraceElement[] stackTraceElementArray = frameworkException.getStackTrace();
        Buffer buffer = new Buffer();
        for (int i2 = 1; i2 < stackTraceElementArray.length; ++i2) {
            buffer.append(stackTraceElementArray[i2].toString()).append('\n');
        }
        if (buffer.length() > 0) {
            this.writeString(buffer.toString(), file);
        }
    }

    private File getTraceFile(String string) {
        File file = new File(new Buffer(this.getTraceFilePath()).append(this.getTraceFilePrefix()).append(string).append(this.getTraceFileSuffix()).toString());
        this.writeString(new StringBuffer().append(">>>>>>>>>>>>> ").append(dateFormat.format(new Date(System.currentTimeMillis()))).append(" Thread: ").append(Thread.currentThread().getName()).toString(), file);
        return file;
    }

    private void writeString(String string, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(string);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private static class InstanceHolder {
        private static CallStackTracer instance = new CallStackTracer();

        private InstanceHolder() {
        }
    }
}

