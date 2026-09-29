/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.remotehmi.RemoteHMIHandler;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.log.LogChannel;

public class RemoteHMISetHelpResultCommand
extends AbstractSystemCallCommand {
    private final NBestStorageAccess nBestStorage;
    private final OnlineService onlineService;
    private RemoteHMIHandler handler;

    public RemoteHMISetHelpResultCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess, OnlineService onlineService, RemoteHMIHandler remoteHMIHandler) {
        super(logChannel, string, sDSHandlerService);
        this.nBestStorage = nBestStorageAccess;
        this.onlineService = onlineService;
        this.handler = remoteHMIHandler;
    }

    @Override
    public void execute() {
        int n = this.handler.getSelectedHelpLine();
        if (n > -1) {
            this.logger.log(-2137614336, "%1#execute: selectedIdx=%2!", (Object)this.getName(), (long)n);
            this.handler.setSelectedHelpLine(-1);
            this.onlineService.setRemoteHMIHelpRecognizedID(n, (byte)0);
        } else {
            long l = this.nBestStorage.getSlotObjID(0, 0);
            this.logger.log(-2137614336, "%1#execute: topSlotObjID=%2!", (Object)this.getName(), l);
            this.onlineService.setRemoteHMIHelpRecognizedID((int)l, (byte)1);
        }
        this.sendResult(3000);
    }
}

