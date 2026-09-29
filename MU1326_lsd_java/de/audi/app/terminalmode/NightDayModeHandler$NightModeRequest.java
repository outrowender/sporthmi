/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;

class NightDayModeHandler$NightModeRequest
extends AbstractDSICommand {
    private static final String LOGCLASS;
    private final boolean useNightMode;
    final IDSISmartphoneManager smartphoneDSIManager;

    public NightDayModeHandler$NightModeRequest(IContext iContext, boolean bl) {
        super(iContext.getLogger().main(), "NightModeRequest", iContext, iContext.getSmartphoneDSIManager());
        this.useNightMode = bl;
        this.smartphoneDSIManager = iContext.getSmartphoneDSIManager();
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute] %2", (Object)"NightModeRequest", (Object)(this.useNightMode ? "night" : "day"));
        this.smartphoneDSIManager.requestNightMode(this.useNightMode);
        this.getCommandList().commandFinished();
    }
}

