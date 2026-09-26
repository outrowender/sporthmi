/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupControllerMMICombi;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerMMICombi;
import de.esolutions.hmi.widgets.audi.evo.high.PartialPopupManagerMMICombi$1;

class PartialPopupManagerMMICombi$OptionSelectedJob
implements Runnable {
    private int popupID;
    private int optionID;
    private final /* synthetic */ PartialPopupManagerMMICombi this$0;

    private PartialPopupManagerMMICombi$OptionSelectedJob(PartialPopupManagerMMICombi partialPopupManagerMMICombi, int n, int n2) {
        this.this$0 = partialPopupManagerMMICombi;
        this.popupID = n;
        this.optionID = n2;
    }

    @Override
    public void run() {
        if (this.this$0.getPartialPopup(this.popupID) != null) {
            ((PartialPopupControllerMMICombi)this.this$0.getPartialPopup(this.popupID)).optionSelected(this.optionID);
        }
    }

    /* synthetic */ PartialPopupManagerMMICombi$OptionSelectedJob(PartialPopupManagerMMICombi partialPopupManagerMMICombi, int n, int n2, PartialPopupManagerMMICombi$1 partialPopupManagerMMICombi$1) {
        this(partialPopupManagerMMICombi, n, n2);
    }
}

