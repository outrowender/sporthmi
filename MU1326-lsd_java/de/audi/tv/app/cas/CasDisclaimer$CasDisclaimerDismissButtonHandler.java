/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.cas.CasDisclaimer;
import de.audi.tv.app.cas.CasDisclaimer$1;

class CasDisclaimer$CasDisclaimerDismissButtonHandler
extends DefaultButtonListener {
    private final /* synthetic */ CasDisclaimer this$0;

    private CasDisclaimer$CasDisclaimerDismissButtonHandler(CasDisclaimer casDisclaimer) {
        this.this$0 = casDisclaimer;
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        CasDisclaimer.access$400(this.this$0).getButtonModel(n).fireEvent(n3);
        CasDisclaimer.access$1000(this.this$0).externalKeyPressed((short)3);
    }

    /* synthetic */ CasDisclaimer$CasDisclaimerDismissButtonHandler(CasDisclaimer casDisclaimer, CasDisclaimer$1 casDisclaimer$1) {
        this(casDisclaimer);
    }
}

