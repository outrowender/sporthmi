/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SetFeatureMessage
extends AbstractMessage {
    private byte value;

    public SetFeatureMessage(ISerializer iSerializer, byte by) {
        super(MessageType.SET_FEATURE, iSerializer);
        this.value = by;
    }

    public SetFeatureMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.SET_FEATURE, iDeserializer, bl);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
        iSerializer.putInt8(this.value);
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
        this.value = iDeserializer.getInt8();
    }

    public byte getValue() {
        return this.value;
    }
}

