/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler;

class TelSIMModeSwitchHandler$DataOnlyButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelSIMModeSwitchHandler this$0;

    public TelSIMModeSwitchHandler$DataOnlyButtonListener(TelSIMModeSwitchHandler telSIMModeSwitchHandler, ITelApplication iTelApplication) {
        this.this$0 = telSIMModeSwitchHandler;
        super(iTelApplication, 77005824);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelSIMModeSwitchHandler.DataOnlyButtonListener#keyTyped] data only selected.");
        TelSIMModeSwitchHandler.access$1900(this.this$0, n3, n);
        TelSIMModeSwitchHandler.access$1800(this.this$0);
        this.this$0.addSimUsageData(2);
    }
}

