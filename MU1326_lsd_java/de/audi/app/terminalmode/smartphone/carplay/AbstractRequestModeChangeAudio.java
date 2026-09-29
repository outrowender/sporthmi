/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.carplay.AbstractRequestModeChangeAudio$1;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public abstract class AbstractRequestModeChangeAudio
extends AbstractDSICommand {
    private static final String LOGCLASS;
    protected final TMState newState;
    private final IStateHandler stateHandler;

    public AbstractRequestModeChangeAudio(LogChannel logChannel, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, TMState tMState, IStateHandler iStateHandler) {
        super(logChannel, "RequestModeChangeAudio", iContext, iDSISmartphoneManager);
        this.newState = tMState;
        this.stateHandler = iStateHandler;
    }

    @Override
    protected Command canceled() {
        this.logger.log(-1601830656, "[RequestModeChangeAudio.canceled] no response");
        return new AbstractRequestModeChangeAudio$1(this, this.logger);
    }

    static /* synthetic */ IStateHandler access$000(AbstractRequestModeChangeAudio abstractRequestModeChangeAudio) {
        return abstractRequestModeChangeAudio.stateHandler;
    }
}

