/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class StopNaviRouteGuidance
extends AbstractCommand {
    private static final String LOGCLASS;

    public StopNaviRouteGuidance(IContext iContext) {
        super(iContext.getLogger().main(), "StopNaviRouteGuidance", iContext);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"StopNaviRouteGuidance");
        this.context.getNaviAppHandler().stopRouteGuidance();
        this.getCommandList().commandFinished();
    }
}

