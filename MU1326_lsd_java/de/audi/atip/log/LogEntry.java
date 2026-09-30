/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.esolutions.fw.util.commons.Buffer;
import java.io.PrintStream;

public interface LogEntry {
    public String getChannelName();

    public Throwable getException();

    public String getFormatedTimestamp();

    public int getLevel();

    public String getLevelName();

    public String getMsg();

    public String getLogMessage();

    public String getLogMessage(String var1);

    public String getTemplate();

    public long getTimeStamp();

    public String toString();

    public void print(PrintStream var1);

    public void print(Buffer var1);

    public void freezeArgs();
}

