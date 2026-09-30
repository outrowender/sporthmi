/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class RRStubCreatedMessage
extends AbstractMessage {
    private short proxyID;
    private short stubID;
    private short replyProxyID;

    public RRStubCreatedMessage(ISerializer iSerializer, short s, short s2, short s3) {
        super(MessageType.RRSTUB_CREATED, iSerializer);
        this.proxyID = s;
        this.stubID = s2;
        this.replyProxyID = s3;
    }

    public RRStubCreatedMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.RRSTUB_CREATED, iDeserializer, bl);
    }

    protected void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt16(this.proxyID);
        iSerializer.putInt16(this.stubID);
        iSerializer.putInt16(this.replyProxyID);
    }

    protected void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.proxyID = iDeserializer.getInt16();
        this.stubID = iDeserializer.getInt16();
        this.replyProxyID = iDeserializer.getInt16();
    }

    public short getProxyID() {
        return this.proxyID;
    }

    public short getStubID() {
        return this.stubID;
    }

    public short getReplyProxyID() {
        return this.replyProxyID;
    }
}

