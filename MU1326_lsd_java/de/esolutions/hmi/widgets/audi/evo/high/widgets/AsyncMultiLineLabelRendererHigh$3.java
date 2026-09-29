/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractPage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator;
import java.util.List;

class AsyncMultiLineLabelRendererHigh$3
extends AsyncMultiLineLabelRendererHigh$AbstractPage {
    private final /* synthetic */ boolean val$noWrapPageIsDisplayed;
    private final /* synthetic */ AsyncMultiLineLabelRendererHigh this$0;

    AsyncMultiLineLabelRendererHigh$3(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh, AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator, boolean bl, int n, double d2, boolean bl2) {
        this.this$0 = asyncMultiLineLabelRendererHigh;
        this.val$noWrapPageIsDisplayed = bl2;
        super(asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator, bl, n, d2);
    }

    @Override
    protected void mergeFrame(String string) {
        string = string.replace('\r', ' ');
        List list = AsyncMultiLineLabelRendererHigh.access$600(this.this$0).wrapOnLineBreak(string, '\n');
        for (int i2 = 0; i2 < list.size() && !this.isFinished(); ++i2) {
            this.addLine(AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getOrientaionHintedText((String)list.get(i2)));
        }
    }

    @Override
    protected boolean isReady() {
        return true;
    }

    @Override
    protected int getMinLines() {
        return AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getMinLines();
    }

    @Override
    protected void onLineChanged(int n) {
        if (this.val$noWrapPageIsDisplayed) {
            AsyncMultiLineLabelRendererHigh.access$700(this.this$0).onLineChanged(n);
        }
    }

    @Override
    protected int getLineWidth(String string) {
        return this.this$0.getEALManager().getTextWidth(string, this.this$0.getInheritedFont());
    }
}

