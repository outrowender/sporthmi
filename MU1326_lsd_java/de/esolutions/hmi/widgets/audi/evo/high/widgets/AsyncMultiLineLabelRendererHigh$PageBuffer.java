/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractPage;

class AsyncMultiLineLabelRendererHigh$PageBuffer {
    private AsyncMultiLineLabelRendererHigh$AbstractPage[] pages;
    private int[] widths;
    private int nextIndex;

    public AsyncMultiLineLabelRendererHigh$PageBuffer(int n) {
        this.pages = new AsyncMultiLineLabelRendererHigh$AbstractPage[n];
        this.widths = new int[n];
    }

    private int findIndex(int n) {
        for (int i2 = 0; i2 < this.widths.length; ++i2) {
            if (this.widths[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    public void put(int n, AsyncMultiLineLabelRendererHigh$AbstractPage asyncMultiLineLabelRendererHigh$AbstractPage) {
        int n2 = this.findIndex(n);
        if (n2 < 0) {
            n2 = this.nextIndex;
            this.nextIndex = (n2 + 1) % this.widths.length;
        }
        this.pages[n2] = asyncMultiLineLabelRendererHigh$AbstractPage;
        this.widths[n2] = n;
    }

    public AsyncMultiLineLabelRendererHigh$AbstractPage get(int n) {
        int n2 = this.findIndex(n);
        return n2 < 0 ? null : this.pages[n2];
    }

    public void clear() {
        for (int i2 = 0; i2 < this.widths.length; ++i2) {
            this.pages[i2] = null;
            this.widths[i2] = 0;
        }
    }
}

