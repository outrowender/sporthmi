/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import java.util.Collection;

public class ConvenientCommandList
extends CommandList {
    public ConvenientCommandList(CommandListManager commandListManager) {
        super(commandListManager);
    }

    public ConvenientCommandList addSingle(Command command) {
        this.add(command);
        return this;
    }

    public ConvenientCommandList addAll(Collection collection) {
        this.add(collection);
        return this;
    }
}

