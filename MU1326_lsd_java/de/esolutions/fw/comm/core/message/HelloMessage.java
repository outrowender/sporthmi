/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.CommStringTool;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class HelloMessage
extends AbstractMessage {
    protected String uri;
    protected short version;

    public HelloMessage(ISerializer iSerializer, short s, String string) {
        super(MessageType.HELLO, iSerializer);
        this.version = s;
        this.uri = string;
    }

    public HelloMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.HELLO, iDeserializer, bl);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putUInt8(this.version);
        CommStringTool.serializeCommString(this.uri, iSerializer);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.version = iDeserializer.getUInt8();
        this.uri = CommStringTool.deserializeCommString(iDeserializer);
    }

    public short getVersion() {
        return this.version;
    }

    public String getUri() {
        return this.uri;
    }
}

