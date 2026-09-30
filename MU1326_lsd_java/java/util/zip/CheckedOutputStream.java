/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Checksum;

public class CheckedOutputStream
extends FilterOutputStream {
    private Checksum check;

    public CheckedOutputStream(OutputStream outputStream, Checksum checksum) {
        super(outputStream);
        this.check = checksum;
    }

    public Checksum getChecksum() {
        return this.check;
    }

    public void write(int n) throws IOException {
        this.out.write(n);
        this.check.update(n);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.out.write(byArray, n, n2);
        this.check.update(byArray, n, n2);
    }
}

