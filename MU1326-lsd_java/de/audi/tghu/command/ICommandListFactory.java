/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.CommandList;

public interface ICommandListFactory {
    default public CommandList createCommandList() {
    }

    default public CommandList createCommandList(int n) {
    }
}

