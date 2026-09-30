/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.async.AbstractAsyncTransport;
import de.esolutions.fw.util.transport.async.FlushTransportJob;
import de.esolutions.fw.util.transport.async.RXTransportJob;
import de.esolutions.fw.util.transport.async.TXTransportJob;
import de.esolutions.fw.util.transport.async.TransportWorker;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.exception.TransportTimeoutException;
import java.io.IOException;
import java.net.SocketTimeoutException;

public class AsyncTransport
extends AbstractAsyncTransport {
    public AsyncTransport(ITransport iTransport) {
        super(iTransport);
    }

    public AsyncTransport(ITransport iTransport, TransportWorker transportWorker) {
        super(iTransport, transportWorker);
    }

    public IReadable recv() throws IOException, TransportException, InterruptedException {
        RXTransportJob rXTransportJob;
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            this.context.throwPendingException();
            rXTransportJob = new RXTransportJob(this.context, this.transport);
            this.worker.addJob(rXTransportJob);
            rXTransportJob.waitDone();
            this.context.throwPendingException();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
        return rXTransportJob.getReadable();
    }

    public void send(IWriter iWriter) throws IOException, TransportException, InterruptedException {
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            this.context.throwPendingException();
            this.worker.addJob(new TXTransportJob(this.context, this.transport, iWriter));
            this.context.throwPendingException();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
    }

    public void sendSync(IWriter iWriter) throws IOException, TransportException, InterruptedException {
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            this.context.throwPendingException();
            TXTransportJob tXTransportJob = new TXTransportJob(this.context, this.transport, iWriter);
            this.worker.addJob(tXTransportJob);
            tXTransportJob.waitDone();
            this.context.throwPendingException();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
    }

    public void flush() throws IOException, TransportException, InterruptedException {
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            this.context.throwPendingException();
            this.worker.addJob(new FlushTransportJob(this.context, this.transport));
            this.context.throwPendingException();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
    }

    public String getDescription() {
        return "[Async:" + this.transport.getDescription() + "]";
    }
}

