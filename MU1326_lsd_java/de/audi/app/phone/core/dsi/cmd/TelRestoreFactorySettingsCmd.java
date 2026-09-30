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

public class TelRestoreFactorySettingsCmd
extends AbstractTelDSIMECommand {
    public TelRestoreFactorySettingsCmd(ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelRestoreFactorySettingsCmd", n, iTelDSIResponseListener);
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelRestoreFactorySettingsCmd.schedule(commandListManager, this, "TelRestoreFactorySettingsCmd", new Command(this.logger, "TelRestoreFactorySettingsCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelRestoreFactorySettingsCmd.schedule().new Command() {...}#execute] Error.");
                if (TelRestoreFactorySettingsCmd.this.listener != null) {
                    TelRestoreFactorySettingsCmd.this.listener.responseRestoreFactorySettings(65537, TelRestoreFactorySettingsCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelRestoreFactorySettingsCmd#execute] called.");
        if (this.isDSIAvailable()) {
            this.dsi.restoreFactorySettings();
        } else {
            this.logger.log(100000, "[TelRestoreFactorySettingsCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseRestoreFactorySettings(int n) {
        this.logger.log(1000000, "[TelRestoreFactorySettingsCmd#responseRestoreFactorySettings] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseRestoreFactorySettings(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

