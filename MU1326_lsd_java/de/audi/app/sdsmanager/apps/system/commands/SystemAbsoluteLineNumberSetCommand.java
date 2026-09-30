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

public class SystemAbsoluteLineNumberSetCommand
extends AbstractSystemCallCommand {
    private final HMIService hmiService;
    private final boolean readOnly;
    private int listOffset;

    public SystemAbsoluteLineNumberSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
        this.readOnly = SDSUtils.retrieveBoolean(iSystemCallParameterArray, 0);
        this.listOffset = Math.max(SDSUtils.retrieveInteger(iSystemCallParameterArray, 1), 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: readOnly=%2, listOffset=%3", (Object)this.getName(), (Object)this.readOnly, (long)this.listOffset);
        int n = 0;
        int n2 = 0;
        int n3 = this.sdsHandlerService.getSelectedRow();
        this.logger.log(10000000, "%1#execute: selectedRow=%2!", (Object)this.getName(), (long)n3);
        n = Math.max(n3 + 1 + this.listOffset, 1);
        n2 = this.readOnly ? 8 : 6;
        SDSModelAccess.setEnumerationNumberStatus(n3);
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(10000000, "%1#execute: Setting lineNumber %2 with pageEvent %3 and answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)n, (long)n2);
        this.hmiService.fireSDSEvent(2, n2, n, nArray);
    }
}

