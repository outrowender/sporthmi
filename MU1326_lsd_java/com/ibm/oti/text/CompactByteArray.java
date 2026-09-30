/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.text.Utility;
import com.ibm.oti.util.Msg;
import java.lang.reflect.Array;

public final class CompactByteArray
implements Cloneable {
    public static final int UNICODECOUNT = 65536;
    private static final int BLOCKSHIFT = 7;
    private static final int BLOCKCOUNT = 128;
    private static final int INDEXSHIFT = 9;
    private static final int INDEXCOUNT = 512;
    private static final int BLOCKMASK = 127;
    private byte[] values;
    private short[] indices;
    private boolean isCompact;
    private int[] hashes;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    public CompactByteArray() {
        this(0);
    }

    public CompactByteArray(byte by) {
        this.values = new byte[65536];
        this.indices = new short[512];
        this.hashes = new int[512];
        int n = 0;
        while (n < 65536) {
            this.values[n] = by;
            ++n;
        }
        n = 0;
        while (n < 512) {
            this.indices[n] = (short)(n << 7);
            this.hashes[n] = 0;
            ++n;
        }
        this.isCompact = false;
    }

    public CompactByteArray(short[] sArray, byte[] byArray) {
        if (sArray.length != 512) {
            throw new IllegalArgumentException(Msg.getString("K0013"));
        }
        int n = 0;
        while (n < 512) {
            short s = sArray[n];
            if (s < 0 || s >= byArray.length + 128) {
                throw new IllegalArgumentException(Msg.getString("K0013"));
            }
            ++n;
        }
        this.indices = sArray;
        this.values = byArray;
        this.isCompact = true;
    }

    public CompactByteArray(String string, String string2) {
        this(Utility.RLEStringToShortArray(string), Utility.RLEStringToByteArray(string2));
    }

    public byte elementAt(char c2) {
        return this.values[(this.indices[c2 >> 7] & 0xFFFF) + (c2 & 0x7F)];
    }

    public void setElementAt(char c2, byte by) {
        if (this.isCompact) {
            this.expand();
        }
        this.values[c2] = by;
        this.touchBlock(c2 >> 7, by);
    }

    public void setElementAt(char n, char c2, byte by) {
        if (this.isCompact) {
            this.expand();
        }
        int n2 = n;
        while (n2 <= c2) {
            this.values[n2] = by;
            this.touchBlock(n2 >> 7, by);
            ++n2;
        }
    }

    public void compact() {
        if (!this.isCompact) {
            int n = 0;
            int n2 = 0;
            int n3 = -1;
            int n4 = 0;
            while (n4 < this.indices.length) {
                this.indices[n4] = -1;
                boolean bl = this.blockTouched(n4);
                if (!bl && n3 != -1) {
                    this.indices[n4] = n3;
                } else {
                    int n5 = 0;
                    int n6 = 0;
                    n6 = 0;
                    while (n6 < n) {
                        if (this.hashes[n4] == this.hashes[n6] && CompactByteArray.arrayRegionMatches(this.values, n2, this.values, n5, 128)) {
                            this.indices[n4] = (short)n5;
                            break;
                        }
                        ++n6;
                        n5 += 128;
                    }
                    if (this.indices[n4] == -1) {
                        System.arraycopy((Object)this.values, n2, (Object)this.values, n5, 128);
                        this.indices[n4] = (short)n5;
                        this.hashes[n6] = this.hashes[n4];
                        ++n;
                        if (!bl) {
                            n3 = (short)n5;
                        }
                    }
                }
                ++n4;
                n2 += 128;
            }
            n4 = n * 128;
            this.values = (byte[])Utility.resizeArray(n4, this.values, 0, n4);
            this.isCompact = true;
            this.hashes = null;
        }
    }

    static final boolean arrayRegionMatches(byte[] byArray, int n, byte[] byArray2, int n2, int n3) {
        int n4 = n + n3;
        int n5 = n2 - n;
        int n6 = n;
        while (n6 < n4) {
            if (byArray[n6] != byArray2[n6 + n5]) {
                return false;
            }
            ++n6;
        }
        return true;
    }

    private final void touchBlock(int n, int n2) {
        this.hashes[n] = this.hashes[n] + (n2 << 1) | 1;
    }

    private final boolean blockTouched(int n) {
        return this.hashes[n] != 0;
    }

    public short[] getIndexArray() {
        return this.indices;
    }

    public byte[] getStringArray() {
        return this.values;
    }

    public Object clone() {
        try {
            CompactByteArray compactByteArray = (CompactByteArray)super.clone();
            compactByteArray.values = (byte[])this.values.clone();
            compactByteArray.indices = (short[])this.indices.clone();
            if (this.hashes != null) {
                compactByteArray.hashes = (int[])this.hashes.clone();
            }
            return compactByteArray;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        CompactByteArray compactByteArray = (CompactByteArray)object;
        int n = 0;
        while (n < 65536) {
            if (this.elementAt((char)n) != compactByteArray.elementAt((char)n)) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int hashCode() {
        int n = 0;
        int n2 = Math.min(3, this.values.length / 16);
        int n3 = 0;
        while (n3 < this.values.length) {
            n = n * 37 + this.values[n3];
            n3 += n2;
        }
        return n;
    }

    private void expand() {
        if (this.isCompact) {
            this.hashes = (int[])Array.newInstance(Integer.TYPE, 512);
            byte[] byArray = (byte[])Array.newInstance(Byte.TYPE, 65536);
            int n = 0;
            while (n < 65536) {
                byte by;
                byArray[n] = by = this.elementAt((char)n);
                this.touchBlock(n >> 7, by);
                ++n;
            }
            n = 0;
            while (n < 512) {
                this.indices[n] = (short)(n << 7);
                ++n;
            }
            this.values = null;
            this.values = byArray;
            this.isCompact = false;
        }
    }

    private byte[] getArray() {
        return this.values;
    }
}

