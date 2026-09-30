/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogSink;

public interface BufferedLogSink
extends LogSink {
    public void setBufferSize(int var1);

    public void clearBuffer();

    public void dumpBuffer();

    public void startBuffering();

    public void stopBuffering();
}

