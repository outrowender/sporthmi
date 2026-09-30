/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.text.Utility;
import com.ibm.oti.util.Msg;

public final class CompactIntArray
implements Cloneable {
    public static final int UNICODECOUNT = 65536;
    private static final int BLOCKSHIFT = 7;
    private static final int BLOCKCOUNT = 128;
    private static final int INDEXSHIFT = 9;
    private static final int INDEXCOUNT = 512;
    private static final int BLOCKMASK = 127;
    private int[] values;
    private short[] indices;
    private boolean isCompact;
    private int[] hashes;

    public CompactIntArray() {
        this(0);
    }

    public CompactIntArray(int n) {
        this.values = new int[65536];
        this.indices = new short[512];
        this.hashes = new int[512];
        int n2 = 0;
        while (n2 < 65536) {
            this.values[n2] = n;
            ++n2;
        }
        n2 = 0;
        while (n2 < 512) {
            this.indices[n2] = (short)(n2 << 7);
            this.hashes[n2] = 0;
            ++n2;
        }
        this.isCompact = false;
    }

    public CompactIntArray(short[] sArray, int[] nArray) {
        if (sArray.length != 512) {
            throw new IllegalArgumentException(Msg.getString("K0013"));
        }
        int n = 0;
        while (n < 512) {
            short s = sArray[n];
            if (s < 0 || s >= nArray.length + 128) {
                throw new IllegalArgumentException(Msg.getString("K0013"));
            }
            ++n;
        }
        this.indices = sArray;
        this.values = nArray;
        this.isCompact = true;
    }

    public int elementAt(char c2) {
        return this.values[(this.indices[c2 >> 7] & 0xFFFF) + (c2 & 0x7F)];
    }

    public void setElementAt(char c2, int n) {
        if (this.isCompact) {
            this.expand();
        }
        this.values[c2] = n;
        this.touchBlock(c2 >> 7, n);
    }

    public void setElementAt(char n, char c2, int n2) {
        if (this.isCompact) {
            this.expand();
        }
        int n3 = n;
        while (n3 <= c2) {
            this.values[n3] = n2;
            this.touchBlock(n3 >> 7, n2);
            ++n3;
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
                        if (this.hashes[n4] == this.hashes[n6] && Utility.arrayRegionMatches(this.values, n2, this.values, n5, 128)) {
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
            int[] nArray = new int[n4];
            System.arraycopy((Object)this.values, 0, (Object)nArray, 0, n4);
            this.values = nArray;
            this.isCompact = true;
            this.hashes = null;
        }
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

    public int[] getStringArray() {
        return this.values;
    }

    public Object clone() {
        try {
            CompactIntArray compactIntArray = (CompactIntArray)super.clone();
            compactIntArray.values = (int[])this.values.clone();
            compactIntArray.indices = (short[])this.indices.clone();
            if (this.hashes != null) {
                compactIntArray.hashes = (int[])this.hashes.clone();
            }
            return compactIntArray;
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
        CompactIntArray compactIntArray = (CompactIntArray)object;
        int n = 0;
        while (n < 65536) {
            if (this.elementAt((char)n) != compactIntArray.elementAt((char)n)) {
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
            this.hashes = new int[512];
            int[] nArray = new int[65536];
            int n = 0;
            while (n < 65536) {
                int n2;
                nArray[n] = n2 = this.elementAt((char)n);
                this.touchBlock(n >> 7, n2);
                ++n;
            }
            n = 0;
            while (n < 512) {
                this.indices[n] = (short)(n << 7);
                ++n;
            }
            this.values = nArray;
            this.isCompact = false;
        }
    }
}

