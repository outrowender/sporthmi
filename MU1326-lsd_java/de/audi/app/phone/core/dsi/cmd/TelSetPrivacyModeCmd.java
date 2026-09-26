/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetPrivacyModeCmd$1;
import de.audi.atip.log.LogChannel;
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
        TelSetPrivacyModeCmd.schedule(commandListManager, this, "TelSetPrivacyModeCmd", new TelSetPrivacyModeCmd$1(this, this.logger, "TelSetPrivacyModeCmdError"), monitor);
    }

    @Override
    public void execute() {
        if (this.isDSIAvailable()) {
            this.dsi.requestSetPrivacyMode(this.privacyMode);
        } else {
            this.logger.log(-1601830656, "[TelSetPrivacyModeCmd#execute] dsi is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void responseSetPrivacyMode(int n) {
        this.logger.log(1078071040, "[TelSetPrivacyModeCmd#responseSetPrivacyMode] result=%1", (long)n);
        if (this.listener != null) {
            this.listener.responseSetPrivacyMode(n, this.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

