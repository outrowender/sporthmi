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
        TelCallForwardCmd.schedule(commandListManager, this, "TelCallForwardCmd", new Command(this.logger, "TelCallForwardCmdError"){

            public void execute() {
                if (!TelCallForwardCmd.this.abortedByUser) {
                    this.logger.log(100000, "[TelCallForwardCmd.schedule().new Command() {...}#execute] Error.");
                    if (TelCallForwardCmd.this.listener != null) {
                        TelCallForwardCmd.this.listener.responseCallForward(null, 65537, TelCallForwardCmd.this.terminalID);
                    }
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void setAbortedByUser(boolean bl) {
        this.logger.log(10000000, "[TelCallForwardCmd#setAbortedByUser] abortedByUser=%1", bl);
        this.abortedByUser = bl;
    }

    protected Command canceled() {
        if (this.abortedByUser) {
            this.logger.log(1000000, "[TelCallForwardCmd#canceled] aborted by user!! - returning abort command");
            return new TelAbortServiceCodeRequestCmd(this.dsi, this.logger, this.terminalID, this.abortedByUser, this.listener);
        }
        this.logger.log(10000000, "[TelCallForwardCmd#canceled] not aborted by user.");
        return null;
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelCallForwardCmd#execute] telCFRequestData=%1", (Object)Converter.array2String(this.telCFRequestData));
            this.dsi.requestCallForward(this.telCFRequestData);
        } else {
            this.logger.log(100000, "[TelCallForwardCmd#execute] DSITelephone is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        this.logger.log(1000000, "[TelCallForwardCmd#responseCallForward] telCFResponseData=%1, result=%2", (Object)Converter.array2String(cFResponseDataArray), (long)n);
        if (this.listener != null) {
            this.listener.responseCallForward(cFResponseDataArray, n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

