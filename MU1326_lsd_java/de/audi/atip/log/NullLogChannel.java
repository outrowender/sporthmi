/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogChannel;

public final class NullLogChannel
extends LogChannel {
    private static final NullLogChannel instance = new NullLogChannel();

    public static LogChannel getInstance() {
        return instance;
    }

    private NullLogChannel() {
        this.name = "NullLogChannel";
    }

    public void log(int n, String string, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n2, Throwable throwable) {
    }

    public void log(int n, int n2, Object object, Object object2, Object object3, Object object4, long l, long l2, long l3, int n3, Throwable throwable) {
    }
}

