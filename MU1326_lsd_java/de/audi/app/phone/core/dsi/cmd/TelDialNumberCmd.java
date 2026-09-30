/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.suppservices.ITelDialSuppServiceHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class TelDialNumberCmd
extends AbstractTelDSIMECommand {
    protected final String telNumber;
    private volatile int dialNumberType;
    private final ITelDialSuppServiceHandler suppServiceHandler;

    public TelDialNumberCmd(String string, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDialSuppServiceHandler iTelDialSuppServiceHandler) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelDialNumberCmd", n, iTelDSIResponseListener);
        this.telNumber = string;
        this.suppServiceHandler = iTelDialSuppServiceHandler;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelDialNumberCmd.schedule(commandListManager, this, "TelDialNumberCmd", new Command(this.logger, "TelDialNumberCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelDialNumberCmd.schedule().new Command() {...}#execute] Error.");
                if (TelDialNumberCmd.this.listener != null) {
                    TelDialNumberCmd.this.listener.responseDialNumber(65537, -1, null, TelDialNumberCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelDialNumberCmd#execute] dialing number %1", (Object)this.telNumber);
        if (this.telNumber != null && this.telNumber.length() > 0) {
            if (this.isDSIAvailable()) {
                this.dsi.dialNumber(this.telNumber);
            } else {
                this.logger.log(100000, "[TelDialNumberCmd#execute] dsi is null!");
                this.getCommandList().commandFinished();
            }
        } else {
            this.logger.log(1000000, "[TelDialNumberCmd#execute] number is null or empty --> NOP!");
            if (this.listener != null) {
                this.listener.responseDialNumber(65539, 0, null, this.terminalID);
            }
            this.getCommandList().commandFinished();
        }
    }

    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (n == 1 && serviceCodeTypeStruct != null) {
            this.logger.log(10000000, "[TelDialNumberCmd#updateServiceCodeType] serviceCodeType=%1", (Object)serviceCodeTypeStruct);
            this.dialNumberType = serviceCodeTypeStruct.getTelDialNumberType();
            if (this.dialNumberType == 2 || this.dialNumberType == 1) {
                this.suppServiceHandler.updateServiceCodeType(serviceCodeTypeStruct, n);
            }
        }
    }

    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        this.logger.log(1000000, "[TelDialNumberCmd#responseDialNumber] result=%2, telSuppServResult=%1", (Object)suppServiceResponseStruct, (long)n);
        if (this.listener != null) {
            this.listener.responseDialNumber(n, this.dialNumberType, suppServiceResponseStruct, this.terminalID);
        }
        this.suppServiceHandler.responseDialNumber(n, suppServiceResponseStruct);
        this.getCommandList().commandFinished();
    }
}

