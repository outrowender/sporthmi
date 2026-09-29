/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.log;

import de.audi.atip.log.AbstractLogSink;
import de.audi.atip.log.IStandardConsoleLogSink;
import de.audi.atip.log.LogEntry;
import de.audi.atip.log.LogSink;
import de.esolutions.fw.util.commons.Buffer;

final class StandardConsoleSink
extends AbstractLogSink
implements LogSink,
IStandardConsoleLogSink {
    private static Buffer buf = new Buffer(300);
    private boolean ansiColorEnabled;

    public StandardConsoleSink() {
        this.getConfiguration().put("all", new Integer(10000));
        this.ansiColorEnabled = Boolean.getBoolean("ANSICOLOR");
    }

    private void doWriteAnsiColorStart(Buffer buffer, int n) {
        if (!this.ansiColorEnabled) {
            return;
        }
        switch (n) {
            case 1000: {
                buffer.append("\u001b[0;40;35m");
                break;
            }
            case 10000: {
                buffer.append("\u001b[0;40;31m");
                break;
            }
            case 100000: {
                buffer.append("\u001b[0;40;33m");
                break;
            }
            case 1000000: {
                buffer.append("\u001b[0;40;32m");
                break;
            }
            case 10000000: {
                buffer.append("\u001b[0;40;36m");
                break;
            }
            case 100000000: {
                buffer.append("\u001b[0;40;34m");
                break;
            }
        }
    }

    private void doWriteAnsiColorStop(Buffer buffer) {
        if (!this.ansiColorEnabled) {
            return;
        }
        buffer.append("\u001b[0m");
    }

    @Override
    public synchronized void writeLog(LogEntry logEntry) {
        if (logEntry != null) {
            this.doWriteAnsiColorStart(buf, logEntry.getLevel());
            logEntry.print(buf);
            this.doWriteAnsiColorStop(buf);
            System.out.println(buf.toString());
            buf.clear();
        }
    }
}

