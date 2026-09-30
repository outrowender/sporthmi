/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class ExecuteCallbackMessage
extends AbstractMessage {
    private int cbid;
    private byte[] payload;

    public ExecuteCallbackMessage(int n, byte[] byArray) {
        super(MessageType.EXECUTE_CALLBACK);
        this.cbid = n;
        this.payload = byArray;
    }

    public ExecuteCallbackMessage() {
        super(MessageType.EXECUTE_CALLBACK);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt32(this.cbid);
        if (this.payload == null) {
            iSerializer.putInt8VarArray(new byte[0]);
        } else {
            iSerializer.putInt8VarArray(this.payload);
        }
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.cbid = iDeserializer.getInt32();
        this.payload = iDeserializer.getInt8VarArray();
    }

    public int getCallbackId() {
        return this.cbid;
    }

    public byte[] getCallbackPayload() {
        return this.payload;
    }

    public void toStringBuffer(Buffer buffer) {
        buffer.append("Execute Callback: cbid=");
        buffer.append(this.cbid);
        buffer.append(" payload=");
        buffer.append(this.payload.length);
    }
}

