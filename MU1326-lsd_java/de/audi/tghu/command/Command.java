/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.audi.tghu.command.ICommand;
import de.audi.tghu.command.ICommandList;
import org.dsi.ifc.base.DSIListener;

public abstract class Command
implements DSIListener,
ICommand {
    public static final long COMMAND_TIMEOUT_HIGH;
    public static final long COMMAND_TIMEOUT_NONE;
    protected ICommandList commandList;
    protected LogChannel logger;
    protected String name;

    public Command(LogChannel logChannel) {
        this(logChannel, null);
    }

    public Command(LogChannel logChannel, String string) {
        this.logger = logChannel == null ? NullLogChannel.getInstance() : logChannel;
        this.setName(string);
    }

    @Override
    public ICommandList getCommandList() {
        return this.commandList;
    }

    @Override
    public void setCommandList(ICommandList iCommandList) {
        this.commandList = iCommandList;
    }

    @Override
    public abstract void execute() {
    }

    @Override
    public void abort() {
        this.logger.log(-2137614336, "[Command#abort] %1", (Object)this);
    }

    protected Command canceled() {
        return null;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public String getName() {
        if (this.name == null) {
            this.setName(super.getClass().getName());
        }
        return this.name;
    }

    protected final void setName(String string) {
        this.name = string;
    }

    public String toString() {
        return this.getName();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(-2137614336, "[Command#asyncException] Called, error message: %1, error code: %2, request type: %3 ", (Object)string, (long)n, (long)n2);
    }
}

