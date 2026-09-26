/*
 * Decompiled with CFR 0.152.
 */
package de.audi.swdiagnosis.media.dsi;

import de.audi.atip.base.BaseLogEntryImpl;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogEntry;
import java.io.PrintStream;

public class DummySystemOutLogChannel
extends LogChannel {
    private PrintStream out;

    public DummySystemOutLogChannel() {
        this("SystemOutLogChannel");
    }

    public DummySystemOutLogChannel(PrintStream printStream) {
        this(printStream, "SystemOutLogChannel");
    }

    public DummySystemOutLogChannel(PrintStream printStream, String string) {
        this(string, -129, printStream);
    }

    public DummySystemOutLogChannel(String string) {
        this(System.out, string);
    }

    protected DummySystemOutLogChannel(String string, int n) {
        this(string, n, System.out);
    }

    protected DummySystemOutLogChannel(String string, int n, PrintStream printStream) {
        this.name = string != null ? string : "";
        this.loglevel = n;
        this.out = printStream;
    }

    protected void setStream(PrintStream printStream) {
        this.out = printStream;
    }

    @Override
    public void log(int n, String string, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n2, Throwable throwable) {
        if (n <= this.loglevel) {
            BaseLogEntryImpl baseLogEntryImpl = new BaseLogEntryImpl(this.name, n, string, object, object2, object3, object4, l, l2, l3, n2, throwable);
            this.writeLog(baseLogEntryImpl);
        }
    }

    @Override
    public void log(int n, int n2, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n3, Throwable throwable) {
    }

    protected void writeLog(LogEntry logEntry) {
        logEntry.print(this.out);
        this.out.println();
    }

    public String getName() {
        return this.name;
    }
}

