/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.atip.log.LogChannel;

public interface IBAPLogger {
    public LogChannel getMainLog();

    public LogChannel getDSILog();

    public LogChannel getDiagLog();

    public LogChannel getLog(int var1);

    public LogChannel getLogBAPData(int var1);
}

