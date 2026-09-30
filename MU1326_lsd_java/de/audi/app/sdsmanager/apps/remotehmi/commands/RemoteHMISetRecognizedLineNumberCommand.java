/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.log.LogChannel;

public class RemoteHMISetRecognizedLineNumberCommand
extends AbstractSystemCallCommand {
    private final OnlineService onlineService;

    public RemoteHMISetRecognizedLineNumberCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, OnlineService onlineService) {
        super(logChannel, string, sDSHandlerService);
        this.onlineService = onlineService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        this.onlineService.remoteHMISetRecognizedLineNumber();
        this.sendResult(3000);
    }
}

