/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;

public class UpdateResources
extends AbstractDSICommand {
    private static final String LOGCLASS = "UpdateResources";

    public UpdateResources(IContext iContext, IDSISmartphoneManager iDSISmartphoneManager) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iDSISmartphoneManager);
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
    }
}

