/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetAutomaticEmergencyCallActiveCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetAutomaticEmergencyCallActiveCmd$1
extends Command {
    private final /* synthetic */ TelSetAutomaticEmergencyCallActiveCmd this$0;

    TelSetAutomaticEmergencyCallActiveCmd$1(TelSetAutomaticEmergencyCallActiveCmd telSetAutomaticEmergencyCallActiveCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetAutomaticEmergencyCallActiveCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetAutomaticEmergencyCallActiveCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetAutomaticEmergencyCallActive(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

