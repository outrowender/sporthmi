/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class StubFailedMessage
extends AbstractMessage {
    private short proxyID;
    private byte errorCode;

    public StubFailedMessage(ISerializer iSerializer, short s, byte by) {
        super(MessageType.STUB_FAILED, iSerializer);
        this.proxyID = s;
        this.errorCode = by;
    }

    public StubFailedMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.STUB_FAILED, iDeserializer, bl);
    }

    protected void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt16(this.proxyID);
        iSerializer.putInt8(this.errorCode);
    }

    protected void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.proxyID = iDeserializer.getInt16();
        this.errorCode = iDeserializer.getInt8();
    }

    public short getProxyID() {
        return this.proxyID;
    }

    public byte getErrorCode() {
        return this.errorCode;
    }
}

