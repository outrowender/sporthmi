/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.esolutions.fw.util.commons.Buffer;

public final class AudioTools {
    public static String toString(int n, int n2, int n3) {
        Buffer buffer = new Buffer(30);
        buffer.append("AC:").append(n);
        buffer.append(" AT:").append(n2);
        buffer.append(" value:").append(n3);
        return buffer.toString();
    }

    private AudioTools() {
    }
}

