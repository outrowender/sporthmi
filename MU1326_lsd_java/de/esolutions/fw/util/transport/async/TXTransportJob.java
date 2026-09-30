/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.async.ClientContext;
import de.esolutions.fw.util.transport.async.TransportJob;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public final class TXTransportJob
extends TransportJob {
    private final IWriter writer;

    public TXTransportJob(ClientContext clientContext, ITransport iTransport, IWriter iWriter) {
        super(clientContext, iTransport);
        this.writer = iWriter;
    }

    public final IWriter getWriter() {
        return this.writer;
    }

    protected final void doIO() throws InterruptedException, IOException, TransportException {
        this.transport.send(this.writer);
    }
}

