/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class RawMessage
extends AbstractMessage {
    private byte[] data;

    public RawMessage(MessageType messageType, IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(messageType, iDeserializer, bl);
    }

    public RawMessage(MessageType messageType, ISerializer iSerializer, byte[] byArray) {
        super(messageType, iSerializer);
        this.data = byArray;
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putRawBytes(this.data);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        int n = iDeserializer.bytesLeft();
        this.data = new byte[n];
        iDeserializer.getRawBytes(this.data);
    }

    public byte[] getData() {
        return this.data;
    }
}

