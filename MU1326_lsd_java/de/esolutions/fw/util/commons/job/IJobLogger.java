/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

public interface IJobLogger {
    public static final int LOG_CRITICAL = 1000;
    public static final int LOG_ERROR = 10000;
    public static final int LOG_WARNING = 100000;
    public static final int LOG_INFO = 1000000;
    public static final int LOG_DEBUG = 10000000;
    public static final int LOG_DEBUG2 = 100000000;

    public void log(int var1, String var2, Object var3);

    public void log(int var1, String var2, Object var3, int var4);

    public void log(int var1, String var2, Object var3, int var4, int var5);

    public void log(int var1, String var2, Object var3, Object var4);

    public void log(int var1, String var2, Object var3, Object var4, int var5);

    public void logException(Exception var1);
}

