/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class GZIPOutputStream
extends DeflaterOutputStream {
    protected CRC32 crc = new CRC32();

    public GZIPOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 512);
    }

    public GZIPOutputStream(OutputStream outputStream, int n) throws IOException {
        super(outputStream, new Deflater(-1, true), n);
        this.writeShort(35615);
        this.out.write(8);
        this.out.write(0);
        this.writeLong(0L);
        this.out.write(0);
        this.out.write(0);
    }

    public void finish() throws IOException {
        super.finish();
        this.writeLong(this.crc.getValue());
        this.writeLong(this.crc.tbytes);
    }

    public void close() throws IOException {
        if (!this.done) {
            this.finish();
        }
        super.close();
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        super.write(byArray, n, n2);
        this.crc.update(byArray, n, n2);
    }

    private int writeShort(int n) throws IOException {
        this.out.write(n & 0xFF);
        this.out.write(n >> 8 & 0xFF);
        return n;
    }

    private long writeLong(long l) throws IOException {
        this.out.write((int)(l & 0xFFL));
        this.out.write((int)(l >> 8) & 0xFF);
        this.out.write((int)(l >> 16) & 0xFF);
        this.out.write((int)(l >> 24) & 0xFF);
        return l;
    }
}

