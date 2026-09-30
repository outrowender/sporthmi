/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.stream;

import de.vw.mib.bap.stream.BitStream;
import java.nio.BufferUnderflowException;

public class IntegerStream
implements BitStream {
    private static final int INT_MASK = -1;
    private static final int SHORT_MASK = 65535;
    private static final int BYTE_MASK = 255;
    private static final int TRUE_CONSTANT = 1;
    private static final int BYTES_IN_INTEGER = 4;
    private static final int DEFAULT_BIT_SIZE = 32;
    private static final int TRUE_INT_CONSTANT = 1;
    private static final int FALSE_INT_CONSTANT = 0;
    private int bitSize;
    private int bitsData;
    private int bitsMask;

    IntegerStream(int n) {
        this.bitSize = n;
        this.bitsData = 0;
        this.bitsMask = -1 >>> 32 - this.bitSize;
    }

    public IntegerStream(int n, int n2) {
        this.bitSize = n2;
        this.bitsData = n;
        this.bitsMask = -1 >>> 32 - n2;
    }

    public IntegerStream() {
        this(32);
    }

    public void pushByte(byte by) {
        this.bitsData <<= 8;
        this.bitsData |= by & 0xFF;
        this.bitsData &= this.bitsMask;
    }

    public void pushShort(short s) {
        this.bitsData <<= 16;
        this.bitsData |= s & 0xFFFF;
        this.bitsData &= this.bitsMask;
    }

    public void pushInt(int n) {
        this.bitsData = n & this.bitsMask;
    }

    public void pushBoolean(boolean bl) {
        this.pushBits(1, bl ? 1 : 0);
    }

    public void pushBytes(byte[] byArray) {
        int n = byArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.pushBits(8, byArray[i2]);
        }
    }

    public void pushBits(int n, int n2) {
        if (n == 32) {
            this.bitsData = n2;
        } else {
            this.bitsData <<= n;
            this.bitsData |= n2 & -1 >>> 32 - n;
        }
        this.bitsData &= this.bitsMask;
    }

    public void resetBits(int n) {
        this.pushBits(n, 0);
    }

    public int toInteger() {
        return this.bitsData;
    }

    public int bitSize() {
        return this.bitSize;
    }

    public void reset(int n, int n2) {
        this.bitSize = n2;
        this.bitsData = n;
        this.bitsMask = -1 >>> 32 - this.bitSize;
    }

    public int popFrontBits(int n) {
        int n2 = this.bitsData;
        if (n > this.bitSize) {
            throw new BufferUnderflowException();
        }
        if (n < 32) {
            n2 <<= 32 - this.bitSize;
            n2 >>>= 32 - n;
        }
        this.bitsData <<= n;
        this.bitsData &= this.bitsMask;
        return n2;
    }

    public void discardBits(int n) {
        this.bitsData <<= n;
        this.bitsData &= this.bitsMask;
    }

    public boolean popFrontBoolean() {
        return this.popFrontBits(1) == 1;
    }

    public int popFrontByte() {
        return this.popFrontBits(8);
    }

    public byte[] popFrontBytes(int n) {
        int n2 = n < 4 ? n : 4;
        int n3 = n2 * 8;
        int n4 = this.bitsData >>> 32 - n3;
        byte[] byArray = new byte[n];
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            byArray[i2] = (byte)(n4 & 0xFF);
            n4 >>>= 8;
        }
        this.bitsData <<= n3;
        return byArray;
    }

    public int popFrontInt() {
        int n = this.bitsData & this.bitsMask;
        this.bitsData = 0;
        return n;
    }

    public int popFrontShort() {
        int n;
        if (this.bitSize <= 16) {
            n = this.bitsData & 0xFFFF;
            this.bitsData >>= 16;
        } else {
            n = this.bitsData >>> 16;
            this.bitsData <<= 16;
        }
        return n;
    }
}

