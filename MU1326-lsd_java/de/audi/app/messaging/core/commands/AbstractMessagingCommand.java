/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.commands;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.commands.AbstractMessagingCommand$1;
import de.audi.app.messaging.core.commands.ICommandCallback;
import de.audi.app.messaging.core.concurrent.ExecutionException;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.Monitor;

public abstract class AbstractMessagingCommand
extends Command {
    protected final AbstractMsgApplication msgApp;
    private volatile boolean hasTerminated = false;
    private volatile Throwable exceptionCause = null;
    private volatile Object result = null;
    private volatile ICommandCallback commandCallback = null;

    protected AbstractMessagingCommand(AbstractMsgApplication abstractMsgApplication) {
        super(abstractMsgApplication.getFramework().getLogChannel("App.Messaging.Main"));
        this.msgApp = abstractMsgApplication;
    }

    public final Object getResult() {
        if (this.exceptionCause != null) {
            throw new ExecutionException(this.exceptionCause);
        }
        return this.result;
    }

    protected final void setResult(Object object) {
        if (!this.hasTerminated) {
            this.result = object;
            this.terminate();
        }
    }

    protected final void setExceptionCause(Throwable throwable) {
        if (!this.hasTerminated) {
            this.exceptionCause = throwable;
            this.terminate();
        }
    }

    protected final void setCommandCallback(ICommandCallback iCommandCallback) {
        this.commandCallback = iCommandCallback;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void terminate() {
        try {
            if (!this.hasTerminated && this.commandCallback != null) {
                this.commandCallback.terminating(this);
            }
        }
        catch (Exception exception) {
            this.logException("[AbstractMessagingCommand#terminate]", exception);
        }
        finally {
            this.hasTerminated = true;
            if (this.getCommandList().getActiveCommand() == this) {
                this.getCommandList().commandFinished();
            }
        }
    }

    public final void schedule() {
        CommandList commandList = new CommandList(this.msgApp.getExecutorManager().getCommandListManager());
        commandList.add(this);
        commandList.setErrorCommand(this.getErrorCommand());
        commandList.execute(this.getName());
    }

    public final void schedule(Monitor monitor) {
        CommandList commandList = new CommandList(this.msgApp.getExecutorManager().getCommandListManager());
        commandList.addMonitor(monitor);
        commandList.add(this);
        commandList.setErrorCommand(this.getErrorCommand());
        commandList.execute(this.getName());
    }

    public Command getErrorCommand() {
        return new AbstractMessagingCommand$1(this, this.msgApp);
    }

    protected final void logUnhandledResultType(String string) {
        this.logger.log(-1601830656, "%1 Unhandled result type.", (Object)string);
    }

    protected final void logException(String string, Exception exception) {
        Logs.logException(this.logger, exception, string);
    }

    protected final void logNullParameter(String string) {
        Logs.logNullParameter(this.logger, string);
    }
}

