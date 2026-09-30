/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseErrorHandler;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelDialOperatorCmd
extends AbstractTelDSIMECommand {
    private final String telNumber;
    private final int callType;
    private volatile int dialNumberType;

    public TelDialOperatorCmd(String string, int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseErrorHandler iTelDSIResponseErrorHandler, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelDialOperatorCmd", n2, iTelDSIResponseListener);
        this.telNumber = string;
        this.callType = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelDialOperatorCmd.schedule(commandListManager, this, "TelDialOperatorCmd", new Command(this.logger, "TelDialOperatorCmdCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelDialOperatorCmd.schedule().new Command() {...}#execute] Error.");
                if (TelDialOperatorCmd.this.listener != null) {
                    TelDialOperatorCmd.this.listener.responseDialOperator(65537, null, TelDialOperatorCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelDialOperatorCmd#execute] telNumber=%1, callType=%2", (Object)this.telNumber, (long)this.callType);
        if (this.telNumber != null && this.telNumber.length() > 0) {
            if (this.isDSIAvailable()) {
                this.dsi.dialOperator(this.callType, this.telNumber);
            } else {
                this.logger.log(100000, "[TelDialOperatorCmd#execute] dsi is null!");
                this.getCommandList().commandFinished();
            }
        } else {
            this.logger.log(1000000, "[TelDialOperatorCmd#execute] number is null or empty --> NOP!");
            if (this.listener != null) {
                this.listener.responseDialNumber(65539, -1, null, this.terminalID);
            }
            this.getCommandList().commandFinished();
        }
    }

    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (n == 1 && serviceCodeTypeStruct != null) {
            this.logger.log(10000000, "[TelDialOperatorCmd#updateServiceCodeType] serviceCodeType=%1", (Object)serviceCodeTypeStruct);
            this.dialNumberType = serviceCodeTypeStruct.getTelDialNumberType();
        }
    }

    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        this.logger.log(1000000, "[TelDialOperatorCmd#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        if (this.listener != null) {
            this.listener.responseDialOperator(n, suppServiceResponseStruct, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

