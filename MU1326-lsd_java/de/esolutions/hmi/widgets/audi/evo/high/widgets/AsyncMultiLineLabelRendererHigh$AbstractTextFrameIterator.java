/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

abstract class AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator {
    private String text;
    private int offset;

    public AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator(String string) {
        this.text = string;
    }

    public boolean isAtStart() {
        return this.offset == 0;
    }

    public boolean hasNext() {
        return this.offset < this.text.length();
    }

    public String next() {
        if (!this.hasNext()) {
            return null;
        }
        int n = (int)Math.min((long)this.text.length(), (long)this.offset + (long)this.getFrameSize());
        String string = this.text.substring(this.offset, n);
        this.offset = n;
        return string;
    }

    public String getText() {
        return this.text;
    }

    public int getOffset() {
        return this.offset;
    }

    protected abstract int getFrameSize() {
    }
}

