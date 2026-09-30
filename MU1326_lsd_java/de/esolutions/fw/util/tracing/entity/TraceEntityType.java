/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

public class TraceEntityType {
    public static final short TARGET = 0;
    public static final short PROCESS = 1;
    public static final short THREAD = 2;
    public static final short CHANNEL = 3;
    public static final short CALLBACK = 4;
    public static final short PROBE = 5;
    public static final short _LAST = 6;
    public static final String[] names = new String[]{"target", "process", "thread", "channel", "callback", "probe"};

    public static String getName(short s) {
        if (s >= 0 && s < 6) {
            return names[s];
        }
        return null;
    }
}

