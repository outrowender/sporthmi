/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

class HighPriorityResourceTracker$5
extends AbstractCommand {
    private final /* synthetic */ Resource val$resource;
    private final /* synthetic */ HighPriorityResourceTracker this$0;

    HighPriorityResourceTracker$5(HighPriorityResourceTracker highPriorityResourceTracker, LogChannel logChannel, String string, IContext iContext, Resource resource) {
        this.this$0 = highPriorityResourceTracker;
        this.val$resource = resource;
        super(logChannel, string, iContext);
    }

    @Override
    public void execute() {
        TMState tMState = HighPriorityResourceTracker.access$600(this.this$0).getCurrentState();
        tMState.restrictAccessTo(this.val$resource);
        CommandList commandList = HighPriorityResourceTracker.access$600(this.this$0).changeState(tMState, IRequestor.MAINUNIT, -1L);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

