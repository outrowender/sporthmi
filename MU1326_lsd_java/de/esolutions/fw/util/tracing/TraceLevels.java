/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

public class TraceLevels {
    public static final short TRACE = 0;
    public static final short DEBUG = 1;
    public static final short INFO = 2;
    public static final short WARN = 3;
    public static final short ERROR = 4;
    public static final short FATAL = 5;
    public static final short OFF = 6;
    public static final short NONE = 7;
    public static final short DISABLED = 8;
    public static final short _LAST = 9;
    public static final short NUM_VISIBLE_MESSAGES = 6;
    public static final String[] levelNames = new String[]{"trace", "debug", "info", "warn", "ERROR", "FATAL", "OFF", "NONE", "Disabled"};

    public static boolean isValidLogLevel(short s) {
        return s >= 0 && s <= 5;
    }

    public static boolean isValidFilterLevel(short s) {
        return s >= 0 && s <= 7;
    }

    public static String getName(short s) {
        if (s >= 0 && s <= 8) {
            return levelNames[s];
        }
        return null;
    }
}

