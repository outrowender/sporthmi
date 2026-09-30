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

public class TelCallWaitingCmd
extends AbstractTelDSIMECommand {
    private final int telCWMode;
    private volatile boolean abortedByUser;

    public TelCallWaitingCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelCallWaitingCmd", n2, iTelDSIResponseListener);
        this.telCWMode = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelCallWaitingCmd.schedule(commandListManager, this, "TelCallWaitingCmd", new Command(this.logger, "TelCallWaitingCmdError"){

            public void execute() {
                if (!TelCallWaitingCmd.this.abortedByUser) {
                    this.logger.log(100000, "[TelCallWaitingCmd.schedule().new Command() {...}#execute] Error.");
                    if (TelCallWaitingCmd.this.listener != null) {
                        TelCallWaitingCmd.this.listener.responseCallWaiting(TelCallWaitingCmd.this.telCWMode, -1, 65537, TelCallWaitingCmd.this.terminalID);
                    }
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(10000000, "[TelCallWaitingCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1000000, "[TelCallWaitingCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortServiceCodeRequestCmd(this.dsi, this.logger, this.terminalID, this.abortedByUser, this.listener);
        }
        this.logger.log(10000000, "[TelCallWaitingCmd#canceled] not aborted by user.");
        return null;
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelCallWaitingCmd#execute] telCWMode=%1", (long)this.telCWMode);
            this.dsi.requestCallWaiting(this.telCWMode);
        } else {
            this.logger.log(100000, "[TelCallWaitingCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseCallWaiting(int n, int n2) {
        this.logger.log(1000000, "[TelCallWaitingCmd#responseCallWaiting] telCWStatus=%1, result=%2", (long)n, (long)n2);
        if (this.listener != null) {
            this.listener.responseCallWaiting(this.telCWMode, n, n2, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

