/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.telephoneng.NetworkProvider;

public class TelAbortNetworkSearchCmd
extends AbstractTelDSIMECommand {
    public TelAbortNetworkSearchCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelAbortNetworkSearchCmd", n, iTelDSIResponseListener);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.logger.log(1078071040, "[TelAbortNetworkSearchCmd#execute]");
            this.dsi.requestAbortNetworkSearch();
        } else {
            this.logger.log(-1601830656, "[TelAbortNetworkSearchCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseAbortNetworkSearch(int n) {
        this.logger.log(1078071040, "[TelAbortNetworkSearchCmd#responseAbortNetworkSearch] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseAbortNetworkSearch(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        this.logger.log(1078071040, "[TelAbortNetworkSearchCmd#responseNetworkSearch] telNetworkProviders=%1, result=%2", (Object)Converter.objectToString(networkProviderArray), (long)n);
        if (this.listener != null) {
            this.listener.responseNetworkSearch(networkProviderArray, n, this.terminalID);
        }
    }
}

