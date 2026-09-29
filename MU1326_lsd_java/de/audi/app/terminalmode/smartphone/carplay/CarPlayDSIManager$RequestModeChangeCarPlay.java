/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$RequestModeChangeCarPlay$1;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.app.terminalmode.statemachine.commands.SendResponseModeChanged;
import de.audi.tghu.command.Command;

class CarPlayDSIManager$RequestModeChangeCarPlay
extends AbstractDSICommand {
    private static final String LOGCLASS;
    private final TMState newState;
    private final IStateHandler stateHandler;
    private final /* synthetic */ CarPlayDSIManager this$0;

    public CarPlayDSIManager$RequestModeChangeCarPlay(CarPlayDSIManager carPlayDSIManager, IContext iContext, TMState tMState, IStateHandler iStateHandler) {
        this.this$0 = carPlayDSIManager;
        super(iContext.getLogger().main(), "RequestModeChangeCarPlay", iContext, iContext.getSmartphoneDSIManager());
        this.newState = tMState;
        this.stateHandler = iStateHandler;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"RequestModeChangeCarPlay");
        TMDevice tMDevice = this.context.getDeviceManager().getActiveDevice();
        if (null == tMDevice || tMDevice.connectionState().is(TMDevice$ConnectionState.NOT_ATTACHED)) {
            this.stateHandler.updateState(this.newState);
            this.getCommandList().commandFinished();
        }
        this.requestModeChangeCP(this.newState, "user action");
    }

    @Override
    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
        this.logger.log(1078071040, "[%1.updateStates]", (Object)"RequestModeChangeCarPlay");
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.updateCurrentAppState(iAppStateArray);
        tMState.updateCurrentResourceState(iResourceArray);
        boolean bl = TerminalModeUtils.compareTMStateAfterDSIUpdate((TMState)this.newState, (TMState)tMState);
        if (bl) {
            this.stateHandler.updateState(this.newState);
            if (-1L != l) {
                this.getCommandList().commandFinishedWithPostCommand(new SendResponseModeChanged(this.context, this.dsiSmartphoneManager, iAppStateArray, iResourceArray, l, this.stateHandler));
            } else {
                this.getCommandList().commandFinished();
            }
        } else {
            this.getCommandList().commandFinished();
        }
        return bl;
    }

    @Override
    protected Command canceled() {
        this.logger.log(-1601830656, "[RequestModeChangeCarPlay.canceled] no response");
        return new CarPlayDSIManager$RequestModeChangeCarPlay$1(this, this.logger);
    }

    private void requestModeChangeCP(TMState tMState, String string) {
        CarPlayDSIManager.access$4600(this.this$0, tMState);
        if (TerminalModeUtils.equalsResourcesOwner((ResourceOwner[])CarPlayDSIManager.access$2500(this.this$0).getResourceOwner(), (ResourceOwner[])tMState.getResourceOwner())) {
            CarPlayDSIManager.access$000(this.this$0).requestModeChange(this.this$0.getAppStates(tMState), new IDSIResource[0], string);
            CarPlayDSIManager.access$4800(this.this$0).updateMode(-1L, this.this$0.getAppStates(tMState), CarPlayDSIManager.access$4700(this.this$0, tMState, true));
            return;
        }
        if (CarPlayDSIManager.access$2500(this.this$0).isResourceOwnerMainUnit(Resource.SCREEN) && tMState.isResourceOwnerDevice(Resource.SCREEN)) {
            if (this.context.getConfiguration().applicationOffset() > 0) {
                CarPlayDSIManager.access$000(this.this$0).requestModeChange(this.this$0.getAppStates(tMState), CarPlayDSIManager.access$4900(this.this$0, CarPlayDSIManager.access$4700(this.this$0, tMState, false), false), string);
            }
            CarPlayDSIManager.access$5000(this.this$0, 0);
            if (CarPlayDSIManager.access$2500(this.this$0).getOwnerForResource(Resource.AUDIO_MEDIA) == tMState.getOwnerForResource(Resource.AUDIO_MEDIA)) {
                CarPlayDSIManager.access$5100(this.this$0).updateMode(-1L, this.this$0.getAppStates(tMState), CarPlayDSIManager.access$4700(this.this$0, tMState, true));
                return;
            }
        }
        if (CarPlayDSIManager.access$2500(this.this$0).isResourceStatePausedByMute(Resource.AUDIO_MEDIA) && tMState.isResourceOwnerMainUnit(Resource.AUDIO_MEDIA)) {
            CarPlayDSIManager.access$5200(this.this$0).updateMode(-1L, this.this$0.getAppStates(tMState), CarPlayDSIManager.access$4700(this.this$0, tMState, true));
            return;
        }
        CarPlayDSIManager.access$5302(this.this$0, tMState.getOwnerForResource(Resource.AUDIO_MEDIA).isNot(ResourceOwner.MAINUNIT) && tMState.getStateForResource(Resource.AUDIO_MEDIA).is(ResourceState.NORMAL));
        this.logger.log(-2137614336, "[%1.requestModeChangeCP.waitForAudioType set to] %2 ", (Object)"RequestModeChangeCarPlay", (Object)new Boolean(CarPlayDSIManager.access$5300(this.this$0)));
        IDSIResource[] iDSIResourceArray = CarPlayDSIManager.access$5400(this.this$0, CarPlayDSIManager.access$4700(this.this$0, tMState, true));
        if (CarPlayDSIManager.access$2500(this.this$0).getOwnerForResource(Resource.AUDIO_MEDIA) == tMState.getOwnerForResource(Resource.AUDIO_MEDIA) && CarPlayDSIManager.access$2500(this.this$0).getStateForResource(Resource.AUDIO_MEDIA) == CarPlayDSIManager.access$2500(this.this$0).getStateForResource(Resource.AUDIO_MEDIA)) {
            iDSIResourceArray = new IDSIResource[]{iDSIResourceArray[0]};
        }
        if (CarPlayDSIManager.access$2500(this.this$0).getOwnerForResource(Resource.SCREEN) == tMState.getOwnerForResource(Resource.SCREEN)) {
            iDSIResourceArray = new IDSIResource[]{iDSIResourceArray[1]};
        }
        CarPlayDSIManager.access$000(this.this$0).requestModeChange(this.this$0.getAppStates(tMState), iDSIResourceArray, string);
    }

    static /* synthetic */ TMState access$4400(CarPlayDSIManager$RequestModeChangeCarPlay carPlayDSIManager$RequestModeChangeCarPlay) {
        return carPlayDSIManager$RequestModeChangeCarPlay.newState;
    }

    static /* synthetic */ IStateHandler access$4500(CarPlayDSIManager$RequestModeChangeCarPlay carPlayDSIManager$RequestModeChangeCarPlay) {
        return carPlayDSIManager$RequestModeChangeCarPlay.stateHandler;
    }
}

