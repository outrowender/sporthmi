/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerMMICombi;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerMMICombi$1;

class PartialPopupManagerMMICombi$PopupCanceledJob
implements Runnable {
    private int popupID;
    private final /* synthetic */ PartialPopupManagerMMICombi this$0;

    private PartialPopupManagerMMICombi$PopupCanceledJob(PartialPopupManagerMMICombi partialPopupManagerMMICombi, int n) {
        this.this$0 = partialPopupManagerMMICombi;
        this.popupID = n;
    }

    @Override
    public void run() {
        this.this$0.hidePopup(this.popupID);
    }

    /* synthetic */ PartialPopupManagerMMICombi$PopupCanceledJob(PartialPopupManagerMMICombi partialPopupManagerMMICombi, int n, PartialPopupManagerMMICombi$1 partialPopupManagerMMICombi$1) {
        this(partialPopupManagerMMICombi, n);
    }
}

