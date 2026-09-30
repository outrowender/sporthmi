/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class ToggleEntityMessage
extends AbstractMessage {
    private TraceEntityURI uri;
    private boolean on;

    public ToggleEntityMessage(TraceEntityURI traceEntityURI, boolean bl) {
        super(MessageType.TOGGLE_ENTITY);
        this.uri = traceEntityURI;
        this.on = bl;
    }

    public ToggleEntityMessage() {
        super(MessageType.TOGGLE_ENTITY);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt16(this.uri.getType());
        iSerializer.putInt32(this.uri.getId());
        iSerializer.putInt8(this.on ? (byte)1 : 0);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        short s = iDeserializer.getInt16();
        int n = iDeserializer.getInt32();
        byte by = iDeserializer.getInt8();
        this.uri = new TraceEntityURI(s, n);
        this.on = by != 0;
    }

    public TraceEntityURI getUri() {
        return this.uri;
    }

    public boolean getOn() {
        return this.on;
    }

    public void toStringBuffer(Buffer buffer) {
        buffer.append("Toggle Entity: type=");
        buffer.append(this.uri.getType());
        buffer.append(" id=");
        buffer.append(this.uri.getId());
        buffer.append(" on=");
        buffer.append(this.on);
    }
}

