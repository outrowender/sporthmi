/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi;

import de.audi.atip.hmi.view.IShowPopupRunnable;
import de.audi.tghu.hmi.PopupManager;

public class PopupManager$ShowPopupRunnable
implements Runnable,
IShowPopupRunnable {
    final int popupId;
    final int terminalId;
    private final /* synthetic */ PopupManager this$0;

    PopupManager$ShowPopupRunnable(PopupManager popupManager, int n, int n2) {
        this.this$0 = popupManager;
        this.popupId = n;
        this.terminalId = n2;
    }

    @Override
    public void run() {
        this.this$0.logPopup.log(-2137614336, "ShowPopupRunnable: calling SMI.startPopup(%1) ", (long)this.popupId);
        this.this$0.framework.getSMInterpreter().startPopup(this.terminalId, this.popupId);
    }

    public String toString() {
        return new StringBuffer().append("ShowPopupRunnable(terminal: ").append(this.terminalId).append(" popupId: ").append(this.popupId).append(")").toString();
    }
}

