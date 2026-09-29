/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.dsi.DSIResource$Builder;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.carplay.AbstractRequestModeChangeAudio;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$6;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;

class CarPlayDSIManager$6$1
extends AbstractRequestModeChangeAudio {
    private final /* synthetic */ CarPlayDSIManager$6 this$1;

    CarPlayDSIManager$6$1(CarPlayDSIManager$6 carPlayDSIManager$6, LogChannel logChannel, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, TMState tMState, IStateHandler iStateHandler) {
        this.this$1 = carPlayDSIManager$6;
        super(logChannel, iContext, iDSISmartphoneManager, tMState, iStateHandler);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"CarPlayDSIManager");
        CarPlayDSIManager.access$000(CarPlayDSIManager$6.access$2100(this.this$1)).requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource$Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()}, "Audio_Media: Paused -> Paused by mute");
        CarPlayDSIManager.access$000(CarPlayDSIManager$6.access$2100(this.this$1)).requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource$Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(4).setDSITransferPriority(1).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build()}, "Audio_Media: Borrow -> Unborrow");
        TMState tMState = CarPlayDSIManager.access$400(CarPlayDSIManager$6.access$2100(this.this$1)).getCurrentState();
        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
        CarPlayDSIManager.access$400(CarPlayDSIManager$6.access$2100(this.this$1)).updateState(tMState);
        this.getCommandList().commandFinished();
    }

    @Override
    public boolean updateStates(IAppState[] iAppStateArray, IResource[] iResourceArray, long l) {
        return false;
    }
}

