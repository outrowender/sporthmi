/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.bt.dsi;

import de.audi.app.terminalmode.bt.dsi.BTDSIController;
import de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListener;

class BTDSIController$1
implements IBTDSIControllerListener {
    private final /* synthetic */ BTDSIController this$0;

    BTDSIController$1(BTDSIController bTDSIController) {
        this.this$0 = bTDSIController;
    }

    @Override
    public void updateBTState(int n) {
        BTDSIController.access$000(this.this$0).log(1078071040, "[NullBTDSIControllerListener.updateBTState]");
    }
}

