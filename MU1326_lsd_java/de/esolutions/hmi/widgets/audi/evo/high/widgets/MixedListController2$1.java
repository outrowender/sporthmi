/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListController2;

class MixedListController2$1
implements TimerListener {
    private final /* synthetic */ MixedListController2 this$0;

    MixedListController2$1(MixedListController2 mixedListController2) {
        this.this$0 = mixedListController2;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.processModelUpdateEvent(MixedListController2.access$000(this.this$0), this.this$0.newFormatIDs);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

