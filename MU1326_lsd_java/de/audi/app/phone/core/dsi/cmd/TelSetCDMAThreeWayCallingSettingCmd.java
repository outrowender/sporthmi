/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetCDMAThreeWayCallingSettingCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSetCDMAThreeWayCallingSettingCmd
extends AbstractTelDSIMECommand {
    private final boolean cdmaThreeWayCallingSetting;

    public TelSetCDMAThreeWayCallingSettingCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetCDMAThreeWayCallingSettingCmd", n, iTelDSIResponseListener);
        this.cdmaThreeWayCallingSetting = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetCDMAThreeWayCallingSettingCmd.schedule(commandListManager, this, "TelSetCDMAThreeWayCallingSettingCmd", new TelSetCDMAThreeWayCallingSettingCmd$1(this, this.logger, "TelSetCDMAThreeWayCallingSettingCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSetCDMAThreeWayCallingSettingCmd#execute] cdmaThreeWayCallingSetting=%1", this.cdmaThreeWayCallingSetting);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetCDMAThreeWayCallingSetting(this.cdmaThreeWayCallingSetting);
        } else {
            this.logger.log(-1601830656, "[TelSetCDMAThreeWayCallingSettingCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n) {
        this.logger.log(1078071040, "[TelSetCDMAThreeWayCallingSettingCmd#responseSetCDMAThreeWayCallingSetting] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetCDMAThreeWayCallingSetting(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

