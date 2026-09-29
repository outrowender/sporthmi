/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.log.LogChannel;

public class SystemCounterResetCommand
extends AbstractSystemCallCommand {
    public SystemCounterResetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService) {
        super(logChannel, string, sDSHandlerService);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        SDSModelAccess.resetCounterChoice();
        this.processingFinished();
    }
}

