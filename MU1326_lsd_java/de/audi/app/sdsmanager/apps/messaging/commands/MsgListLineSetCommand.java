/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class MsgListLineSetCommand
extends AbstractSystemCallCommand {
    private final HMIService hmiService;

    public MsgListLineSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute", (Object)this.getName());
        int n = 1;
        int n2 = 0;
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(-2137614336, "%1#execute: lineNumberStr=%2 (1-indexed)!", (Object)this.getName(), (Object)string);
        try {
            n = Integer.parseInt(string);
            n2 = 5;
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(-1601830656, "%1#execute: No number found in first slot, asssuming selection of first entry!", (Object)this.getName());
            n = 1;
            n2 = 5;
        }
        int[] nArray = new int[]{-131858176, -31194880, -115080960};
        this.logger.log(-2137614336, "%1#execute: Setting lineNumber %2 with pageEvent %3 and answers for INVALID/ERROR!", (Object)this.getName(), (long)n, (long)n2);
        this.hmiService.fireSDSEvent(1, n2, n, nArray);
    }

    public void indicateFolderSelection(boolean bl) {
        this.logger.log(-2137614336, "%2#indicateFolderSelection: isFolder=%1", bl, (Object)this.getName());
        this.sendResult(bl ? -64749312 : -131858176);
    }
}

