/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;

public class PipedOutputStream
extends OutputStream {
    private PipedInputStream dest;

    public PipedOutputStream() {
    }

    public PipedOutputStream(PipedInputStream pipedInputStream) throws IOException {
        this.connect(pipedInputStream);
    }

    public void close() throws IOException {
        if (this.dest != null) {
            this.dest.done();
            this.dest = null;
        }
    }

    public void connect(PipedInputStream pipedInputStream) throws IOException {
        if (this.dest == null) {
            if (pipedInputStream.isConnected) {
                throw new IOException(Msg.getString("K007a"));
            }
        } else {
            throw new IOException(Msg.getString("K0079"));
        }
        pipedInputStream.buffer = new byte[1024];
        pipedInputStream.isConnected = true;
        this.dest = pipedInputStream;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void flush() throws IOException {
        if (this.dest != null) {
            PipedInputStream pipedInputStream = this.dest;
            synchronized (pipedInputStream) {
                this.dest.notifyAll();
            }
        }
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        super.write(byArray, n, n2);
    }

    public void write(int n) throws IOException {
        if (this.dest == null) {
            throw new IOException();
        }
        this.dest.receive(n);
    }
}

