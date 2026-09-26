/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetTelPowerCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetTelPowerCmd$1
extends Command {
    private final /* synthetic */ TelSetTelPowerCmd this$0;

    TelSetTelPowerCmd$1(TelSetTelPowerCmd telSetTelPowerCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetTelPowerCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetTelPowerCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseTelPower(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

