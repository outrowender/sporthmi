/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.command;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.Monitor;

public abstract class AbstractCommand
extends Command {
    protected final DictationComponentManager dictationComponentManager;

    protected AbstractCommand(DictationComponentManager dictationComponentManager) {
        super(dictationComponentManager.getFramework().getLogChannel("App.SDS.Dictation"));
        this.dictationComponentManager = dictationComponentManager;
    }

    protected final void schedule() {
        CommandList commandList = new CommandList(this.dictationComponentManager.getDispatcherManager().getCommandListManager());
        commandList.add(this);
        commandList.setErrorCommand(this.getErrorCommand());
        commandList.execute(this.getName());
    }

    protected final void schedule(Monitor monitor) {
        CommandList commandList = new CommandList(this.dictationComponentManager.getDispatcherManager().getCommandListManager());
        commandList.addMonitor(monitor);
        commandList.add(this);
        commandList.setErrorCommand(this.getErrorCommand());
        commandList.execute(this.getName());
    }

    protected Command getErrorCommand() {
        return null;
    }

    protected final void logUnhandledResultType(String string) {
        this.logger.log(-1601830656, "%1 Unhandled result type.");
    }

    protected final void logException(String string, Exception exception) {
        DictationUtil.logException(this.logger, exception, string);
    }

    protected final void logNullParameter(String string) {
        DictationUtil.logNullParameter(this.logger, string);
    }
}

