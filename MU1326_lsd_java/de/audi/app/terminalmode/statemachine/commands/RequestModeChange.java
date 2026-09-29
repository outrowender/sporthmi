/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange$1;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange$2;
import de.audi.tghu.command.Command;

public class RequestModeChange
extends AbstractDSICommand {
    private static final String LOGCLASS;
    private final TMState newState;
    private final long messageId;
    private final IStateHandler stateHandler;

    public RequestModeChange(IContext iContext, TMState tMState, long l, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "RequestModeChange", iContext, iContext.getSmartphoneDSIManager());
        this.newState = tMState;
        this.messageId = l;
        this.stateHandler = iStateHandler;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"RequestModeChange");
        TMDevice tMDevice = this.context.getDeviceManager().getActiveDevice();
        if (null == tMDevice || tMDevice.connectionState().is(TMDevice$ConnectionState.NOT_ATTACHED)) {
            this.stateHandler.updateState(this.newState);
            this.getCommandList().commandFinished();
        }
        this.dsiSmartphoneManager.requestModeChange(this.newState, "user action", new RequestModeChange$1(this));
    }

    @Override
    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
        this.logger.log(1078071040, "[%1.updateStates]", (Object)"RequestModeChange");
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.updateCurrentAppState(iAppStateArray);
        tMState.updateCurrentResourceState(iResourceArray);
        boolean bl = TerminalModeUtils.compareTMStateAfterDSIUpdate((TMState)this.newState, (TMState)tMState);
        if (bl) {
            this.stateHandler.updateState(this.newState);
        }
        this.getCommandList().commandFinished();
        return bl;
    }

    @Override
    protected Command canceled() {
        this.logger.log(-1601830656, "[RequestModeChange.canceled] no response");
        return new RequestModeChange$2(this, this.logger);
    }

    static /* synthetic */ TMState access$000(RequestModeChange requestModeChange) {
        return requestModeChange.newState;
    }

    static /* synthetic */ IStateHandler access$100(RequestModeChange requestModeChange) {
        return requestModeChange.stateHandler;
    }
}

