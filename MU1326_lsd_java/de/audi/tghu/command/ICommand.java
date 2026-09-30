/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.ICommandList;
import org.dsi.ifc.base.DSIListener;

public interface ICommand
extends DSIListener {
    public ICommandList getCommandList();

    public void setCommandList(ICommandList var1);

    public void execute();

    public void abort();

    public long getTimeout();

    public String getName();
}

