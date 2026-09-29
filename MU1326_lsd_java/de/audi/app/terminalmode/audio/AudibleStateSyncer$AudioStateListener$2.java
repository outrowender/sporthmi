/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$AudioStateListener;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

class AudibleStateSyncer$AudioStateListener$2
extends AbstractStateHandlerCommand {
    private final /* synthetic */ AudibleStateSyncer$AudioStateListener this$1;

    AudibleStateSyncer$AudioStateListener$2(AudibleStateSyncer$AudioStateListener audibleStateSyncer$AudioStateListener, LogChannel logChannel, String string, IContext iContext, IStateHandler iStateHandler) {
        this.this$1 = audibleStateSyncer$AudioStateListener;
        super(logChannel, string, iContext, iStateHandler);
    }

    @Override
    public void execute() {
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
        this.logger.log(1078071040, "[%1.execute] new state=%2", (Object)"AudibleStateSyncer", (Object)tMState.toString());
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

