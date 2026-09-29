/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAbortServiceCodeRequestCmd;
import de.audi.app.phone.core.dsi.cmd.TelRequestCLIRCmd$1;
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
        TelRequestCLIRCmd.schedule(commandListManager, this, "TelRequestCLIRCmd", new TelRequestCLIRCmd$1(this, this.logger, "TelRequestCLIRCmdError"), monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(-2137614336, "[TelRequestCLIRCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    @Override
    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1078071040, "[TelRequestCLIRCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortServiceCodeRequestCmd(this.dsi, this.logger, this.terminalID, this.abortedByUser, this.listener);
        }
        this.logger.log(-2137614336, "[TelRequestCLIRCmd#canceled] not aborted by user.");
        return null;
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelRequestCLIRCmd#execute] telCLIRState=%1", (long)this.telCLIRState);
            this.dsi.requestCLIR(this.telCLIRState);
        } else {
            this.logger.log(-1601830656, "[TelRequestCLIRCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseCLIR(int n, int n2, int n3) {
        this.logger.log(1078071040, "[TelRequestCLIRCmd#responseCLIR] telCLIRState=%1, telCLIRNWState=%2, result=%3", (long)n, (long)n2, (long)n3);
        if (this.listener != null) {
            this.listener.responseCLIR(n, n2, n3, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    static /* synthetic */ boolean access$000(TelRequestCLIRCmd telRequestCLIRCmd) {
        return telRequestCLIRCmd.abortedByUser;
    }
}

