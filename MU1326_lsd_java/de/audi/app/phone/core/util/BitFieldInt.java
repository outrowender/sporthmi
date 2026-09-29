/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.util;

public class BitFieldInt {
    private int bitfield;

    public void setBit(int n) {
        this.bitfield |= 1 << n;
    }

    public void clearBit(int n) {
        this.bitfield &= ~(1 << n);
    }

    public boolean isBitSet(int n) {
        return (this.bitfield & 1 << n) != 0;
    }

    public void clearAllBits() {
        this.bitfield = 0;
    }

    public boolean areAllBitsCleared() {
        return this.bitfield == 0;
    }

    public int getAllBits() {
        return this.bitfield;
    }
}

