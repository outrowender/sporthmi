/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.util.zip.Checksum;

public class Adler32
implements Checksum {
    private long adler = 1L;

    public long getValue() {
        return this.adler;
    }

    public void reset() {
        this.adler = 1L;
    }

    public void update(int n) {
        this.adler = this.updateByteImpl(n, this.adler);
    }

    public void update(byte[] byArray) {
        this.update(byArray, 0, byArray.length);
    }

    public void update(byte[] byArray, int n, int n2) {
        if (n > byArray.length || n2 < 0 || n < 0 || byArray.length - n < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.adler = this.updateImpl(byArray, n, n2, this.adler);
    }

    private native long updateImpl(byte[] var1, int var2, int var3, long var4);

    private native long updateByteImpl(int var1, long var2);
}

