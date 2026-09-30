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

public class TelSetPrivacyModeCmd
extends AbstractTelDSIMECommand {
    private final boolean privacyMode;

    public TelSetPrivacyModeCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetPrivacyModeCmd", n, iTelDSIResponseListener);
        this.privacyMode = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetPrivacyModeCmd.schedule(commandListManager, this, "TelSetPrivacyModeCmd", new Command(this.logger, "TelSetPrivacyModeCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelSetPrivacyModeCmd.schedule().new Command() {...}#execute] Error.");
                if (TelSetPrivacyModeCmd.this.listener != null) {
                    TelSetPrivacyModeCmd.this.listener.responseSetPrivacyMode(65537, TelSetPrivacyModeCmd.this.terminalID);
                }
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        if (this.isDSIAvailable()) {
            this.dsi.requestSetPrivacyMode(this.privacyMode);
        } else {
            this.logger.log(100000, "[TelSetPrivacyModeCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    public void responseSetPrivacyMode(int n) {
        this.logger.log(1000000, "[TelSetPrivacyModeCmd#responseSetPrivacyMode] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetPrivacyMode(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

