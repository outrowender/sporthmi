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

public class SystemListLineDataGetCommand
extends AbstractSystemCallCommand
implements IJoystickBlock {
    private HMIService hmi;

    public SystemListLineDataGetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService) {
        super(logChannel, string, sDSHandlerService);
        this.hmi = hMIService;
    }

    public void execute() {
        int n;
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(10000000, "%1#execute: lineNumberStr=%2", (Object)this.getName(), (Object)string);
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(100000, "%1#execute: Exception for lineNumberStr %2: %3!", (Object)this.getName(), (Object)string, (Object)numberFormatException.getMessage());
            this.sendResult(3001);
            return;
        }
        this.logger.log(10000000, "%1#execute: lineNumber=%2", (Object)this.getName(), (long)n);
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(10000000, "%1#execute: Setting lineNumber %2 with answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n);
        this.hmi.fireSDSEvent(1, 5, n, nArray);
    }

    public void sdsListLineDataGet(int n, int n2) {
        this.logger.log(10000000, "%1#sdsListLineDataGet: absLine=%2 (0-indexed)", (Object)this.getName(), (long)n2);
        this.sendResult(3000);
    }
}

