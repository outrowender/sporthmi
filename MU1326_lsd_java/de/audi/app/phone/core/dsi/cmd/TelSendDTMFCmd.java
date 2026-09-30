/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSendDTMFCmd
extends AbstractTelDSIMECommand {
    private final String telDTMF;

    public TelSendDTMFCmd(String string, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSendDTMFCmd", n, iTelDSIResponseListener);
        this.telDTMF = string;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSendDTMFCmd.schedule(commandListManager, this, "TelSendDTMFCmd", new Command(this.logger, "TelSendDTMFCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSendDTMFCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSendDTMFCmd.this.listener != null) {
                    TelSendDTMFCmd.this.listener.responseSendDTMF(65537, TelSendDTMFCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSendDTMFCmd#execute] telDTMF=%1", (Object)this.telDTMF);
        if (this.isDSIAvailable()) {
            this.dsi.sendDTMF(this.telDTMF);
        } else {
            this.logger.log(100000, "[TelSendDTMFCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSendDTMF(int n) {
        this.logger.log(1000000, "[TelSendDTMFCmd#responseSendDTMF] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSendDTMF(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

