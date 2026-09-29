/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.bt.dsi;

import de.audi.app.terminalmode.bt.dsi.BTDSIController;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;

class BTDSIController$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$bTState;
    private final /* synthetic */ BTDSIController this$0;

    BTDSIController$2(BTDSIController bTDSIController, String string, int n) {
        this.this$0 = bTDSIController;
        this.val$bTState = n;
        super(string);
    }

    @Override
    public void run() {
        BTDSIController.access$100(this.this$0).log(1078071040, "<- [%1.updateBTState] bTState=%2", (Object)"BTDSIController", (long)this.val$bTState);
        int n = BTDSIController.access$200(this.this$0, this.val$bTState);
        if (0 != n) {
            BTDSIController.access$300(this.this$0).updateBTState(n);
        }
        BTDSIController.access$500(this.this$0).getPropertyBluetooth().accept(BTDSIController.access$400(this.this$0, this.val$bTState));
    }
}

