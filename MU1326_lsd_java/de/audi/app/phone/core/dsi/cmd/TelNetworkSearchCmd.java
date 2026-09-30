/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAbortNetworkSearchCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.NetworkProvider;

public class TelNetworkSearchCmd
extends AbstractTelDSIMECommand {
    private static final long TIMEOUT = 330000L;
    private volatile boolean abortedByUser;

    public TelNetworkSearchCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelNetworkSearchCmd", n, iTelDSIResponseListener);
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelNetworkSearchCmd.schedule(commandListManager, this, "TelNetworkSearchCmdCmd", new Command(this.logger, "TelNetworkSearchCmdCmdError"){

            public void execute() {
                if (!TelNetworkSearchCmd.this.abortedByUser) {
                    this.logger.log(100000, "[TelNetworkSearchCmdCmd.schedule().new Command() {...}#execute] Error.");
                    if (TelNetworkSearchCmd.this.listener != null) {
                        TelNetworkSearchCmd.this.listener.responseNetworkSearch(null, 65537, TelNetworkSearchCmd.this.terminalID);
                    }
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(10000000, "[TelNetworkSearchCmdCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1000000, "[TelNetworkSearchCmdCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortNetworkSearchCmd(this.dsi, this.logger, this.terminalID, this.listener);
        }
        this.logger.log(10000000, "[TelNetworkSearchCmdCmd#canceled] not aborted by user.");
        return null;
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelNetworkSearchCmd#execute]");
            this.dsi.requestNetworkSearch();
        } else {
            this.logger.log(100000, "[TelNetworkSearchCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public long getTimeout() {
        return 330000L;
    }

    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        this.logger.log(1000000, "[TelNetworkSearchCmd#responseNetworkSearch] telNetworkProviders=%1, result=%2", (Object)Converter.objectToString(networkProviderArray), (long)n);
        if (this.listener != null) {
            this.listener.responseNetworkSearch(networkProviderArray, n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

