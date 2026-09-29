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
import de.audi.app.terminalmode.dsi.DSIResource$Builder;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.carplay.AbstractRequestModeChangeAudio;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$3;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;

class CarPlayDSIManager$3$1
extends AbstractRequestModeChangeAudio {
    private final /* synthetic */ CarPlayDSIManager$3 this$1;

    CarPlayDSIManager$3$1(CarPlayDSIManager$3 carPlayDSIManager$3, LogChannel logChannel, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, TMState tMState, IStateHandler iStateHandler) {
        this.this$1 = carPlayDSIManager$3;
        super(logChannel, iContext, iDSISmartphoneManager, tMState, iStateHandler);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"CarPlayDSIManager");
        CarPlayDSIManager.access$000(CarPlayDSIManager$3.access$900(this.this$1)).requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource$Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()}, "audio paused by mute");
        TMState tMState = CarPlayDSIManager.access$400(CarPlayDSIManager$3.access$900(this.this$1)).getCurrentState();
        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
        CarPlayDSIManager.access$400(CarPlayDSIManager$3.access$900(this.this$1)).updateState(tMState);
    }

    @Override
    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
        TMState tMState = CarPlayDSIManager.access$400(CarPlayDSIManager$3.access$900(this.this$1)).getCurrentState();
        tMState.updateCurrentAppState(iAppStateArray);
        tMState.updateCurrentResourceState(iResourceArray);
        tMState.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
        boolean bl = TerminalModeUtils.compareTMStateAfterDSIUpdate((TMState)this.newState, (TMState)tMState);
        this.getCommandList().commandFinished();
        return bl;
    }

    @Override
    public long getTimeout() {
        return 0;
    }
}

