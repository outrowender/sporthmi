/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetAutomaticPinEntryActiveCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetAutomaticPinEntryActiveCmd$1
extends Command {
    private final /* synthetic */ TelSetAutomaticPinEntryActiveCmd this$0;

    TelSetAutomaticPinEntryActiveCmd$1(TelSetAutomaticPinEntryActiveCmd telSetAutomaticPinEntryActiveCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetAutomaticPinEntryActiveCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetAutomaticPinEntryActiveCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetAutomaticEmergencyCallActive(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

