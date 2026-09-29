/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

public class BitState {
    private int rgState = 0;

    public boolean isValid(int n, int n2) {
        return true;
    }

    public void add(int n) {
        if (this.isValid(this.rgState, this.rgState | n)) {
            this.rgState |= n;
        }
    }

    public void remove(int n) {
        if (this.isValid(this.rgState, this.rgState & ~n)) {
            this.rgState &= ~n;
        }
    }

    public void set(int n) {
        if (this.isValid(this.rgState, n)) {
            this.rgState = n;
        }
    }

    public boolean has(int n) {
        return (this.rgState & n) > 0;
    }

    public boolean is(int n) {
        return this.rgState == n;
    }

    public String toString() {
        return Integer.toBinaryString(this.rgState);
    }
}

