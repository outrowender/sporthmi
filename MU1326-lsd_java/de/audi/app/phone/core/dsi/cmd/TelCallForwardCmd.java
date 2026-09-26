/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelAbortServiceCodeRequestCmd;
import de.audi.app.phone.core.dsi.cmd.TelCallForwardCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CFResponseData;

public class TelCallForwardCmd
extends AbstractTelDSIMECommand {
    private final CFRequestData[] telCFRequestData;
    private volatile boolean abortedByUser;

    public TelCallForwardCmd(CFRequestData[] cFRequestDataArray, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelCallForwardCmd", n, iTelDSIResponseListener);
        this.telCFRequestData = cFRequestDataArray;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelCallForwardCmd.schedule(commandListManager, this, "TelCallForwardCmd", new TelCallForwardCmd$1(this, this.logger, "TelCallForwardCmdError"), monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(-2137614336, "[TelCallForwardCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    @Override
    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1078071040, "[TelCallForwardCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortServiceCodeRequestCmd(this.dsi, this.logger, this.terminalID, this.abortedByUser, this.listener);
        }
        this.logger.log(-2137614336, "[TelCallForwardCmd#canceled] not aborted by user.");
        return null;
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelCallForwardCmd#execute] telCFRequestData=%1", (Object)Converter.array2String(this.telCFRequestData));
            this.dsi.requestCallForward(this.telCFRequestData);
        } else {
            this.logger.log(-1601830656, "[TelCallForwardCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        this.logger.log(1078071040, "[TelCallForwardCmd#responseCallForward] telCFResponseData=%1, result=%2", (Object)Converter.array2String(cFResponseDataArray), (long)n);
        if (this.listener != null) {
            this.listener.responseCallForward(cFResponseDataArray, n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    static /* synthetic */ boolean access$000(TelCallForwardCmd telCallForwardCmd) {
        return telCallForwardCmd.abortedByUser;
    }
}

