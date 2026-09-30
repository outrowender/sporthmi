/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.global.NavRectangle;

public class RequestBoundingRectangleCommand
extends TMCCommand {
    public RequestBoundingRectangleCommand(AppTMC appTMC, LogChannel logChannel) {
        super(appTMC, logChannel);
    }

    public String toString() {
        return this.getClass().getName();
    }

    public void execute() {
        this.logger.log(10000000, "[RequestBoundingRectangleCommand#execute] Requesting rectangle for %1 ", (Object)this.tmcApp.getResponseContainer().getChildrenTrafficEvents());
        this.tmcApp.getTMCHandler().getBoundingRectangle(this.tmcApp.getResponseContainer().getChildrenTrafficEvents());
    }

    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        this.logger.log(10000000, "[RequestBoundingRectangleCommand#getBoundingRectangleForTrafficMessagesResult]rectangle %1 ", (Object)navRectangle);
        this.tmcApp.getResponseContainer().setRectangle(navRectangle);
        this.getCommandList().commandFinished();
    }
}

