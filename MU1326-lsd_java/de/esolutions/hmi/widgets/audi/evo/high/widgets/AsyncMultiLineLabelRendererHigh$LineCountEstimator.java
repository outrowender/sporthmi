/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

class AsyncMultiLineLabelRendererHigh$LineCountEstimator {
    private int totalCharCount;
    private int estimatedLineCount;
    private double minimumChangeRatio;

    public AsyncMultiLineLabelRendererHigh$LineCountEstimator(int n, double d2) {
        this.totalCharCount = n;
        this.minimumChangeRatio = d2;
        this.estimatedLineCount = Math.max(1, n / 90);
    }

    public void update(int n, int n2) {
        if (n2 >= this.totalCharCount) {
            this.estimatedLineCount = n;
            return;
        }
        if (n < 3) {
            this.estimatedLineCount = Math.max(this.estimatedLineCount, n);
            return;
        }
        double d2 = (double)n2 / (double)n;
        int n3 = this.totalCharCount - n2;
        int n4 = (int)((double)n3 / d2);
        int n5 = n + n4;
        int n6 = (int)((double)this.estimatedLineCount * this.minimumChangeRatio);
        if (Math.abs(n5 - this.estimatedLineCount) < n6) {
            return;
        }
        this.estimatedLineCount = n5;
    }

    public int getEstimatedLineCount() {
        return this.estimatedLineCount;
    }
}

