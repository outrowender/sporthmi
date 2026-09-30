/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;
import java.util.Collection;

public interface ICommandList {
    public CommandListManager getManager();

    public Collection getCommands();

    public String getName();

    public String getInvocationSource();

    public ICommandList add(Command var1);

    public ICommandList add(int var1, Command var2);

    public ICommandList add(CommandList var1);

    public ICommandList add(int var1, CommandList var2);

    public ICommandList add(Collection var1);

    public ICommandList add(int var1, Collection var2);

    public void execute(String var1);

    public void commandFinishedWithPostCommand(Command var1);

    public void commandFinishedWithPostSequence(CommandList var1);

    public int getPos();

    public int size();

    public boolean hasActiveCommand();

    public Command getActiveCommand();

    public Command getErrorCommand();

    public void setErrorCommand(Command var1);

    public void commandFinished();

    public void stop(String var1);

    public void commandAborted(long var1);

    public void commandAborted(Exception var1);

    public void commandAborted(String var1, String var2);

    public void commandAborted(String var1);

    public void addMonitor(Monitor var1);

    public void put(Object var1, Object var2);

    public Object get(Object var1);

    public Object remove(Object var1);

    public String toString();
}

