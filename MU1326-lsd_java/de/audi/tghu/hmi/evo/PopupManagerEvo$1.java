/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.PopupManagerEvo;

class PopupManagerEvo$1
implements Runnable {
    private final /* synthetic */ int val$popupId;
    private final /* synthetic */ PopupManagerEvo this$0;

    PopupManagerEvo$1(PopupManagerEvo popupManagerEvo, int n) {
        this.this$0 = popupManagerEvo;
        this.val$popupId = n;
    }

    @Override
    public void run() {
        PopupManagerEvo.access$000(this.this$0).log(-2137614336, "ShowPopupRunnable in entertainmentdrawer for popupID: %1, calling entertainment drawer now) ", (long)this.val$popupId);
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.this$0.getDrawerFocusManager();
        if (iDrawerFocusManagerEvo != null && iDrawerFocusManagerEvo.getDrawerState() != 32) {
            iDrawerFocusManagerEvo.requestDrawerState(32);
        }
    }

    public String toString() {
        return new StringBuffer().append("ShowPopupRunnable in entertainmentdrawer(terminal: ").append(this.this$0.getTerminalContext().getTerminalID()).append(" popupId: ").append(this.val$popupId).append(")").toString();
    }
}

