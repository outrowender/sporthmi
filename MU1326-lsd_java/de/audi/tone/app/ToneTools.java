/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.esolutions.fw.util.commons.Buffer;

public final class ToneTools {
    public static int calculateMedialPosition(int n, int n2) {
        return (int)Math.floor((n + n2) / 2);
    }

    public static String toLogMessage(int n, int n2, short s) {
        Buffer buffer = new Buffer(30);
        buffer.append("AC:").append(n);
        buffer.append(" AT:").append(n2);
        buffer.append(" value:").append(s);
        return buffer.toString();
    }

    public static String toLogMessage(int n, int n2, boolean bl) {
        Buffer buffer = new Buffer(30);
        buffer.append("AC:").append(n);
        buffer.append(" AT:").append(n2);
        buffer.append(" value:").append(bl);
        return buffer.toString();
    }

    public static String toLogMessage(int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer(30);
        buffer.append("AC:").append(n);
        buffer.append(" AT:").append(n2);
        buffer.append(" min:").append(n3);
        buffer.append(" max:").append(n4);
        return buffer.toString();
    }
}

