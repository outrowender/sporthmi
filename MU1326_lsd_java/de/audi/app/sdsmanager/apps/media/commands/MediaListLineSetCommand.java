/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class MediaListLineSetCommand
extends AbstractSystemCallCommand {
    private final HMIService hmiService;

    public MediaListLineSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute ", (Object)this.getName());
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(10000000, "%1#execute: lineNumberStr=%2 (1-indexed)!", (Object)this.getName(), (Object)string);
        int n = 1;
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(10000000, "%1#execute: No number found in first slot, asssuming selection of first entry!", (Object)this.getName());
        }
        int[] nArray = new int[]{20000, 20006, 20001};
        this.logger.log(10000000, "%1#execute: Setting lineNumber %2 with media answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n);
        this.hmiService.fireSDSEvent(2, 5, n, nArray);
    }
}

