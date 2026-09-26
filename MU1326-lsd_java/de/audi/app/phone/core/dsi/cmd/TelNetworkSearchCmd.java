/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAbortNetworkSearchCmd;
import de.audi.app.phone.core.dsi.cmd.TelNetworkSearchCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.NetworkProvider;

public class TelNetworkSearchCmd
extends AbstractTelDSIMECommand {
    private static final long TIMEOUT;
    private volatile boolean abortedByUser;

    public TelNetworkSearchCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelNetworkSearchCmd", n, iTelDSIResponseListener);
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelNetworkSearchCmd.schedule(commandListManager, this, "TelNetworkSearchCmdCmd", new TelNetworkSearchCmd$1(this, this.logger, "TelNetworkSearchCmdCmdError"), monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(-2137614336, "[TelNetworkSearchCmdCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    @Override
    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1078071040, "[TelNetworkSearchCmdCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortNetworkSearchCmd(this.dsi, this.logger, this.terminalID, this.listener);
        }
        this.logger.log(-2137614336, "[TelNetworkSearchCmdCmd#canceled] not aborted by user.");
        return null;
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelNetworkSearchCmd#execute]");
            this.dsi.requestNetworkSearch();
        } else {
            this.logger.log(-1601830656, "[TelNetworkSearchCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        this.logger.log(1078071040, "[TelNetworkSearchCmd#responseNetworkSearch] telNetworkProviders=%1, result=%2", (Object)Converter.objectToString(networkProviderArray), (long)n);
        if (this.listener != null) {
            this.listener.responseNetworkSearch(networkProviderArray, n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    static /* synthetic */ boolean access$000(TelNetworkSearchCmd telNetworkSearchCmd) {
        return telNetworkSearchCmd.abortedByUser;
    }
}

