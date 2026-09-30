/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.tghu.command.Command;

public class RequestModeChange
extends AbstractDSICommand {
    private static final String LOGCLASS = "RequestModeChange";
    private final TMState newState;
    private final long messageId;
    private final IStateHandler stateHandler;

    public RequestModeChange(IContext iContext, TMState tMState, long l, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iContext.getSmartphoneDSIManager());
        this.newState = tMState;
        this.messageId = l;
        this.stateHandler = iStateHandler;
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        TMDevice tMDevice = this.context.getDeviceManager().getActiveDevice();
        if (null == tMDevice || tMDevice.connectionState().is(TMDevice.ConnectionState.NOT_ATTACHED)) {
            this.stateHandler.updateState(this.newState);
            this.getCommandList().commandFinished();
        }
        this.dsiSmartphoneManager.requestModeChange(this.newState, "user action", new IDSISmartphoneManager.RequestModeChangeCallback(){

            public void modeChanged() {
                RequestModeChange.this.stateHandler.updateState(RequestModeChange.this.newState);
                RequestModeChange.this.getCommandList().commandFinished();
            }
        });
    }

    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
        this.logger.log(1000000, "[%1.updateStates]", (Object)LOGCLASS);
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.updateCurrentAppState(iAppStateArray);
        tMState.updateCurrentResourceState(iResourceArray);
        boolean bl = TerminalModeUtils.compareTMStateAfterDSIUpdate(this.newState, tMState);
        if (bl) {
            this.stateHandler.updateState(this.newState);
        }
        this.getCommandList().commandFinished();
        return bl;
    }

    protected Command canceled() {
        this.logger.log(100000, "[RequestModeChange.canceled] no response");
        return new Command(this.logger){

            public void execute() {
                RequestModeChange.this.stateHandler.updateState(RequestModeChange.this.newState);
                this.getCommandList().commandFinished();
            }

            public String getName() {
                return "RequestModeChange.canceled -> Continue CommandList";
            }
        };
    }
}

