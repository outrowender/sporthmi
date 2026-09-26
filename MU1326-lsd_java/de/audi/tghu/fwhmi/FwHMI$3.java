/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.FwHMI;

class FwHMI$3
implements Runnable {
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ int val$ppId;
    private final /* synthetic */ FwHMI this$0;

    FwHMI$3(FwHMI fwHMI, int n, int n2) {
        this.this$0 = fwHMI;
        this.val$terminal = n;
        this.val$ppId = n2;
    }

    @Override
    public void run() {
        this.this$0.getPartialPopupManager(this.val$terminal).showPopupAndRepaintScreen(this.val$ppId);
    }

    public String toString() {
        return new StringBuffer().append("ShowPartialPopupRunnable: terminal: ").append(this.val$terminal).append(" popupId: ").append(this.val$ppId).toString();
    }
}

