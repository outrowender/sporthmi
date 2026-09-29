/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.cas.CasDisclaimer;
import de.audi.tv.app.cas.CasDisclaimer$1;

class CasDisclaimer$TVEventListener
extends TVEventDefaultListener {
    private final /* synthetic */ CasDisclaimer this$0;

    private CasDisclaimer$TVEventListener(CasDisclaimer casDisclaimer) {
        this.this$0 = casDisclaimer;
    }

    @Override
    public void onAppActivated(int n) {
        CasDisclaimer.access$400((CasDisclaimer)this.this$0).lcDSI.log(1078071040, "[CasDisclaimer.onAppActivated] casDiscActive: %1 isAvActive: %2 isEnergySavingModeActive: %3", CasDisclaimer.access$700(this.this$0), CasDisclaimer.access$800(this.this$0), CasDisclaimer.access$900(this.this$0));
        if (!CasDisclaimer.access$900(this.this$0) && !CasDisclaimer.access$800(this.this$0) && CasDisclaimer.access$700(this.this$0)) {
            CasDisclaimer.access$500(this.this$0, true);
        }
    }

    @Override
    public void onEsmEntered() {
        CasDisclaimer.access$400((CasDisclaimer)this.this$0).lcDSI.log(1078071040, "[CasDisclaimer.onEsmEntered]");
        CasDisclaimer.access$902(this.this$0, true);
    }

    @Override
    public void onEsmLeft() {
        CasDisclaimer.access$400((CasDisclaimer)this.this$0).lcDSI.log(1078071040, "[CasDisclaimer.onEsmLeft] casDiscActive: %1 isAvActive: %2", CasDisclaimer.access$700(this.this$0), CasDisclaimer.access$800(this.this$0));
        CasDisclaimer.access$902(this.this$0, false);
        if (!CasDisclaimer.access$800(this.this$0) && CasDisclaimer.access$700(this.this$0)) {
            CasDisclaimer.access$500(this.this$0, true);
        }
    }

    /* synthetic */ CasDisclaimer$TVEventListener(CasDisclaimer casDisclaimer, CasDisclaimer$1 casDisclaimer$1) {
        this(casDisclaimer);
    }
}

