/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.stream;

public interface BitStream {
    public static final int INT_BITS_SIZE = 32;
    public static final int SHORT_BITS_SIZE = 16;
    public static final int BYTE_BITS_SIZE = 8;
    public static final int BOOLEAN_BITS_SIZE = 1;

    public void pushBoolean(boolean var1);

    public void pushByte(byte var1);

    public void pushShort(short var1);

    public void pushInt(int var1);

    public void pushBits(int var1, int var2);

    public void pushBytes(byte[] var1);

    public void resetBits(int var1);

    public boolean popFrontBoolean();

    public int popFrontByte();

    public int popFrontShort();

    public int popFrontInt();

    public byte[] popFrontBytes(int var1);

    public int popFrontBits(int var1);

    public void discardBits(int var1);

    public int bitSize();
}

