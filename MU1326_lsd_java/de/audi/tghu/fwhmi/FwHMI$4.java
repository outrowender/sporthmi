/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.FwHMI;

class FwHMI$4
implements Runnable {
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ int val$ppId2;
    private final /* synthetic */ int val$ppId1;
    private final /* synthetic */ FwHMI this$0;

    FwHMI$4(FwHMI fwHMI, int n, int n2, int n3) {
        this.this$0 = fwHMI;
        this.val$terminal = n;
        this.val$ppId2 = n2;
        this.val$ppId1 = n3;
    }

    @Override
    public void run() {
        this.this$0.getPartialPopupManager(this.val$terminal).showPopup(this.val$ppId2);
        this.this$0.getPartialPopupManager(this.val$terminal).hidePopupAndRepaintScreen(this.val$ppId1);
    }

    public String toString() {
        return new StringBuffer().append("ReplacePartialPopupRunnable: terminal: ").append(this.val$terminal).append(" popupId1: ").append(this.val$ppId1).append(" popupId2: ").append(this.val$ppId2).toString();
    }
}

