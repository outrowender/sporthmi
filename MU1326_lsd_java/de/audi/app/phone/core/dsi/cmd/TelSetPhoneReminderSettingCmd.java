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

public class TelSetPhoneReminderSettingCmd
extends AbstractTelDSIMECommand {
    private final boolean phoneReminderSetting;

    public TelSetPhoneReminderSettingCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetPhoneReminderSettingCmd", n, iTelDSIResponseListener);
        this.phoneReminderSetting = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetPhoneReminderSettingCmd.schedule(commandListManager, this, "TelSetPhoneReminderSettingCmd", new Command(this.logger, "TelSetPhoneReminderSettingCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetPhoneReminderSettingCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetPhoneReminderSettingCmd.this.listener != null) {
                    TelSetPhoneReminderSettingCmd.this.listener.responseSetPhoneReminderSetting(65537, TelSetPhoneReminderSettingCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelSetPhoneReminderSettingCmd#execute] phoneReminderSetting=%1", this.phoneReminderSetting);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetPhoneReminderSetting(this.phoneReminderSetting);
        } else {
            this.logger.log(100000, "[TelSetPhoneReminderSettingCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetPhoneReminderSetting(int n) {
        this.logger.log(1000000, "[TelSetPhoneReminderSettingCmd#responseSetPhoneReminderSetting] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetPhoneReminderSetting(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

