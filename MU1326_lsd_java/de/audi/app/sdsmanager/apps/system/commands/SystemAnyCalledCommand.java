/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.log.LogChannel;

public class SystemAnyCalledCommand
extends AbstractSystemCallCommand {
    public SystemAnyCalledCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService) {
        super(logChannel, string, sDSHandlerService);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        SDSModelAccess.setSlotModel(1, "1");
        SDSModelAccess.setListLineDataGetModel("1");
        this.sendResult(3000);
    }
}

