/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging.commands;

import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.log.LogChannel;

public class MsgTypeSetCommand
extends AbstractSystemCallCommand {
    private IMessagingReadoutService messagingService;
    private int messageType;

    public MsgTypeSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, IMessagingReadoutService iMessagingReadoutService, ISystemCallParameter[] iSystemCallParameterArray) {
        super(logChannel, string, sDSHandlerService);
        this.messagingService = iMessagingReadoutService;
        this.messageType = SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute: started", (Object)this.getName());
        this.messagingService.requestEndDialog();
    }

    public void responseEndDialog(int n) {
        this.logger.log(10000000, "%1#responseEndDialog: result=%2 messageType=%3", (Object)this.getName(), (long)n, (long)this.messageType);
        this.messagingService.requestBeginLastSelectedEntry();
    }

    public void responseBeginDialog(int n) {
        this.logger.log(10000000, "%1#responseBeginDialog: result=%2", (Object)this.getName(), (long)n);
        this.sendResult(n == 0 ? 75000 : 75001);
    }
}

