/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;

public class SystemCursorHighlightLineCommand
extends AbstractSystemCallCommand {
    private final HMIService hmiService;
    private final int index;

    public SystemCursorHighlightLineCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, HMIService hMIService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.hmiService = hMIService;
        this.index = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: index=%2", (Object)this.getName(), (long)this.index);
        int[] nArray = new int[]{3000, 3004, 3001};
        this.logger.log(10000000, "%1#execute: Setting choice index %2 with pageEvent %3 and answers for OK/INVALID/ERROR!", (Object)this.getName(), (long)this.index, 10L);
        this.hmiService.fireSDSEvent(0, 10, this.index, nArray);
        this.processingFinished();
    }
}

