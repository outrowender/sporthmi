/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class StubCreatedMessage
extends AbstractMessage {
    private short proxyID;
    private short stubID;

    public StubCreatedMessage(ISerializer iSerializer, short s, short s2) {
        super(MessageType.STUB_CREATED, iSerializer);
        this.proxyID = s;
        this.stubID = s2;
    }

    public StubCreatedMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.STUB_CREATED, iDeserializer, bl);
    }

    protected void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt16(this.proxyID);
        iSerializer.putInt16(this.stubID);
    }

    protected void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.proxyID = iDeserializer.getInt16();
        this.stubID = iDeserializer.getInt16();
    }

    public short getProxyID() {
        return this.proxyID;
    }

    public short getStubID() {
        return this.stubID;
    }
}

