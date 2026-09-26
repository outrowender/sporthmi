/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.RequestChangeTopologyCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class RequestChangeTopologyCmd$1
extends Command {
    private final /* synthetic */ RequestChangeTopologyCmd this$0;

    RequestChangeTopologyCmd$1(RequestChangeTopologyCmd requestChangeTopologyCmd, LogChannel logChannel, String string) {
        this.this$0 = requestChangeTopologyCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[RequestChangeTopologyCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseChangeTopology(0x1000100, this.this$0.getTerminalID());
        }
        this.getCommandList().commandFinished();
    }
}

