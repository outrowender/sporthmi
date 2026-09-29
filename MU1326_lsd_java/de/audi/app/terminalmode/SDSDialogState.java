/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.SpeechMode;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.tghu.command.CommandList;

public class SDSDialogState
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;
    private final boolean isSDSDialogRunning;

    public SDSDialogState(IContext iContext, boolean bl, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "SDSDialogState", iContext, iStateHandler);
        this.isSDSDialogRunning = bl;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute] dialog %2", (Object)"SDSDialogState", (Object)(this.isSDSDialogRunning ? "started [Owner -> MU][SpeechMode -> RECOGNIZING]" : "stopped [Owner -> NOBODY][SpeechMode -> NONE]"));
        TMState tMState = this.stateHandler.getCurrentState();
        ApplicationOwner applicationOwner = this.isSDSDialogRunning ? ApplicationOwner.MAINUNIT : ApplicationOwner.NOBODY;
        SpeechMode speechMode = this.isSDSDialogRunning ? SpeechMode.RECOGNIZING : SpeechMode.NONE;
        tMState.setOwnerForApplication(Application.SPEECH, applicationOwner);
        tMState.setSpeechMode(speechMode);
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
        this.stateHandler.setOwnerForApplication(Application.SPEECH, applicationOwner);
        this.stateHandler.setSpeechMode(speechMode);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

