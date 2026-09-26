/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh;

public class HighlightingLabelRendererHigh$LayoutSection {
    int start = 0;
    int end = 0;
    boolean highlighted = false;
    private final /* synthetic */ HighlightingLabelRendererHigh this$0;

    public HighlightingLabelRendererHigh$LayoutSection(HighlightingLabelRendererHigh highlightingLabelRendererHigh, int n, int n2, boolean bl) {
        this.this$0 = highlightingLabelRendererHigh;
        this.start = n;
        this.end = n2;
        this.highlighted = bl;
    }

    public HighlightingLabelRendererHigh$LayoutSection(HighlightingLabelRendererHigh highlightingLabelRendererHigh) {
        this(highlightingLabelRendererHigh, 0, 0, false);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[").append(this.start).append("-").append(this.end).append(",highlighted:").append(this.highlighted).append("]");
        return buffer.toString();
    }
}

