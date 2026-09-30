/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.base.DSIListener;

public interface ICommandResponseSupplier {
    public DSIListener getDSIDefaultHandler();

    public CommandList getActiveCommandList();

    public LogChannel getLogChannel();

    public String getHandlerName();
}

