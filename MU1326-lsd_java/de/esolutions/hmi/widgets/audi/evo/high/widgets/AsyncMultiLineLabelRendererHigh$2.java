/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator;

class AsyncMultiLineLabelRendererHigh$2
extends AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator {
    private final /* synthetic */ int val$wrapMode;
    private final /* synthetic */ AsyncMultiLineLabelRendererHigh this$0;

    AsyncMultiLineLabelRendererHigh$2(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh, String string, int n) {
        this.this$0 = asyncMultiLineLabelRendererHigh;
        this.val$wrapMode = n;
        super(string);
    }

    @Override
    protected int getFrameSize() {
        return AsyncMultiLineLabelRendererHigh.access$800(this.this$0, this.val$wrapMode);
    }
}

