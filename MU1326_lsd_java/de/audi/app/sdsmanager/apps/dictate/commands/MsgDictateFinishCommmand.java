/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.log.LogChannel;

public class MsgDictateFinishCommmand
extends AbstractSystemCallCommand {
    private final IMessagingDictationService messagingService;

    public MsgDictateFinishCommmand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingDictationService iMessagingDictationService) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingDictationService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        SDSModelAccess.setMsgDictateModel(0);
        this.messagingService.requestEndDialog();
    }

    public void responseEndDialog(int n) {
        this.logger.log(10000000, "%1#responseEndDialog: result=%2", (Object)this.getName(), (long)n);
        this.processingFinished();
    }
}

