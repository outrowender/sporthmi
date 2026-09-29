/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.combi.bap.functionsync.CommandUpdateFunctions;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class CommandUpdateFunctions$1
implements TimerListener {
    private final /* synthetic */ CommandUpdateFunctions this$0;

    CommandUpdateFunctions$1(CommandUpdateFunctions commandUpdateFunctions) {
        this.this$0 = commandUpdateFunctions;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(CommandUpdateFunctions.access$000(this.this$0)) && !CommandUpdateFunctions.access$100(this.this$0)) {
            CommandUpdateFunctions.access$200(this.this$0).log(10000, "[CommandUpdateFunctions#fireTimer] [%1] TIMEOUT -> complete sync to avoid lock (pending functions: %1)", (Object)this.this$0.logPendingFunctions());
            CommandUpdateFunctions.access$300(this.this$0);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

