/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.log.LogChannel;

public class MsgSendCommand
extends AbstractSystemCallCommand {
    private final IMessagingDictationService messagingService;
    private int sendResult;

    public MsgSendCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingDictationService iMessagingDictationService) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingDictationService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        this.messagingService.requestSendMessage();
    }

    public void responseSendMessage(int n) {
        this.logger.log(-2137614336, "%1#responseSendMessage: result=%2", (Object)this.getName(), (long)n);
        this.sendResult = n;
        this.messagingService.requestEndDialog();
    }

    public void responseEndDialog(int n) {
        this.logger.log(-2137614336, "%1#responseEndDialog: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(this.sendResult == 0 ? -131858176 : -115080960);
    }
}

