/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.remotehmi.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.log.LogChannel;

public class RemoteHMIRequestDialogContinuationCommand
extends AbstractSystemCallCommand {
    private final OnlineService onlineService;

    public RemoteHMIRequestDialogContinuationCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, OnlineService onlineService) {
        super(logChannel, string, sDSHandlerService);
        this.onlineService = onlineService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        this.onlineService.requestDialogContinuation();
    }

    public void setRemoteHMICategorySetFinished(byte by) {
        this.logger.log(-2137614336, "%1#setRemoteHMICategorySetFinished: returnType=%3, %2continuing dialog!", (Object)this.getName(), (Object)(by == 0 ? "" : "not "), (long)by);
        switch (by) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            default: {
                this.logger.log(-1601830656, "%1#setRemoteHMICategorySetFinished: Unhandled returnType %2!", (Object)this.getName(), (long)by);
            }
        }
        this.processingFinished();
    }
}

