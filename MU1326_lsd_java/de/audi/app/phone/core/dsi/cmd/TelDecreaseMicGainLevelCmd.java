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

public class TelDecreaseMicGainLevelCmd
extends AbstractTelDSIMECommand {
    private final short steps;

    public TelDecreaseMicGainLevelCmd(short s, ITelDSIMobileEquipmentRequestWrapper iTelDSIMobileEquipmentRequestWrapper, LogChannel logChannel, int n, ITelDSIResponseListener iTelDSIResponseListener) {
        super(iTelDSIMobileEquipmentRequestWrapper, logChannel, "TelDecreaseMicGainLevelCmd", n, iTelDSIResponseListener);
        this.steps = s;
    }

    public void schedule(CommandListManager commandListManager, Monitor monitor) {
        TelDecreaseMicGainLevelCmd.schedule(commandListManager, this, "TelDecreaseMicGainLevelCmd", new Command(this.logger, "TelDecreaseMicGainLevelCmdError"){

            public void execute() {
                this.logger.log(100000, "[TelDecreaseMicGainLevelCmd.schedule().new Command() {...}#execute] Error.");
                this.getCommandList().commandFinished();
            }
        }, monitor);
    }

    public void execute() {
        this.logger.log(1000000, "[TelDecreaseMicGainLevelCmd#execute] steps=%1", (long)this.steps);
        if (this.isDSIAvailable()) {
            this.dsi.requestDecreaseMicGainLevel(this.steps);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(100000, "[TelDecreaseMicGainLevelCmd#execute] dsi is null!");
            this.getCommandList().commandFinished();
        }
    }
}

