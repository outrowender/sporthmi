/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.CommandList;

public interface IAddressInputListener {
    public CommandList getStartCommandList();

    public CommandList getStartCommandList(String var1);
}

