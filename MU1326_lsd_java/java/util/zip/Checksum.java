/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

public interface Checksum {
    public long getValue();

    public void reset();

    public void update(int var1);

    public void update(byte[] var1, int var2, int var3);
}

