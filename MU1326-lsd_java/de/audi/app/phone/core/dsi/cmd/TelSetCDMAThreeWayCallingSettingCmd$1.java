/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi.cmd;

import de.audi.app.phone.core.dsi.cmd.TelSetCDMAThreeWayCallingSettingCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class TelSetCDMAThreeWayCallingSettingCmd$1
extends Command {
    private final /* synthetic */ TelSetCDMAThreeWayCallingSettingCmd this$0;

    TelSetCDMAThreeWayCallingSettingCmd$1(TelSetCDMAThreeWayCallingSettingCmd telSetCDMAThreeWayCallingSettingCmd, LogChannel logChannel, String string) {
        this.this$0 = telSetCDMAThreeWayCallingSettingCmd;
        super(logChannel, string);
    }

    @Override
    public void execute() {
        this.logger.log(-1601830656, "[TelSetCDMAThreeWayCallingSettingCmd.schedule().new Command() {...}#execute] Error.");
        if (this.this$0.listener != null) {
            this.this$0.listener.responseSetCDMAThreeWayCallingSetting(0x1000100, this.this$0.terminalID);
        }
        this.getCommandList().commandFinished();
    }
}

