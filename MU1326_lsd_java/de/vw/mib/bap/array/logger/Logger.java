/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.logger;

import de.vw.mib.bap.array.asg.ASGArrayList;

public interface Logger {
    public static final int LOG_LEVEL_FATAL = 1;
    public static final int LOG_LEVEL_ERROR = 2;
    public static final int LOG_LEVEL_WARN = 4;
    public static final int LOG_LEVEL_INFO = 8;
    public static final int LOG_LEVEL_NORMAL = 12;
    public static final int LOG_LEVEL_TRACE = 16;

    public void log(ASGArrayList var1, int var2, String var3);
}

