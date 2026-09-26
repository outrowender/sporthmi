/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentRequestWrapper;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.cmd.AbstractTelDSIMECommand;
import de.audi.app.phone.core.dsi.cmd.TelIncreaseMicGainLevelCmd$1;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class TelIncreaseMicGainLevelCmd
extends AbstractTelDSIMECommand {
    private final short steps;

    public TelIncreaseMicGainLevelCmd(short s, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelIncreaseMicGainLevelCmd", n, iTelDSIResponseListener);
        this.steps = s;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelIncreaseMicGainLevelCmd.schedule(commandListManager, this, "TelIncreaseMicGainLevelCmd", new TelIncreaseMicGainLevelCmd$1(this, this.logger, "TelIncreaseMicGainLevelCmdError"), monitor);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelIncreaseMicGainLevelCmd#execute] steps=%1", (long)this.steps);
        if (this.isDSIAvailable()) {
            this.dsi.requestIncreaseMicGainLevel(this.steps);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-1601830656, "[TelIncreaseMicGainLevelCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }
}

