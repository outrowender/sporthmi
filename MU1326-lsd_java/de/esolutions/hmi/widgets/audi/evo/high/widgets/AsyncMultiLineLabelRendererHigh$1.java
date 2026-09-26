/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractPage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator;

class AsyncMultiLineLabelRendererHigh$1
extends AsyncMultiLineLabelRendererHigh$AbstractPage {
    private int targetWidth;
    private final /* synthetic */ int val$width;
    private final /* synthetic */ int val$pageWrapMode;
    private final /* synthetic */ boolean val$waitForController;
    private final /* synthetic */ boolean val$isDisplayPage;
    private final /* synthetic */ AsyncMultiLineLabelRendererHigh this$0;

    AsyncMultiLineLabelRendererHigh$1(AsyncMultiLineLabelRendererHigh asyncMultiLineLabelRendererHigh, AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator, boolean bl, int n, double d2, int n2, int n3, boolean bl2, boolean bl3) {
        this.this$0 = asyncMultiLineLabelRendererHigh;
        this.val$width = n2;
        this.val$pageWrapMode = n3;
        this.val$waitForController = bl2;
        this.val$isDisplayPage = bl3;
        super(asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator, bl, n, d2);
        this.targetWidth = this.val$width;
    }

    @Override
    protected void mergeFrame(String string) {
        string = string.replace('\r', ' ');
        if (this.targetWidth <= 0) {
            this.targetWidth = AsyncMultiLineLabelRendererHigh.access$300(this.this$0) ? AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getWidth() : this.val$width;
            AsyncMultiLineLabelRendererHigh.access$402(this.this$0, this.targetWidth);
        }
        if (this.targetWidth > 0) {
            AsyncMultiLineLabelRendererHigh.access$500(this.this$0).put(this.targetWidth, this);
        }
        String[] stringArray = AsyncMultiLineLabelRendererHigh.access$600(this.this$0).wrapText(string, this.targetWidth, this.targetWidth, this.val$pageWrapMode);
        for (int i2 = 0; i2 < stringArray.length && !this.isFinished(); ++i2) {
            this.addLine(AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getOrientaionHintedText(stringArray[i2]));
        }
    }

    @Override
    protected boolean isReady() {
        return !this.val$waitForController || AsyncMultiLineLabelRendererHigh.access$300(this.this$0);
    }

    @Override
    protected int getMinLines() {
        return AsyncMultiLineLabelRendererHigh.access$000(this.this$0).getMinLines();
    }

    @Override
    protected void onLineChanged(int n) {
        if (this.val$isDisplayPage) {
            AsyncMultiLineLabelRendererHigh.access$700(this.this$0).onLineChanged(n);
        }
    }

    @Override
    protected int getLineWidth(String string) {
        return this.this$0.getEALManager().getTextWidth(string, this.this$0.getInheritedFont());
    }
}

