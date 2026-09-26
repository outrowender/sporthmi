/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler;

class TelSIMModeSwitchHandler$SimUsageHkReturnButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelSIMModeSwitchHandler this$0;

    public TelSIMModeSwitchHandler$SimUsageHkReturnButtonListener(TelSIMModeSwitchHandler telSIMModeSwitchHandler, ITelApplication iTelApplication) {
        this.this$0 = telSIMModeSwitchHandler;
        super(iTelApplication, 462947328);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        int n4 = TelSIMModeSwitchHandler.access$2000(this.this$0).getNadMode();
        if (n4 == 1) {
            this.log.log(1078071040, "[TelSIMModeSwitchHandler.SimUsageHkReturnButtonListener#keyTyped] HK_RETURN (saving decision for NADMODE_VOICE_DATA)");
            this.this$0.addSimUsageData(1);
            TelSIMModeSwitchHandler.access$1800(this.this$0);
        } else if (n4 == 2) {
            this.log.log(1078071040, "[TelSIMModeSwitchHandler.SimUsageHkReturnButtonListener#keyTyped] HK_RETURN (saving decision for NADMODE_DATA)");
            this.this$0.addSimUsageData(2);
            TelSIMModeSwitchHandler.access$1800(this.this$0);
        }
        this.fireEvent(n3);
    }
}

