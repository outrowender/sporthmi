/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
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
        TelSetCDMAThreeWayCallingSettingCmd.schedule(commandListManager, this, "TelSetCDMAThreeWayCallingSettingCmd", new Command(this.logger, "TelSetCDMAThreeWayCallingSettingCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetCDMAThreeWayCallingSettingCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetCDMAThreeWayCallingSettingCmd.this.listener != null) {
                    TelSetCDMAThreeWayCallingSettingCmd.this.listener.responseSetCDMAThreeWayCallingSetting(65537, TelSetCDMAThreeWayCallingSettingCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetCDMAThreeWayCallingSettingCmd#execute] cdmaThreeWayCallingSetting=%1", this.cdmaThreeWayCallingSetting);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetCDMAThreeWayCallingSetting(this.cdmaThreeWayCallingSetting);
        } else {
            this.logger.log(100000, "[TelSetCDMAThreeWayCallingSettingCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetCDMAThreeWayCallingSetting(int n) {
        this.logger.log(1000000, "[TelSetCDMAThreeWayCallingSettingCmd#responseSetCDMAThreeWayCallingSetting] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetCDMAThreeWayCallingSetting(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

