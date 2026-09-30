/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public abstract class AbstractRequestModeChangeAudio
extends AbstractDSICommand {
    private static final String LOGCLASS = "RequestModeChangeAudio";
    protected final TMState newState;
    private final IStateHandler stateHandler;

    public AbstractRequestModeChangeAudio(LogChannel logChannel, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, TMState tMState, IStateHandler iStateHandler) {
        super(logChannel, LOGCLASS, iContext, iDSISmartphoneManager);
        this.newState = tMState;
        this.stateHandler = iStateHandler;
    }

    protected Command canceled() {
        this.logger.log(100000, "[RequestModeChangeAudio.canceled] no response");
        return new Command(this.logger){

            public void execute() {
                AbstractRequestModeChangeAudio.this.stateHandler.updateState(AbstractRequestModeChangeAudio.this.newState);
                this.getCommandList().commandFinished();
            }

            public String getName() {
                return "RequestModeChangeAudio.canceled -> Continue CommandList";
            }
        };
    }
}

