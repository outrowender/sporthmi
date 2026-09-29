/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;

public class CommandListNull
extends CommandList {
    public CommandListNull(CommandListManager commandListManager) {
        super(commandListManager, 1);
    }

    @Override
    public String toString() {
        return "CommandListNull";
    }
}

