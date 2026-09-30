/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.exception.TransportException;

public final class AbstractMessageWriter
implements IWriter {
    private Object debugTag;
    private ISerializer serializer;
    private final AbstractMessage message;

    public AbstractMessageWriter(ISerializer iSerializer, AbstractMessage abstractMessage) {
        this.serializer = iSerializer;
        this.message = abstractMessage;
    }

    public final int size() {
        try {
            this.serializer.beginSizeCalc();
            this.message.serialize(this.serializer);
            return this.serializer.endSizeCalc();
        }
        catch (SerializerException serializerException) {
            return 0;
        }
    }

    public final void write(IWriteable iWriteable) throws TransportException {
        try {
            this.serializer.attachBuffer(iWriteable);
            this.message.serialize(this.serializer);
            this.serializer.detachBuffer();
        }
        catch (SerializerException serializerException) {
            throw new TransportException("Serializer failed with: " + serializerException);
        }
    }

    public final void setDebugTag(Object object) {
        this.debugTag = object;
    }

    public final Object getDebugTag() {
        return this.debugTag;
    }
}

