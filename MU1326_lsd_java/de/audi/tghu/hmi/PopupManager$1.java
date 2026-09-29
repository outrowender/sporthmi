/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi;

import de.audi.tghu.hmi.PopupManager;

class PopupManager$1
implements Runnable {
    private final /* synthetic */ int val$popupId;
    private final /* synthetic */ PopupManager this$0;

    PopupManager$1(PopupManager popupManager, int n) {
        this.this$0 = popupManager;
        this.val$popupId = n;
    }

    @Override
    public void run() {
        this.this$0.logPopup.log(-2137614336, "RemovePopupRunnable: calling SMI.stopPopup(%1) ", (long)this.val$popupId);
        this.this$0.framework.getSMInterpreter().stopPopup(this.this$0.getTerminalContext().getTerminalID(), this.val$popupId);
    }

    public String toString() {
        return new StringBuffer().append("RemovePopupRunnable(terminal: ").append(this.this$0.getTerminalContext().getTerminalID()).append(" popupId: ").append(this.val$popupId).append(")").toString();
    }
}

