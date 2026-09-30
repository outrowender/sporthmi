/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DestroyStubMessage
extends AbstractMessage {
    private short stubID;

    public DestroyStubMessage(ISerializer iSerializer, short s) {
        super(MessageType.DESTROY_STUB, iSerializer);
        this.stubID = s;
    }

    public DestroyStubMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.DESTROY_STUB, iDeserializer, bl);
    }

    protected void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt16(this.stubID);
    }

    protected void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.stubID = iDeserializer.getInt16();
    }

    public short getStubID() {
        return this.stubID;
    }
}

