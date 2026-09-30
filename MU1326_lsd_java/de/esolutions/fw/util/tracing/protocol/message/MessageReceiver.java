/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.InitMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageDecoder;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public class MessageReceiver {
    protected ITransport transport;
    protected MessageDecoder decoder;

    public MessageReceiver(Connection connection) {
        this.transport = connection.getTransport();
        this.decoder = new MessageDecoder(connection.getDeserializer());
    }

    public void setDeserializer(IDeserializer iDeserializer) {
        this.decoder = new MessageDecoder(iDeserializer);
    }

    public AbstractMessage recvMessage() throws SerializerException, TransportException, IOException, InterruptedException {
        return this.decoder.decodeReadable(this.transport.recv());
    }

    public InitMessage recvInitMessage() throws SerializerException, TransportException, IOException, InterruptedException {
        AbstractMessage abstractMessage = this.recvMessage();
        if (abstractMessage == null) {
            throw new TransportException("Invalid Received Comm Message");
        }
        if (abstractMessage.getMessageType() != MessageType.INIT) {
            throw new TransportException("Expected INIT message, but got " + abstractMessage.getMessageType());
        }
        return (InitMessage)abstractMessage;
    }
}

