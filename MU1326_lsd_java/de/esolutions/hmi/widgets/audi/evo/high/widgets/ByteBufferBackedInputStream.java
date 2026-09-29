/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream
extends InputStream {
    ByteBuffer buf;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this.buf = byteBuffer;
    }

    @Override
    public int read() {
        if (!this.buf.hasRemaining()) {
            return -1;
        }
        return this.buf.get() & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (!this.buf.hasRemaining()) {
            return -1;
        }
        n2 = Math.min(n2, this.buf.remaining());
        this.buf.get(byArray, n, n2);
        return n2;
    }
}

