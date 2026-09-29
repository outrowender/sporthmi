/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

import de.audi.tv.app.cas.CasDisclaimer;
import de.audi.tv.app.cas.CasDisclaimer$1;
import de.audi.tv.app.dsi.DSICallListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

class CasDisclaimer$SelectionListener
extends DSICallListener {
    private final /* synthetic */ CasDisclaimer this$0;

    private CasDisclaimer$SelectionListener(CasDisclaimer casDisclaimer) {
        this.this$0 = casDisclaimer;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        CasDisclaimer.access$400(this.this$0).getChoiceModel(-1834211584).setValue(0);
    }

    @Override
    public void selectNextService(int n) {
        CasDisclaimer.access$400(this.this$0).getChoiceModel(-1834211584).setValue(0);
    }

    @Override
    public void switchSource(int n, boolean bl) {
        CasDisclaimer.access$802(this.this$0, n == 1);
    }

    /* synthetic */ CasDisclaimer$SelectionListener(CasDisclaimer casDisclaimer, CasDisclaimer$1 casDisclaimer$1) {
        this(casDisclaimer);
    }
}

