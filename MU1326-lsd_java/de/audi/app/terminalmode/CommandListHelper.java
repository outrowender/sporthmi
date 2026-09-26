/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.ConvenientCommandList;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;

public class CommandListHelper {
    private final CommandListManager commandListManager;

    public CommandListHelper(CommandListManager commandListManager) {
        this.commandListManager = commandListManager;
    }

    public CommandList createCommandList(Command[] commandArray) {
        CommandList commandList = new CommandList(this.commandListManager);
        for (int i2 = 0; i2 < commandArray.length; ++i2) {
            if (null == commandArray[i2]) continue;
            commandList.add(commandArray[i2]);
        }
        return commandList;
    }

    public CommandList createCommandList(Command command) {
        CommandList commandList = new CommandList(this.commandListManager);
        commandList.add(command);
        return commandList;
    }

    public ConvenientCommandList create() {
        return new ConvenientCommandList(this.commandListManager);
    }
}

