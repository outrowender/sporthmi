/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;

public class SystemStorePicklistInHistoryCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;

    public SystemStorePicklistInHistoryCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
    }

    public void execute() {
        this.logger.log(10000000, "[%1#execute] called", (Object)this.getName());
        this.nBestStorage.storeCurrentPicklistInHistory();
        this.processingFinished();
    }
}

