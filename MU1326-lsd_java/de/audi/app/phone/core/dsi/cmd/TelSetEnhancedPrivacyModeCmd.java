/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetEnhancedPrivacyModeCmd$1;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSetEnhancedPrivacyModeCmd
extends AbstractTelDSIMECommand {
    private final boolean enhancedPrivacyMode;

    public TelSetEnhancedPrivacyModeCmd(boolean bl, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelEPMHandler iTelEPMHandler) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetEnhancedPrivacyModeCmd", n, iTelDSIResponseListener);
        this.enhancedPrivacyMode = bl;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetEnhancedPrivacyModeCmd.schedule(commandListManager, this, "TelSetEnhancedPrivacyModeCmd", new TelSetEnhancedPrivacyModeCmd$1(this, this.logger, "TelSetEnhancedPrivacyModeCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSetEnhancedPrivacyModeCmd#execute] enhancedPrivacyMode=%1", this.enhancedPrivacyMode);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetEnhancedPrivacyMode(this.enhancedPrivacyMode);
        } else {
            this.logger.log(-1601830656, "[TelSetEnhancedPrivacyModeCmd#execute] dsi is null!");
        }
        this.getCommandList().commandFinished();
    }
}

