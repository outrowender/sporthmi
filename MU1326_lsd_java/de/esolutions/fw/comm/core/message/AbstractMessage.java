/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.CommDebugTag;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.exception.TransportException;

public abstract class AbstractMessage
implements IWriter {
    private Object debugTag;
    private MessageType type;
    private ISerializer serializer;
    protected IReadable payload;

    public AbstractMessage(MessageType messageType, ISerializer iSerializer) {
        this.type = messageType;
        this.serializer = iSerializer;
    }

    public AbstractMessage(MessageType messageType, IDeserializer iDeserializer, boolean bl) throws SerializerException {
        if (!bl) {
            this.type = messageType;
        }
        this.deserialize(iDeserializer, bl);
    }

    public MessageType getMessageType() {
        return this.type;
    }

    protected ISerializer getSerializer() {
        return this.serializer;
    }

    public int size() {
        try {
            this.serializer.beginSizeCalc();
            this.serialize(this.serializer);
            return this.serializer.endSizeCalc();
        }
        catch (SerializerException serializerException) {
            return 0;
        }
    }

    public void write(IWriteable iWriteable) throws TransportException {
        try {
            this.serializer.attachBuffer(iWriteable);
            this.serialize(this.serializer);
            this.serializer.detachBuffer();
        }
        catch (SerializerException serializerException) {
            throw new TransportException("Serializer failed with: " + serializerException);
        }
    }

    public void serialize(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt8(this.type.toByte());
        this.serializeElements(iSerializer);
    }

    public void deserialize(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        if (bl) {
            byte by = iDeserializer.getInt8();
            this.type = MessageType.getType(by);
        }
        this.deserializeElements(iDeserializer);
    }

    protected abstract void serializeElements(ISerializer var1) throws SerializerException;

    protected abstract void deserializeElements(IDeserializer var1) throws SerializerException;

    public void setPayload(IReadable iReadable) {
        this.payload = iReadable;
    }

    public IReadable getPayload() {
        return this.payload;
    }

    public void setDebugTag(Object object) {
        this.debugTag = object;
    }

    public Object getDebugTag() {
        return this.debugTag;
    }

    public void createDebugTag(long l) {
        this.debugTag = new CommDebugTag(l, this);
    }

    public void dump(Buffer buffer) {
        buffer.append(this.getClass().getName());
    }

    public String toString() {
        Buffer buffer = new Buffer();
        this.dump(buffer);
        return buffer.toString();
    }
}

