/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.log.LogChannel;

public class SystemListLineGetCommand
extends AbstractSystemCallCommand {
    public SystemListLineGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService) {
        super(logChannel, string, sDSHandlerService);
    }

    public void execute() {
        int n = SDSModelAccess.getEnumerationNumberValue();
        this.logger.log(10000000, "%1#execute: lineNumber=%2 (1-indexed)!", (Object)this.getName(), (long)n);
        SDSModelAccess.setSlotModel(1, Integer.toString(n));
        this.sendResult(3000);
    }
}

