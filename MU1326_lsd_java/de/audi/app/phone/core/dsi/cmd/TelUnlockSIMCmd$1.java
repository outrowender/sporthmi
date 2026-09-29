/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelUnlockSIMCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelUnlockSIMCmd$1
extends Command {
    private final /* synthetic */ TelUnlockSIMCmd this$0;

    TelUnlockSIMCmd$1(TelUnlockSIMCmd telUnlockSIMCmd, LogChannel logChannel, String string) {
        this.this$0 = telUnlockSIMCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelUnlockSIMCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseUnlockSIM(0x1000100, this.this$0.terminalID, null);
        }
        this.getCommandList().commandFinished();
    }
}

