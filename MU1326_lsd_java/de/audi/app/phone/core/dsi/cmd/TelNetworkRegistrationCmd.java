/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAbortNetworkRegistrationCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelNetworkRegistrationCmd
extends AbstractTelDSIMECommand {
    private static final long TIMEOUT = 200000L;
    private final String telNumProviderName;
    private final int telRegMode;
    private volatile boolean abortedByUser;

    public TelNetworkRegistrationCmd(String string, int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelNetworkRegistrationCmd", n2, iTelDSIResponseListener);
        this.telNumProviderName = string;
        this.telRegMode = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelNetworkRegistrationCmd.schedule(commandListManager, this, "TelNetworkRegistrationCmd", new Command(this.logger, "TelNetworkRegistrationCmdError"){

            public void execute() {
                if (!TelNetworkRegistrationCmd.this.abortedByUser) {
                    this.logger.log(100000, "[TelNetworkRegistrationCmd.schedule().new Command() {...}#execute] Error.");
                    if (TelNetworkRegistrationCmd.this.listener != null) {
                        TelNetworkRegistrationCmd.this.listener.responseNetworkRegistration(65537, TelNetworkRegistrationCmd.this.terminalID);
                    }
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(10000000, "[TelNetworkRegistrationCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1000000, "[TelNetworkRegistrationCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortNetworkRegistrationCmd(this.dsi, this.logger, this.telRegMode, this.listener);
        }
        this.logger.log(10000000, "[TelNetworkRegistrationCmd#canceled] not aborted by user.");
        return null;
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelNetworkRegistrationCmd#execute] telNumProviderName=%1, telRegMode=%2", (Object)this.telNumProviderName, (long)this.telRegMode);
            this.dsi.requestNetworkRegistration(this.telNumProviderName, this.telRegMode);
        } else {
            this.logger.log(100000, "[TelNetworkRegistrationCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseNetworkRegistration(int n) {
        this.logger.log(1000000, "[TelNetworkRegistrationCmd#responseNetworkRegistration] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseNetworkRegistration(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    public long getTimeout() {
        return 200000L;
    }
}

