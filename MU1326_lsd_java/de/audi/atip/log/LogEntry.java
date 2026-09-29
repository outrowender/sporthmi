/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.esolutions.fw.util.commons.Buffer;
import java.io.PrintStream;

public interface LogEntry {
    default public String getChannelName() {
    }

    default public Throwable getException() {
    }

    default public String getFormatedTimestamp() {
    }

    default public int getLevel() {
    }

    default public String getLevelName() {
    }

    default public String getMsg() {
    }

    default public String getLogMessage() {
    }

    default public String getLogMessage(String string) {
    }

    default public String getTemplate() {
    }

    default public long getTimeStamp() {
    }

    default public String toString() {
    }

    default public void print(PrintStream printStream) {
    }

    default public void print(Buffer buffer) {
    }

    default public void freezeArgs() {
    }
}

