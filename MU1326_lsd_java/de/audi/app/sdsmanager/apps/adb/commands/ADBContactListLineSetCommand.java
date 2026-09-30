/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public class ADBContactListLineSetCommand
extends Command {
    private final HMIService hmiService;
    private final boolean readonly;

    public ADBContactListLineSetCommand(LogChannel logChannel, String string, HMIService hMIService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string);
        this.hmiService = hMIService;
        this.readonly = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: readOnly=%2", (Object)this.getName(), (Object)this.readonly);
        String string = SDSModelAccess.getSlotModelStrings()[0];
        this.logger.log(10000000, "%1#execute: spokenLineNumberStr=%2 (1-indexed)!", (Object)this.getName(), (Object)string);
        int n = 1;
        try {
            n = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.logger.log(10000000, "%1#execute: No number found in first slot, asssuming selection of first entry!", (Object)this.getName());
        }
        int n2 = this.readonly ? 9 : 5;
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(10000000, "%1#execute: Setting lineNumber %2 with pageEvent %3 and answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n, (long)n2);
        this.hmiService.fireSDSEvent(2, n2, n, nArray);
    }
}

