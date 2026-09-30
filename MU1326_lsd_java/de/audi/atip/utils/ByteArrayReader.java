/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import java.io.IOException;

public class ByteArrayReader {
    private final byte[] data;
    private int pointer = 0;

    public ByteArrayReader(byte[] byArray) {
        this.data = byArray;
    }

    public int getSize() {
        return this.data.length;
    }

    public int getUnreadSize() {
        return this.data.length - this.pointer - 1;
    }

    public boolean readBoolean() {
        return this.data[this.pointer++] == 1;
    }

    public byte readByte() {
        return this.data[this.pointer++];
    }

    public int readInt() {
        byte by = this.data[this.pointer++];
        byte by2 = this.data[this.pointer++];
        byte by3 = this.data[this.pointer++];
        byte by4 = this.data[this.pointer++];
        return by << 24 | (by2 & 0xFF) << 16 | (by3 & 0xFF) << 8 | by4 & 0xFF;
    }

    public long readLong() {
        int n = this.readInt();
        byte by = this.data[this.pointer++];
        byte by2 = this.data[this.pointer++];
        byte by3 = this.data[this.pointer++];
        byte by4 = this.data[this.pointer++];
        return (long)n << 32 | ((long)by & 0xFFL) << 24 | ((long)by2 & 0xFFL) << 16 | ((long)by3 & 0xFFL) << 8 | (long)by4 & 0xFFL;
    }

    public short readShort() {
        byte by = this.data[this.pointer++];
        byte by2 = this.data[this.pointer++];
        return (short)((by & 0xFF) << 8 | by2 & 0xFF);
    }

    public int readUnsignedShort() {
        byte by = this.data[this.pointer++];
        byte by2 = this.data[this.pointer++];
        return ((by & 0xFF) << 8) + (by2 & 0xFF);
    }

    public final String readUTF() throws IOException {
        int n = this.readUnsignedShort();
        return this.decodeUTF(n);
    }

    String decodeUTF(int n) throws IOException {
        byte[] byArray = new byte[n];
        this.readFully(byArray);
        StringBuffer stringBuffer = new StringBuffer("");
        int n2 = 0;
        while (n2 < byArray.length) {
            byte by;
            byte by2;
            if ((byArray[n2] & 0xE0) == 224) {
                by2 = byArray[n2++];
                by = byArray[n2++];
                byte by3 = byArray[n2++];
                stringBuffer.append((char)((by2 & 0xF) << 12 | (by & 0x3F) << 6 | by3 & 0x3F));
                continue;
            }
            if ((byArray[n2] & 0xC0) == 192) {
                by2 = byArray[n2++];
                by = byArray[n2++];
                stringBuffer.append((char)((by2 & 0x1F) << 6 | by & 0x3F));
                continue;
            }
            stringBuffer.append((char)byArray[n2++]);
        }
        return stringBuffer.toString();
    }

    public final void readFully(byte[] byArray) throws IOException {
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byArray[i2] = this.data[this.pointer++];
        }
    }
}

