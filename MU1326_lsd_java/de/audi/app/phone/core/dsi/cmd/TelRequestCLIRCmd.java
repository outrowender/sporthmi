/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAbortServiceCodeRequestCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelRequestCLIRCmd
extends AbstractTelDSIMECommand {
    private final int telCLIRState;
    private volatile boolean abortedByUser;

    public TelRequestCLIRCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelRequestCLIRCmd", n2, iTelDSIResponseListener);
        this.telCLIRState = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelRequestCLIRCmd.schedule(commandListManager, this, "TelRequestCLIRCmd", new Command(this.logger, "TelRequestCLIRCmdError"){

            public void execute() {
                if (!TelRequestCLIRCmd.this.abortedByUser) {
                    this.logger.log(100000, "[TelRequestCLIRCmd.schedule().new Command() {...}#execute] Error.");
                    if (TelRequestCLIRCmd.this.listener != null) {
                        TelRequestCLIRCmd.this.listener.responseCLIR(-1, -1, 65537, TelRequestCLIRCmd.this.terminalID);
                    }
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(10000000, "[TelRequestCLIRCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1000000, "[TelRequestCLIRCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortServiceCodeRequestCmd(this.dsi, this.logger, this.terminalID, this.abortedByUser, this.listener);
        }
        this.logger.log(10000000, "[TelRequestCLIRCmd#canceled] not aborted by user.");
        return null;
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelRequestCLIRCmd#execute] telCLIRState=%1", (long)this.telCLIRState);
            this.dsi.requestCLIR(this.telCLIRState);
        } else {
            this.logger.log(100000, "[TelRequestCLIRCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseCLIR(int n, int n2, int n3) {
        this.logger.log(1000000, "[TelRequestCLIRCmd#responseCLIR] telCLIRState=%1, telCLIRNWState=%2, result=%3", (long)n, (long)n2, (long)n3);
        if (this.listener != null) {
            this.listener.responseCLIR(n, n2, n3, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

