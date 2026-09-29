/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search;

import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class AbstractGuiSearchHandler$1
implements TimerListener {
    private final /* synthetic */ AbstractGuiSearchHandler this$0;

    AbstractGuiSearchHandler$1(AbstractGuiSearchHandler abstractGuiSearchHandler) {
        this.this$0 = abstractGuiSearchHandler;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.this$0.lcFrequent != null) {
            this.this$0.lcFrequent.log(-2137614336, "%1#fireTimer flushSearchResultBuffer", (Object)(AbstractGuiSearchHandler.class$de$audi$atip$search$AbstractGuiSearchHandler == null ? (AbstractGuiSearchHandler.class$de$audi$atip$search$AbstractGuiSearchHandler = AbstractGuiSearchHandler.class$("de.audi.atip.search.AbstractGuiSearchHandler")) : AbstractGuiSearchHandler.class$de$audi$atip$search$AbstractGuiSearchHandler).getName());
        }
        this.this$0.flushSearchResultBuffer();
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

