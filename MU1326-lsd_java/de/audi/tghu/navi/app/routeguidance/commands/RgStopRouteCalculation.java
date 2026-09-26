/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class RgStopRouteCalculation
extends NavCommand {
    @Override
    public void execute() {
        this.logger.log(-2137614336, "RgStopRouteCalculation#execute() - calling rgStopRouteCalculation() ");
        this.getDSINavigation().rgStopRouteCalculation();
        this.getCommandList().commandFinished();
    }
}

