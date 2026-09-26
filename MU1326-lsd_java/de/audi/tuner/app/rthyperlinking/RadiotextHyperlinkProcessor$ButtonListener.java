/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor$1;

class RadiotextHyperlinkProcessor$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ RadiotextHyperlinkProcessor this$0;

    private RadiotextHyperlinkProcessor$ButtonListener(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        this.this$0 = radiotextHyperlinkProcessor;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (RadiotextHyperlinkProcessor.access$200(this.this$0) != null) {
            RadiotextHyperlinkProcessor.access$200(this.this$0).execute();
            RadiotextHyperlinkProcessor.access$300(this.this$0).getButtonModel(n).fireEvent(n3);
        }
    }

    /* synthetic */ RadiotextHyperlinkProcessor$ButtonListener(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, RadiotextHyperlinkProcessor$1 radiotextHyperlinkProcessor$1) {
        this(radiotextHyperlinkProcessor);
    }
}

