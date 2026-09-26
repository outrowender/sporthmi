/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

public interface Logger {
    public static final int LEVEL_TRACE;
    public static final int LEVEL_DEBUG;
    public static final int LEVEL_INFO;
    public static final int LEVEL_WARN;
    public static final int LEVEL_ERROR;
    public static final int LEVEL_FATAL;

    default public void log(int n, String string) {
    }

    default public void log(int n, String string, Exception exception) {
    }
}

