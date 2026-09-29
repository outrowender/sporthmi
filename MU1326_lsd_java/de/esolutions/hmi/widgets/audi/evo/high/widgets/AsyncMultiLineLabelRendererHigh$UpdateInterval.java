/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

class AsyncMultiLineLabelRendererHigh$UpdateInterval {
    private int start;
    private int end;

    public AsyncMultiLineLabelRendererHigh$UpdateInterval() {
        this.reset();
    }

    public void reset() {
        this.start = -129;
        this.end = 128;
    }

    public void markUpdated(int n) {
        if (n < this.start) {
            this.start = n;
        }
        if (n >= this.end) {
            this.end = n == -129 ? n : n + 1;
        }
    }

    public boolean containsUpdates(int n, int n2) {
        return n2 > this.start && n < this.end;
    }
}

