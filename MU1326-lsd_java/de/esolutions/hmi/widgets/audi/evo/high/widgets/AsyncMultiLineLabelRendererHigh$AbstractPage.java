/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AsyncMultiLineLabelRendererHigh$LineCountEstimator;
import java.util.ArrayList;
import java.util.List;

abstract class AsyncMultiLineLabelRendererHigh$AbstractPage {
    private AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator iterator;
    private List lines;
    private AsyncMultiLineLabelRendererHigh$LineCountEstimator estimator;
    private int maxLineWidth;
    private int maxLines;
    private int lineCount;
    private boolean finished;
    private boolean forgetContent;
    private StringBuffer tempFrame;
    private String lastFrameLine;
    private String lastLine;

    public AsyncMultiLineLabelRendererHigh$AbstractPage(AsyncMultiLineLabelRendererHigh$AbstractTextFrameIterator asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator, boolean bl, int n, double d2) {
        this.maxLines = n < 1 ? -129 : n;
        this.iterator = asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator;
        this.tempFrame = new StringBuffer();
        this.lines = new ArrayList();
        this.estimator = new AsyncMultiLineLabelRendererHigh$LineCountEstimator(asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator.getText().length(), d2);
        this.finished = !asyncMultiLineLabelRendererHigh$AbstractTextFrameIterator.hasNext();
        this.forgetContent = bl;
        this.lastLine = "";
    }

    private static String addEllipsis(String string) {
        return new Buffer(string.length() + 1).append(string).append('\u2026').toString();
    }

    protected void addLine(String string) {
        if (this.finished) {
            return;
        }
        if (this.lineCount < this.maxLines) {
            if (!this.forgetContent) {
                this.lines.add(string);
            }
            this.lastLine = string;
            this.maxLineWidth = Math.max(this.maxLineWidth, this.getLineWidth(string));
            ++this.lineCount;
            this.onLineChanged(this.lineCount - 1);
        } else {
            string = AsyncMultiLineLabelRendererHigh$AbstractPage.addEllipsis(this.lastLine);
            int n = this.lineCount - 1;
            if (!this.lines.isEmpty()) {
                this.lines.remove(n);
                this.lines.add(string);
            }
            this.lastLine = string;
            this.maxLineWidth = Math.max(this.maxLineWidth, this.getLineWidth(string));
            this.onLineChanged(n);
            this.finished = true;
        }
        this.lastFrameLine = string;
    }

    public String getLine(int n) {
        if (n < 0 || n >= this.lines.size()) {
            return "";
        }
        return (String)this.lines.get(n);
    }

    public boolean isEmpty() {
        return this.lineCount == 0;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isAtStart() {
        return this.iterator.isAtStart() && this.iterator.hasNext();
    }

    public void update() {
        if (this.finished || !this.isReady()) {
            return;
        }
        if (!this.iterator.hasNext()) {
            this.finished = true;
            return;
        }
        String string = this.iterator.next();
        if (this.lastFrameLine != null) {
            this.tempFrame.replace(0, this.tempFrame.length(), this.lastFrameLine).append(string);
            string = this.tempFrame.toString();
            this.lastFrameLine = null;
            --this.lineCount;
            if (!this.forgetContent) {
                int n = this.lines.size() - 1;
                this.lines.remove(n);
                this.onLineChanged(n);
            }
        }
        this.mergeFrame(string);
        if (this.lastFrameLine != null && string.length() > 0 && string.charAt(string.length() - 1) == '\n') {
            this.lastFrameLine = null;
        }
        if (!this.finished && !this.iterator.hasNext()) {
            this.finished = true;
        }
        this.estimator.update(this.lineCount, this.finished ? this.iterator.getText().length() : this.iterator.getOffset());
    }

    public int getEstimatedLineCount() {
        return Math.max(this.getMinLines(), this.estimator.getEstimatedLineCount());
    }

    public int getWidth() {
        return this.maxLineWidth;
    }

    protected abstract boolean isReady() {
    }

    protected abstract void mergeFrame(String string) {
    }

    protected abstract int getMinLines() {
    }

    protected abstract void onLineChanged(int n) {
    }

    protected abstract int getLineWidth(String string) {
    }
}

