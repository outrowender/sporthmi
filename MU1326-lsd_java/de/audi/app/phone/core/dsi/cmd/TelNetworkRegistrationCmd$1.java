/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelNetworkRegistrationCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelNetworkRegistrationCmd$1
extends Command {
    private final /* synthetic */ TelNetworkRegistrationCmd this$0;

    TelNetworkRegistrationCmd$1(TelNetworkRegistrationCmd telNetworkRegistrationCmd, LogChannel logChannel, String string) {
        this.this$0 = telNetworkRegistrationCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        if (!TelNetworkRegistrationCmd.access$000(this.this$0)) {
            this.logger.log(-1601830656, "[TelNetworkRegistrationCmd.schedule().new Command() {...}#execute] Error.");
            if (this.this$0.listener != null) {
                this.this$0.listener.responseNetworkRegistration(0x1000100, this.this$0.terminalID);
            }
        }
        this.getCommandList().commandFinished();
    }
}

