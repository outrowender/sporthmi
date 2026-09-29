/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.log.LogChannel;

public class MsgReadoutDetailCommand
extends AbstractSystemCallCommand {
    private final IMessagingReadoutService messagingService;

    public MsgReadoutDetailCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingReadoutService iMessagingReadoutService) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingReadoutService;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute: called", (Object)this.getName());
        this.messagingService.requestReadoutMessage();
    }

    public void responseReadoutMessage(int n) {
        this.logger.log(-2137614336, "%1#responseReadoutMessage: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? -131858176 : -115080960);
    }
}

