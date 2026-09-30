/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.CommandList;

public interface ICommandListFactory {
    public CommandList createCommandList();

    public CommandList createCommandList(int var1);
}

