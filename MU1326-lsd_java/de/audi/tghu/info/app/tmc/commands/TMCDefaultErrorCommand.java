/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

public class TMCDefaultErrorCommand
extends TMCCommand {
    protected AppTMC tmcApp;

    public TMCDefaultErrorCommand(AppTMC appTMC, LogChannel logChannel) {
        super(appTMC, logChannel);
        this.tmcApp = appTMC;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[TMCDefaultErrorCommand#execute] requestInitialTMCWindow()");
        this.tmcApp.requestInitialTMCWindow();
        this.getCommandList().commandFinished();
    }

    @Override
    public String toString() {
        return super.getClass().getName();
    }
}

