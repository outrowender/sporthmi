/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.diag;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.diag.DiagnosisDSIHandler;

class DiagnosisDSIHandler$1
implements TimerListener {
    private final /* synthetic */ int val$routine;
    private final /* synthetic */ DiagnosisDSIHandler this$0;

    DiagnosisDSIHandler$1(DiagnosisDSIHandler diagnosisDSIHandler, int n) {
        this.this$0 = diagnosisDSIHandler;
        this.val$routine = n;
    }

    @Override
    public void fireTimer(Timer timer) {
        DiagnosisDSIHandler.access$000(this.this$0).log(-2137614336, "Timer::resultRoutine # msgId=0 # routine=%2", (long)this.val$routine);
        if (this.val$routine == 0) {
            DiagnosisDSIHandler.access$102(this.this$0, false);
        } else if (this.val$routine == 1) {
            DiagnosisDSIHandler.access$202(this.this$0, false);
        }
        DiagnosisDSIHandler.access$300(this.this$0).resultRoutine(0, this.val$routine, 3, 2, 0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

