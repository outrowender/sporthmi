/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.io.OutputStream;

public class SHAOutputStream
extends OutputStream
implements Cloneable {
    private int[] HConstants;
    private int[] WArray;
    private byte[] MArray;
    private long bytesProcessed;
    private int bytesToProcess;
    private byte[] oneByte = new byte[1];
    private static final int K0_19 = 1518500249;
    private static final int K20_39 = 1859775393;
    private static final int K40_59 = -1894007588;
    private static final int K60_79 = -899497514;
    private static final int H0 = 1732584193;
    private static final int H1 = -271733879;
    private static final int H2 = -1732584194;
    private static final int H3 = 271733878;
    private static final int H4 = -1009589776;
    private static final int HConstantsSize = 5;
    private static final int HashSizeInBytes = 20;
    private static final int BlockSizeInBytes = 64;
    private static final int WArraySize = 80;

    public SHAOutputStream() {
        this.initialize();
        this.reset();
    }

    public SHAOutputStream(byte[] byArray) {
        this();
        if (byArray.length < 20) {
            throw new IllegalArgumentException();
        }
        int n = 0;
        while (n < 4) {
            this.HConstants[n] = 0;
            int n2 = 0;
            while (n2 < 4) {
                int n3 = n;
                this.HConstants[n3] = this.HConstants[n3] + ((byArray[4 * n + n2] & 0xFF) << 8 * (3 - n2));
                ++n2;
            }
            ++n;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        SHAOutputStream sHAOutputStream = (SHAOutputStream)super.clone();
        sHAOutputStream.HConstants = (int[])this.HConstants.clone();
        sHAOutputStream.WArray = (int[])this.WArray.clone();
        sHAOutputStream.MArray = (byte[])this.MArray.clone();
        sHAOutputStream.oneByte = (byte[])this.oneByte.clone();
        return sHAOutputStream;
    }

    private void copyToInternalBuffer(byte[] byArray, int n, int n2) {
        int n3 = n;
        int n4 = this.bytesToProcess;
        while (n4 < this.bytesToProcess + n2) {
            this.MArray[n4] = byArray[n3];
            ++n3;
            ++n4;
        }
        this.bytesToProcess += n2;
    }

    public int[] getHash() {
        this.padBuffer();
        this.processBuffer();
        int[] nArray = (int[])this.HConstants.clone();
        this.reset();
        return nArray;
    }

    public byte[] getHashAsBytes() {
        byte[] byArray = new byte[20];
        this.padBuffer();
        this.processBuffer();
        int n = 0;
        while (n < 5) {
            byArray[n * 4] = (byte)(this.HConstants[n] >>> 24 & 0xFF);
            byArray[n * 4 + 1] = (byte)(this.HConstants[n] >>> 16 & 0xFF);
            byArray[n * 4 + 2] = (byte)(this.HConstants[n] >>> 8 & 0xFF);
            byArray[n * 4 + 3] = (byte)(this.HConstants[n] & 0xFF);
            ++n;
        }
        this.reset();
        return byArray;
    }

    public byte[] getHashAsBytes(boolean bl) {
        byte[] byArray = new byte[20];
        if (bl) {
            this.padBuffer();
            this.processBuffer();
        }
        int n = 0;
        while (n < 5) {
            byArray[n * 4] = (byte)(this.HConstants[n] >>> 24 & 0xFF);
            byArray[n * 4 + 1] = (byte)(this.HConstants[n] >>> 16 & 0xFF);
            byArray[n * 4 + 2] = (byte)(this.HConstants[n] >>> 8 & 0xFF);
            byArray[n * 4 + 3] = (byte)(this.HConstants[n] & 0xFF);
            ++n;
        }
        this.reset();
        return byArray;
    }

    private void initialize() {
        this.HConstants = new int[5];
        this.MArray = new byte[64];
        this.WArray = new int[80];
    }

    private void padBuffer() {
        this.MArray[this.bytesToProcess] = -128;
        int n = this.bytesToProcess + 1;
        while (n < 64) {
            this.MArray[n] = 0;
            ++n;
        }
        long l = ((long)this.bytesToProcess + this.bytesProcessed) * 8L;
        if (this.bytesToProcess + 9 > 64) {
            this.processBuffer();
            n = 0;
            while (n < 64) {
                this.MArray[n] = 0;
                ++n;
            }
        }
        n = 1;
        while (n < 9) {
            this.MArray[64 - n] = (byte)(l & 0xFFL);
            l >>>= 8;
            ++n;
        }
    }

    private void processBuffer() {
        int n;
        int n2 = 0;
        while (n2 <= 15) {
            this.WArray[n2] = (this.MArray[4 * n2] & 0xFF) << 24 | (this.MArray[4 * n2 + 1] & 0xFF) << 16 | (this.MArray[4 * n2 + 2] & 0xFF) << 8 | this.MArray[4 * n2 + 3] & 0xFF;
            ++n2;
        }
        n2 = 16;
        while (n2 <= 79) {
            n = this.WArray[n2 - 3] ^ this.WArray[n2 - 8] ^ this.WArray[n2 - 14] ^ this.WArray[n2 - 16];
            this.WArray[n2] = n = n << 1 | n >>> 31;
            ++n2;
        }
        int n3 = this.HConstants[0];
        int n4 = this.HConstants[1];
        int n5 = this.HConstants[2];
        int n6 = this.HConstants[3];
        int n7 = this.HConstants[4];
        n2 = 0;
        while (n2 <= 19) {
            n = n3 << 5 | n3 >>> 27;
            n = n + n7 + this.WArray[n2] + 1518500249;
            n7 = n6;
            n6 = n5;
            n5 = n4 << 30 | n4 >>> 2;
            n4 = n3;
            n3 = n += n4 & n5 | ~n4 & n6;
            ++n2;
        }
        n2 = 20;
        while (n2 <= 39) {
            n = n3 << 5 | n3 >>> 27;
            n = n + n7 + this.WArray[n2] + 1859775393;
            n7 = n6;
            n6 = n5;
            n5 = n4 << 30 | n4 >>> 2;
            n4 = n3;
            n3 = n += n4 ^ n5 ^ n6;
            ++n2;
        }
        n2 = 40;
        while (n2 <= 59) {
            n = n3 << 5 | n3 >>> 27;
            n = n + n7 + this.WArray[n2] + -1894007588;
            n7 = n6;
            n6 = n5;
            n5 = n4 << 30 | n4 >>> 2;
            n4 = n3;
            n3 = n += n4 & n5 | n4 & n6 | n5 & n6;
            ++n2;
        }
        n2 = 60;
        while (n2 <= 79) {
            n = n3 << 5 | n3 >>> 27;
            n = n + n7 + this.WArray[n2] + -899497514;
            n7 = n6;
            n6 = n5;
            n5 = n4 << 30 | n4 >>> 2;
            n4 = n3;
            n3 = n += n4 ^ n5 ^ n6;
            ++n2;
        }
        this.HConstants[0] = this.HConstants[0] + n3;
        this.HConstants[1] = this.HConstants[1] + n4;
        this.HConstants[2] = this.HConstants[2] + n5;
        this.HConstants[3] = this.HConstants[3] + n6;
        this.HConstants[4] = this.HConstants[4] + n7;
        this.bytesProcessed += 64L;
        this.bytesToProcess = 0;
    }

    public void reset() {
        this.HConstants[0] = 1732584193;
        this.HConstants[1] = -271733879;
        this.HConstants[2] = -1732584194;
        this.HConstants[3] = 271733878;
        this.HConstants[4] = -1009589776;
        this.bytesProcessed = 0L;
        this.bytesToProcess = 0;
    }

    public String toString() {
        return String.valueOf(this.getClass().getName()) + ':' + SHAOutputStream.toStringBlock(this.getHashAsBytes());
    }

    private static String toStringBlock(byte[] byArray) {
        return SHAOutputStream.toStringBlock(byArray, 0, byArray.length);
    }

    private static String toStringBlock(byte[] byArray, int n, int n2) {
        String string = "0123456789ABCDEF";
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = n;
        while (n3 < n + n2) {
            stringBuffer.append(string.charAt(byArray[n3] >>> 4 & 0xF));
            stringBuffer.append(string.charAt(byArray[n3] & 0xF));
            ++n3;
        }
        return "[" + stringBuffer + "]";
    }

    public void write(byte[] byArray, int n, int n2) {
        int n3 = 64 - this.bytesToProcess;
        if (n2 < n3) {
            this.copyToInternalBuffer(byArray, n, n2);
            return;
        }
        this.copyToInternalBuffer(byArray, n, n3);
        int n4 = n2 - n3;
        this.processBuffer();
        int n5 = n + n3;
        while (n4 >= 64) {
            this.copyToInternalBuffer(byArray, n5, 64);
            n4 -= 64;
            this.processBuffer();
            n5 += 64;
        }
        if (n4 > 0) {
            this.copyToInternalBuffer(byArray, n5, n4);
        }
    }

    public void write(int n) {
        this.oneByte[0] = (byte)n;
        this.write(this.oneByte, 0, 1);
    }
}

