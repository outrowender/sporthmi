/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.buffer;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;
import de.esolutions.fw.util.transport.exception.TransportBufferException;

public class TransportSubBuffer
implements IReadable {
    protected TransportBuffer buffer;
    protected int offset;
    protected int size;

    public TransportSubBuffer(TransportBuffer transportBuffer, int n, int n2) {
        this.buffer = transportBuffer;
        this.offset = n;
        this.size = n2;
    }

    public byte[] getData() throws TransportBufferException {
        return this.buffer.getData(this.offset, this.size);
    }

    public byte[] getData(int n, int n2) throws TransportBufferException {
        return this.buffer.getData(this.offset + n, n2);
    }

    public byte[] getDirectData() {
        return this.buffer.getDirectData();
    }

    public int getDirectOffset() {
        return this.offset;
    }

    public int size() {
        return this.size;
    }

    public IReadable createSubBuffer(int n, int n2) throws TransportBufferException {
        if (n + n2 > this.size) {
            throw new TransportBufferException("Invalid window (" + n + "," + this.size + ") current=(" + this.offset + "," + this.size() + ")");
        }
        return new TransportSubBuffer(this.buffer, this.offset + n, n2);
    }

    public void setDebugTag(Object object) {
        this.buffer.setDebugTag(object);
    }

    public Object getDebugTag() {
        return this.buffer.getDebugTag();
    }
}

