/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.serializer.stream.BEDefaultDeserializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;

public class MessageDecoder {
    private IDeserializer deserializer;

    public MessageDecoder() {
        this.deserializer = new DefaultExtendedDeserializer(new BEDefaultDeserializer());
    }

    public MessageDecoder(IDeserializer iDeserializer) {
        this.deserializer = iDeserializer;
    }

    public AbstractMessage decodeBuffer(byte[] byArray) throws SerializerException {
        return this.decodeReadable(new TransportBuffer(byArray));
    }

    public AbstractMessage decodeReadable(IReadable iReadable) throws SerializerException {
        try {
            this.deserializer.attachBuffer(iReadable);
            byte by = this.deserializer.getInt8();
            MessageType messageType = MessageType.getType(by);
            AbstractMessage abstractMessage = messageType.createMessage();
            if (abstractMessage == null) {
                throw new SerializerException("Invalid Trace Message Type: " + by);
            }
            abstractMessage.deserialize(this.deserializer);
            int n = this.deserializer.bytesLeft();
            if (n > 0) {
                throw new SerializerException("Serializer has bytes left: " + n);
            }
            this.deserializer.detachBuffer();
            return abstractMessage;
        }
        catch (RuntimeException runtimeException) {
            throw new SerializerException("Serializer had runtime problem: " + runtimeException.getMessage());
        }
    }
}

