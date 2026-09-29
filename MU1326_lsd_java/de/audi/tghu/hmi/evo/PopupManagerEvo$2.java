/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.PopupManagerEvo;

class PopupManagerEvo$2
implements Runnable {
    private final /* synthetic */ int val$popupId;
    private final /* synthetic */ PopupManagerEvo this$0;

    PopupManagerEvo$2(PopupManagerEvo popupManagerEvo, int n) {
        this.this$0 = popupManagerEvo;
        this.val$popupId = n;
    }

    @Override
    public void run() {
        PopupManagerEvo.access$100(this.this$0).log(-2137614336, "RemovePopupRunnable in entertainmentdrawer for popupID %1, calling entertainment drawer now ", (long)this.val$popupId);
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.this$0.getDrawerFocusManager();
        if (iDrawerFocusManagerEvo != null && iDrawerFocusManagerEvo.getDrawerState() == 32) {
            if (this.val$popupId == -527236096) {
                iDrawerFocusManagerEvo.setDrawerState(16, true);
            } else {
                iDrawerFocusManagerEvo.requestDrawerState(16);
            }
        }
    }

    public String toString() {
        return new StringBuffer().append("RemovePopupRunnable in entertainmentdrawer(terminal: ").append(this.this$0.getTerminalContext().getTerminalID()).append(" popupId: ").append(this.val$popupId).append(")").toString();
    }
}

