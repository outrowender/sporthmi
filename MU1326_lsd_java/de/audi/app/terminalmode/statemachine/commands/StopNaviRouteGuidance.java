/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class StopNaviRouteGuidance
extends AbstractCommand {
    private static final String LOGCLASS = "StopNaviRouteGuidance";

    public StopNaviRouteGuidance(IContext iContext) {
        super(iContext.getLogger().main(), LOGCLASS, iContext);
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        this.context.getNaviAppHandler().stopRouteGuidance();
        this.getCommandList().commandFinished();
    }
}

