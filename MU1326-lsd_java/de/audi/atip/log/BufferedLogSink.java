/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogSink;

public interface BufferedLogSink
extends LogSink {
    default public void setBufferSize(int n) {
    }

    default public void clearBuffer() {
    }

    default public void dumpBuffer() {
    }

    default public void startBuffering() {
    }

    default public void stopBuffering() {
    }
}

