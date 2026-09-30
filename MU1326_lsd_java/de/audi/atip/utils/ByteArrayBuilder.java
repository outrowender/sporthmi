/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import com.ibm.oti.util.Msg;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import java.io.IOException;
import java.io.UTFDataFormatException;

public class ByteArrayBuilder {
    private final GList<Byte> byteList = Generics.newArrayList();

    public byte[] build() {
        byte[] byArray = new byte[this.byteList.size()];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byArray[i2] = this.byteList.get(i2);
        }
        return byArray;
    }

    public ByteArrayBuilder addBoolean(boolean bl) {
        this.byteList.add(new Byte((byte)(bl ? 1 : 0)));
        return this;
    }

    public ByteArrayBuilder addByte(byte by) {
        this.byteList.add(new Byte(by));
        return this;
    }

    public ByteArrayBuilder addInt(int n) {
        this.byteList.add(new Byte((byte)(n >> 24)));
        this.byteList.add(new Byte((byte)(n >> 16)));
        this.byteList.add(new Byte((byte)(n >> 8)));
        this.byteList.add(new Byte((byte)n));
        return this;
    }

    public ByteArrayBuilder addLong(long l) {
        this.addInt((int)(l >> 32));
        this.addInt((int)l);
        return this;
    }

    public final ByteArrayBuilder addShort(int n) {
        this.byteList.add(new Byte((byte)(n >> 8)));
        this.byteList.add(new Byte((byte)n));
        return this;
    }

    public final ByteArrayBuilder addUTF(String string) throws IOException {
        long l;
        int n = string.length();
        if (n > 65535 || (l = this.countUTFBytes(string)) > 65535L) {
            throw new UTFDataFormatException(Msg.getString("K0068"));
        }
        this.addShort((int)l);
        this.addUTFBytes(string);
        return this;
    }

    private long countUTFBytes(String string) {
        int n = 0;
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 > '\u0000' && c2 <= '\u007f') {
                ++n;
                continue;
            }
            if (c2 <= '\u07ff') {
                n += 2;
                continue;
            }
            n += 3;
        }
        return n;
    }

    private void addUTFBytes(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 > '\u0000' && c2 <= '\u007f') {
                this.byteList.add(new Byte((byte)c2));
                continue;
            }
            if (c2 <= '\u07ff') {
                this.byteList.add(new Byte((byte)(0xC0 | 0x1F & c2 >> 6)));
                this.byteList.add(new Byte((byte)(0x80 | 0x3F & c2)));
                continue;
            }
            this.byteList.add(new Byte((byte)(0xE0 | 0xF & c2 >> 12)));
            this.byteList.add(new Byte((byte)(0x80 | 0x3F & c2 >> 6)));
            this.byteList.add(new Byte((byte)(0x80 | 0x3F & c2)));
        }
    }
}

