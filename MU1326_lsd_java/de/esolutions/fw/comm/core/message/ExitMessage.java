/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ExitMessage
extends AbstractMessage {
    public ExitMessage(ISerializer iSerializer) {
        super(MessageType.EXIT, iSerializer);
    }

    public ExitMessage(IDeserializer iDeserializer, boolean bl) throws SerializerException {
        super(MessageType.EXIT, iDeserializer, bl);
    }

    public void serializeElements(ISerializer iSerializer) throws SerializerException {
    }

    public void deserializeElements(IDeserializer iDeserializer) throws SerializerException {
    }
}

