/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.IJoystickBlock;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class SystemListLineRequestCommand
extends AbstractSystemCallCommand
implements IJoystickBlock {
    private final HMIService hmiService;

    public SystemListLineRequestCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(-2137614336, "%1#execute: lineNumberStr=%2 (1-indexed)!", (Object)this.getName(), (Object)string);
        int n = 1;
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(-2137614336, "%1#execute: No number found in first slot, asssuming selection of first entry!", (Object)this.getName());
        }
        int[] nArray = new int[]{3000, 3004, 3001, 3006};
        this.logger.log(-2137614336, "%1#execute: Setting lineNumber %2 with pageEvent %3 and answers for OK/INVALID/ERROR/DISABLED!", (Object)this.getName(), (long)n, (long)0);
        this.hmiService.fireSDSEvent(1, 7, n, nArray);
    }

    @Override
    public boolean finishWaitingCommandOnDDS() {
        this.processingFinished();
        return true;
    }
}

