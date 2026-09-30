/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.CFResponseData;

public class TelAbortServiceCodeRequestCmd
extends AbstractTelDSIMECommand {
    public TelAbortServiceCodeRequestCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, boolean bl, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelAbortServiceCodeRequestCmd", n, iTelDSIResponseListener);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1000000, "[TelAbortServiceCodeRequestCmd#execute]");
            this.dsi.requestServiceCodeAbort();
        } else {
            this.logger.log(100000, "[TelAbortServiceCodeRequestCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseServiceCodeAbort(int n) {
        this.logger.log(1000000, "[TelAbortServiceCodeRequestCmd#responseServiceCodeAbort] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseServiceCodeAbort(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        this.logger.log(1000000, "[TelAbortServiceCodeRequestCmd#responseCallForward] telCFResponseData=%1, result=%2", (Object)Converter.array2String(cFResponseDataArray), (long)n);
        if (this.listener != null) {
            this.listener.responseCallForward(cFResponseDataArray, n, this.terminalID);
        }
    }

    public void responseCallWaiting(int n, int n2) {
        this.logger.log(1000000, "[TelAbortServiceCodeRequestCmd#responseCallWaiting] int telCWStatus=%1, result=%2", (long)n, (long)n2);
        if (this.listener != null) {
            this.listener.responseCallWaiting(-1, n, n2, this.terminalID);
        }
    }

    public void responseCLIR(int n, int n2, int n3) {
        this.logger.log(1000000, "[TelAbortServiceCodeRequestCmd#responseCLIR] telCLIRState=%1, telCLIRNWState=%2, result=%3", (long)n, (long)n2, (long)n3);
        if (this.listener != null) {
            this.listener.responseCLIR(n, n2, n3, this.terminalID);
        }
    }
}

