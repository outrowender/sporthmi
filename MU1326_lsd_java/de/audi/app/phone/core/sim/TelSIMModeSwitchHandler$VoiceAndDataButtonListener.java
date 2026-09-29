/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler;

class TelSIMModeSwitchHandler$VoiceAndDataButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelSIMModeSwitchHandler this$0;

    public TelSIMModeSwitchHandler$VoiceAndDataButtonListener(TelSIMModeSwitchHandler telSIMModeSwitchHandler, ITelApplication iTelApplication) {
        this.this$0 = telSIMModeSwitchHandler;
        super(iTelApplication, 93783040);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelSIMModeSwitchHandler.VoiceAndDataButtonListener#keyTyped] voice and data selected.");
        TelSIMModeSwitchHandler.access$1700(this.this$0, n3, n);
        TelSIMModeSwitchHandler.access$1800(this.this$0);
        this.this$0.addSimUsageData(1);
    }
}

