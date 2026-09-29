/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAbortNetworkRegistrationCmd;
import de.audi.app.phone.core.dsi.cmd.TelNetworkRegistrationCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelNetworkRegistrationCmd
extends AbstractTelDSIMECommand {
    private static final long TIMEOUT;
    private final String telNumProviderName;
    private final int telRegMode;
    private volatile boolean abortedByUser;

    public TelNetworkRegistrationCmd(String string, int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelNetworkRegistrationCmd", n2, iTelDSIResponseListener);
        this.telNumProviderName = string;
        this.telRegMode = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelNetworkRegistrationCmd.schedule(commandListManager, this, "TelNetworkRegistrationCmd", new TelNetworkRegistrationCmd$1(this, this.logger, "TelNetworkRegistrationCmdError"), monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(-2137614336, "[TelNetworkRegistrationCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    @Override
    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1078071040, "[TelNetworkRegistrationCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortNetworkRegistrationCmd(this.dsi, this.logger, this.telRegMode, this.listener);
        }
        this.logger.log(-2137614336, "[TelNetworkRegistrationCmd#canceled] not aborted by user.");
        return null;
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelNetworkRegistrationCmd#execute] telNumProviderName=%1, telRegMode=%2", (Object)this.telNumProviderName, (long)this.telRegMode);
            this.dsi.requestNetworkRegistration(this.telNumProviderName, this.telRegMode);
        } else {
            this.logger.log(-1601830656, "[TelNetworkRegistrationCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseNetworkRegistration(int n) {
        this.logger.log(1078071040, "[TelNetworkRegistrationCmd#responseNetworkRegistration] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseNetworkRegistration(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    static /* synthetic */ boolean access$000(TelNetworkRegistrationCmd telNetworkRegistrationCmd) {
        return telNetworkRegistrationCmd.abortedByUser;
    }
}

