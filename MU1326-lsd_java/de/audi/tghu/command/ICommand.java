/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.ICommandList;
import org.dsi.ifc.base.DSIListener;

public interface ICommand
extends DSIListener {
    default public ICommandList getCommandList() {
    }

    default public void setCommandList(ICommandList iCommandList) {
    }

    default public void execute() {
    }

    default public void abort() {
    }

    default public long getTimeout() {
    }

    default public String getName() {
    }
}

