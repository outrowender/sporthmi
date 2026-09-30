/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

public interface Logger {
    public static final int LEVEL_TRACE = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_WARN = 3;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;

    public void log(int var1, String var2);

    public void log(int var1, String var2, Exception var3);
}

