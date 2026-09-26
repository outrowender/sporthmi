/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.log.LogChannel;

public class RemoteHMIResultSetCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestHandler;
    private final OnlineService onlineService;

    public RemoteHMIResultSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, OnlineService onlineService) {
        super(logChannel, string, sDSHandlerService);
        this.nBestHandler = nBestStorageAccess;
        this.onlineService = onlineService;
    }

    @Override
    public void execute() {
        long l = this.nBestHandler.getSlotObjID(0, 0);
        this.logger.log(-2137614336, "%1#execute: topSlotObjID=%2", (Object)this.getName(), l);
        this.onlineService.setRemoteHMIRecognizedID((int)l);
        this.sendResult(3000);
    }
}

