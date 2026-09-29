/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelResetMissedCallIndicator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelResetMissedCallIndicator$1
extends Command {
    private final /* synthetic */ TelResetMissedCallIndicator this$0;

    TelResetMissedCallIndicator$1(TelResetMissedCallIndicator telResetMissedCallIndicator, LogChannel logChannel, String string) {
        this.this$0 = telResetMissedCallIndicator;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelResetMissedCallIndicator.schedule().new Command() {...}#execute] Error.");
        this.getCommandList().commandFinished();
    }
}

