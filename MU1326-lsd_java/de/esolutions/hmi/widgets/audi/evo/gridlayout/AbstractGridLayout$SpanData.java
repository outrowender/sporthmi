/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

public class AbstractGridLayout$SpanData {
    public int start;
    public int span;
    public int pref;
    public int min;
    public int max;

    public int getEnd() {
        return this.start + this.span - 1;
    }

    public boolean contains(int n) {
        return this.start <= n && this.getEnd() >= n;
    }
}

