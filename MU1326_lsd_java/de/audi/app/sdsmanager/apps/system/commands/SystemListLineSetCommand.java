/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class SystemListLineSetCommand
extends AbstractSystemCallCommand {
    private final HMIService hmiService;
    private final boolean readOnly;

    public SystemListLineSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
        this.readOnly = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
    }

    public void execute() {
        int n;
        this.logger.log(10000000, "%1#execute: readOnly=%2", (Object)this.getName(), (Object)this.readOnly);
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(10000000, "%1#execute: spokenLineNumberStr=%2 (1-indexed)!", (Object)this.getName(), (Object)string);
        int n2 = 1;
        try {
            n2 = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(10000000, "%1#execute: No number found in first slot, asssuming selection of first entry!", (Object)this.getName());
        }
        int n3 = SDSModelAccess.getEnumerationNumberStatus();
        int n4 = SDSModelAccess.getEnumerationNumberValue();
        int n5 = n = this.readOnly ? 9 : 5;
        if (n2 == n4 && n3 >= 0) {
            n2 = n3;
            n = this.readOnly ? 8 : 6;
        }
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(10000000, "%1#execute: Setting lineNumber %2 with pageEvent %3 and answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n2, (long)n);
        this.hmiService.fireSDSEvent(2, n, n2, nArray);
    }
}

