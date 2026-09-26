/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.nad;

import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.nad.TelModulePowerHandler;

class TelModulePowerHandler$1
extends TelDefaultDSIResponseListener {
    private final /* synthetic */ TelModulePowerHandler this$0;

    TelModulePowerHandler$1(TelModulePowerHandler telModulePowerHandler) {
        this.this$0 = telModulePowerHandler;
    }

    @Override
    public void responseTelPower(int n, int n2) {
        TelModulePowerHandler.access$000(this.this$0, 1704395776).setStatus(1);
    }
}

