/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.log.LogChannel;

public class SystemRemoveFromPicklistHistoryCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;
    private final int number;

    public SystemRemoveFromPicklistHistoryCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.number = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] called, number=%2", (Object)this.getName(), (long)this.number);
        for (int i2 = 1; i2 <= this.number; ++i2) {
            this.nBestStorage.retrieveLatestNBestListHistory(true);
        }
        this.processingFinished();
    }
}

