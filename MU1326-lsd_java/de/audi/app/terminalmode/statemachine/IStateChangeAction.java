/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

public interface IStateChangeAction {
    default public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
    }
}

