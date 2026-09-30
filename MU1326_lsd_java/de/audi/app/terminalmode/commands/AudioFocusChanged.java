/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.tghu.command.CommandList;

public class AudioFocusChanged
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS = "AudioFocusChanged";
    private final boolean hasAudioFocus;

    public AudioFocusChanged(IContext iContext, boolean bl, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iStateHandler);
        this.hasAudioFocus = bl;
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.setOwnerForResource(Resource.AUDIO_MEDIA, this.hasAudioFocus ? ResourceOwner.DEVICE : ResourceOwner.MAINUNIT);
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

