/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.exception.TransportException;

public class CopyWriter
implements IWriter {
    protected IReadable readable;

    public CopyWriter(IReadable iReadable) {
        this.readable = iReadable;
    }

    public int size() {
        return this.readable.size();
    }

    public void write(IWriteable iWriteable) throws TransportException {
        iWriteable.setData(this.readable.getData());
    }

    public void setDebugTag(Object object) {
        this.readable.setDebugTag(object);
    }

    public Object getDebugTag() {
        return this.readable.getDebugTag();
    }
}

