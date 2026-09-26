/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;
import de.audi.app.phone.core.sim.SimUsageUserDecision;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler;
import de.audi.app.phone.core.sim.TelSIMModeSwitchHandler$SimModeSwitchStorageHandler;

class TelSIMModeSwitchHandler$FactoryResetHandler
extends AbstractTelMessageListener {
    private final /* synthetic */ TelSIMModeSwitchHandler this$0;

    public TelSIMModeSwitchHandler$FactoryResetHandler(TelSIMModeSwitchHandler telSIMModeSwitchHandler, ITelApplication iTelApplication) {
        this.this$0 = telSIMModeSwitchHandler;
        super(iTelApplication, "App.Phone.Main", 28);
    }

    @Override
    protected void messageReceived() {
        this.log.log(1078071040, "[TelSIMModeSwitchHandler.FactoryResetHandler#messageRecieved] deleting all sim usage information.");
        TelSIMModeSwitchHandler.access$1502(this.this$0, new SimUsageUserDecision[0]);
        TelSIMModeSwitchHandler$SimModeSwitchStorageHandler.access$100(TelSIMModeSwitchHandler.access$1600(this.this$0), TelSIMModeSwitchHandler.access$1500(this.this$0));
    }
}

