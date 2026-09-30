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
    public static final long COMMAND_TIMEOUT_HIGH = 60000L;
    public static final long COMMAND_TIMEOUT_NONE = -1L;
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

    public ICommandList getCommandList() {
        return this.commandList;
    }

    public void setCommandList(ICommandList iCommandList) {
        this.commandList = iCommandList;
    }

    public abstract void execute();

    public void abort() {
        this.logger.log(10000000, "[Command#abort] %1", (Object)this);
    }

    protected Command canceled() {
        return null;
    }

    public long getTimeout() {
        return 60000L;
    }

    public String getName() {
        if (this.name == null) {
            this.setName(this.getClass().getName());
        }
        return this.name;
    }

    protected final void setName(String string) {
        this.name = string;
    }

    public String toString() {
        return this.getName();
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(10000000, "[Command#asyncException] Called, error message: %1, error code: %2, request type: %3 ", (Object)string, (long)n, (long)n2);
    }
}

