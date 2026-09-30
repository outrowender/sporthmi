/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.messaging.MsgReadoutFinishInterface;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.log.LogChannel;

public class MsgReadoutFinishCommand
extends AbstractSystemCallCommand
implements MsgReadoutFinishInterface {
    private final IMessagingReadoutService messagingService;

    public MsgReadoutFinishCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingReadoutService iMessagingReadoutService) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingReadoutService;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: called", (Object)this.getName());
        SDSModelAccess.setMsgReadoutActiveModel(0);
        this.messagingService.requestEndDialog();
    }

    public void responseEndDialog(int n) {
        this.logger.log(10000000, "%1#responseEndDialog: result=%2", (Object)this.getName(), (long)n);
        this.processingFinished();
    }
}

