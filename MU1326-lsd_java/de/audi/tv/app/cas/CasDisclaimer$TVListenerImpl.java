/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

import de.audi.tv.app.cas.CasDisclaimer;
import de.audi.tv.app.cas.CasDisclaimer$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

class CasDisclaimer$TVListenerImpl
extends DefaultTVListener {
    private int currentCasStatus = -1;
    private final /* synthetic */ CasDisclaimer this$0;

    private CasDisclaimer$TVListenerImpl(CasDisclaimer casDisclaimer) {
        this.this$0 = casDisclaimer;
    }

    @Override
    public void updateSelectedService(ProgramInfo programInfo) {
        int n = programInfo.casStatus;
        if (this.currentCasStatus != n) {
            CasDisclaimer.access$400((CasDisclaimer)this.this$0).lcDSI.log(1078071040, "[CasDisclaimer.updateSelectedService] casStatus:0x%1", (long)n);
            if (n == 5) {
                CasDisclaimer.access$500(this.this$0, false);
            } else {
                CasDisclaimer.access$600(this.this$0);
            }
            this.currentCasStatus = n;
        }
    }

    @Override
    public void updateSelectedSource(int n) {
        CasDisclaimer.access$400((CasDisclaimer)this.this$0).lcDSI.log(1078071040, "[CasDisclaimer.updateSelectedSource] selectedSource: %3, casDiscActive: %1, isAvActive %2", (Object)CasDisclaimer.access$700(this.this$0), (Object)CasDisclaimer.access$800(this.this$0), (long)n);
        if (!CasDisclaimer.access$800(this.this$0) && CasDisclaimer.access$700(this.this$0)) {
            CasDisclaimer.access$500(this.this$0, true);
        }
    }

    @Override
    public void updateTerminalMode(int n, int n2) {
        CasDisclaimer.access$400((CasDisclaimer)this.this$0).lcDSI.log(1078071040, "[CasDisclaimer.updateTerminalMode] tm: 0x%3, casDiscActive: %1, isAvActive %2, isEnergySavingModeActive %4", (Object)CasDisclaimer.access$700(this.this$0), (Object)CasDisclaimer.access$800(this.this$0), (Object)new Integer(n), (Object)CasDisclaimer.access$900(this.this$0));
        if (!CasDisclaimer.access$900(this.this$0) && !CasDisclaimer.access$800(this.this$0) && CasDisclaimer.access$700(this.this$0) && n != 12) {
            CasDisclaimer.access$500(this.this$0, true);
        }
    }

    @Override
    public void updateTunerState(int n) {
        if (n == 0 && CasDisclaimer.access$700(this.this$0)) {
            CasDisclaimer.access$600(this.this$0);
            this.currentCasStatus = -1;
        }
    }

    /* synthetic */ CasDisclaimer$TVListenerImpl(CasDisclaimer casDisclaimer, CasDisclaimer$1 casDisclaimer$1) {
        this(casDisclaimer);
    }
}

