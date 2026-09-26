/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestSearchTimerAsia;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class IntelliDestSearchTimerAsia$1
implements TimerListener {
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ IntelliDestSearchTimerAsia this$0;

    IntelliDestSearchTimerAsia$1(IntelliDestSearchTimerAsia intelliDestSearchTimerAsia, LogChannel logChannel) {
        this.this$0 = intelliDestSearchTimerAsia;
        this.val$logChannel = logChannel;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.val$logChannel != null) {
            this.val$logChannel.log(-2137614336, "%1#fireTimer() -> displayOnlineSearchButton()", (Object)(IntelliDestSearchTimerAsia.class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia == null ? (IntelliDestSearchTimerAsia.class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia = IntelliDestSearchTimerAsia.class$("de.audi.app.navi.evo.search.IntelliDestSearchTimerAsia")) : IntelliDestSearchTimerAsia.class$de$audi$app$navi$evo$search$IntelliDestSearchTimerAsia).getName());
        }
        IntelliDestSearchTimerAsia.access$000(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

