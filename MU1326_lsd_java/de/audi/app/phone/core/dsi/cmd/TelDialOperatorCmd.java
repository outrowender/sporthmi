/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseErrorHandler;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelDialOperatorCmd$1;
import de.audi.atip.log.LogChannel;
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
        TelDialOperatorCmd.schedule(commandListManager, this, "TelDialOperatorCmd", new TelDialOperatorCmd$1(this, this.logger, "TelDialOperatorCmdCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelDialOperatorCmd#execute] telNumber=%1, callType=%2", (Object)this.telNumber, (long)this.callType);
        if (this.telNumber != null && this.telNumber.length() > 0) {
            if (this.isDSIAvailable()) {
                this.dsi.dialOperator(this.callType, this.telNumber);
            } else {
                this.logger.log(-1601830656, "[TelDialOperatorCmd#execute] dsi is null!");
                this.getCommandList().commandFinished();
            }
        } else {
            this.logger.log(1078071040, "[TelDialOperatorCmd#execute] number is null or empty --> NOP!");
            if (this.listener != null) {
                this.listener.responseDialNumber(0x3000100, -1, null, this.terminalID);
            }
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (n == 1 && serviceCodeTypeStruct != null) {
            this.logger.log(-2137614336, "[TelDialOperatorCmd#updateServiceCodeType] serviceCodeType=%1", (Object)serviceCodeTypeStruct);
            this.dialNumberType = serviceCodeTypeStruct.getTelDialNumberType();
        }
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        this.logger.log(1078071040, "[TelDialOperatorCmd#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        if (this.listener != null) {
            this.listener.responseDialOperator(n, suppServiceResponseStruct, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

