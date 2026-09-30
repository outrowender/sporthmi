/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.adapter.DefaultExtendedSerializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.stream.BEDefaultSerializer;
import de.esolutions.fw.util.tracing.protocol.message.MessageSender;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.OutputStreamTransport;
import java.io.IOException;
import java.io.OutputStream;

public class MessageWriter {
    private final OutputStream out;
    private final Connection c;
    private final MessageSender sender;

    public MessageWriter(OutputStream outputStream) {
        this.out = outputStream;
        OutputStreamTransport outputStreamTransport = new OutputStreamTransport(outputStream);
        PacketTransport packetTransport = new PacketTransport(outputStreamTransport);
        DefaultExtendedSerializer defaultExtendedSerializer = new DefaultExtendedSerializer(new BEDefaultSerializer());
        this.c = new Connection(packetTransport, defaultExtendedSerializer, null);
        this.sender = new MessageSender(this.c);
    }

    public void open() throws IOException, TransportException, InterruptedException {
        this.c.open();
    }

    public void close() throws IOException, TransportException, InterruptedException {
        this.c.close(false);
        this.out.close();
    }

    public MessageSender sender() {
        return this.sender;
    }
}

