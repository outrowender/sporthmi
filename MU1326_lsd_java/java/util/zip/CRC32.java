/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.util.zip.Checksum;

public class CRC32
implements Checksum {
    private long crc = 0L;
    long tbytes = 0L;

    public long getValue() {
        return this.crc;
    }

    public void reset() {
        this.crc = 0L;
        this.tbytes = 0L;
    }

    public void update(int n) {
        this.crc = this.updateByteImpl((byte)n, this.crc);
    }

    public void update(byte[] byArray) {
        this.update(byArray, 0, byArray.length);
    }

    public void update(byte[] byArray, int n, int n2) {
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            this.tbytes += (long)n2;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.crc = this.updateImpl(byArray, n, n2, this.crc);
    }

    private native long updateImpl(byte[] var1, int var2, int var3, long var4);

    private native long updateByteImpl(byte var1, long var2);
}

