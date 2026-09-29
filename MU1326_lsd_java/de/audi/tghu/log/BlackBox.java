/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.log.AbstractLogSink;
import de.audi.atip.log.LogEntry;
import de.audi.tghu.log.LogExtractorFactory;
import de.esolutions.fw.util.commons.RingBuffer;
import java.io.PrintStream;

public final class BlackBox
extends AbstractLogSink {
    private RingBuffer content;

    public BlackBox(int n) {
        this.content = new RingBuffer(n);
    }

    @Override
    public synchronized void writeLog(LogEntry logEntry) {
        if (logEntry != null) {
            logEntry.freezeArgs();
            this.content.put(logEntry);
        }
    }

    public synchronized void dumpBuffer(PrintStream printStream) {
        if (printStream == null) {
            return;
        }
        LogExtractorFactory.getInstance().dumpInfo(printStream);
        for (int i2 = 0; i2 < this.content.size(); ++i2) {
            LogEntry logEntry = (LogEntry)this.content.get(i2);
            logEntry.print(printStream);
            printStream.println();
        }
    }
}

