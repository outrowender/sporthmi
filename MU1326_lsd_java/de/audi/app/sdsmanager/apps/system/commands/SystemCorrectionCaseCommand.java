/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.log.LogChannel;

public class SystemCorrectionCaseCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;

    public SystemCorrectionCaseCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] called", (Object)this.getName());
        this.nBestStorage.stepBackPicklistHistory();
        this.processingFinished();
    }
}

