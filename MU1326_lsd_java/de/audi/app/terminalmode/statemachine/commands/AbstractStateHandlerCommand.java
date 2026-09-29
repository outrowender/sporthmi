/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;

public abstract class AbstractStateHandlerCommand
extends AbstractCommand {
    protected final IStateHandler stateHandler;

    public AbstractStateHandlerCommand(LogChannel logChannel, String string, IContext iContext, IStateHandler iStateHandler) {
        super(logChannel, string, iContext);
        this.stateHandler = iStateHandler;
    }
}

