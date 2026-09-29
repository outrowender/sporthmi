/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.dictate.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.log.LogChannel;

public class MsgClearRecipientCommand
extends AbstractSystemCallCommand {
    private final IMessagingDictationService messagingService;

    public MsgClearRecipientCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingDictationService iMessagingDictationService) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingDictationService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        this.messagingService.requestClearRecipients(0);
    }

    public void responseClearRecipients(int n) {
        this.logger.log(-2137614336, "%1#responseClearRecipients(), response=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? -131858176 : -115080960);
    }
}

