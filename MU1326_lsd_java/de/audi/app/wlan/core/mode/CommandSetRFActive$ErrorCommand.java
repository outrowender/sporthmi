/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.mode;

import de.audi.app.wlan.core.mode.CommandSetRFActive;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public class CommandSetRFActive$ErrorCommand
extends Command {
    private final /* synthetic */ CommandSetRFActive this$0;

    public CommandSetRFActive$ErrorCommand(CommandSetRFActive commandSetRFActive, LogChannel logChannel) {
        this.this$0 = commandSetRFActive;
        super(logChannel);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "CommandSetRFActive#errorCommand()");
        CommandSetRFActive.access$000(this.this$0, 1);
        this.commandList.commandFinished();
    }
}

