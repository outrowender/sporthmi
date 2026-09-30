/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;

public class DeflaterOutputStream
extends FilterOutputStream {
    static final int BUF_SIZE = 512;
    protected byte[] buf;
    protected Deflater def;
    boolean done = false;

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater) {
        this(outputStream, deflater, 512);
    }

    public DeflaterOutputStream(OutputStream outputStream) {
        this(outputStream, new Deflater());
    }

    public DeflaterOutputStream(OutputStream outputStream, Deflater deflater, int n) {
        super(outputStream);
        if (outputStream == null || deflater == null) {
            throw new NullPointerException();
        }
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.def = deflater;
        this.buf = new byte[n];
    }

    protected void deflate() throws IOException {
        int n = 0;
        do {
            n = this.def.deflate(this.buf);
            this.out.write(this.buf, 0, n);
        } while (!this.def.needsInput());
    }

    public void close() throws IOException {
        if (!this.def.finished()) {
            this.finish();
        }
        this.def.end();
        this.out.close();
    }

    public void finish() throws IOException {
        if (this.done) {
            return;
        }
        this.def.finish();
        int n = 0;
        while (!this.def.finished()) {
            if (this.def.needsInput()) {
                this.def.setInput(this.buf, 0, 0);
            }
            n = this.def.deflate(this.buf);
            this.out.write(this.buf, 0, n);
        }
        this.done = true;
    }

    public void write(int n) throws IOException {
        byte[] byArray = new byte[]{(byte)n};
        this.write(byArray, 0, 1);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (this.done) {
            throw new IOException(Msg.getString("K0007"));
        }
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            if (!this.def.needsInput()) {
                throw new IOException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.def.setInput(byArray, n, n2);
        this.deflate();
    }
}

