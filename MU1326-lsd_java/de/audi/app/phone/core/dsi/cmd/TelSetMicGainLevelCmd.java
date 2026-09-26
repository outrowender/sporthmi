/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelSetMicGainLevelCmd$1;
import de.audi.app.phone.core.epm.ITelEPMHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelSetMicGainLevelCmd
extends AbstractTelDSIMECommand {
    private final int micGainLevel;

    public TelSetMicGainLevelCmd(int n, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelEPMHandler iTelEPMHandler) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelSetMicGainLevelCmd", n2, iTelDSIResponseListener);
        this.micGainLevel = n;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelSetMicGainLevelCmd.schedule(commandListManager, this, "TelSetMicGainLevelCmd", new TelSetMicGainLevelCmd$1(this, this.logger, "TelSetMicGainLevelCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelSetMicGainLevelCmd#execute] micGainLevel=%1", (long)this.micGainLevel);
        if (this.isDSIAvailable()) {
            this.dsi.requestSetMicGainLevel(this.micGainLevel);
        } else {
            this.logger.log(-1601830656, "[TelSetMicGainLevelCmd#execute] dsi is null!");
        }
        this.getCommandList().commandFinished();
    }
}

