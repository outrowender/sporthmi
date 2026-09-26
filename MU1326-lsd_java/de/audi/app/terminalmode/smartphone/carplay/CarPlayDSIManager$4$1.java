/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.dsi.DSIResource$Builder;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.carplay.AbstractRequestModeChangeAudio;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$4;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;

class CarPlayDSIManager$4$1
extends AbstractRequestModeChangeAudio {
    private final /* synthetic */ TMState val$pNewState;
    private final /* synthetic */ CarPlayDSIManager$4 this$1;

    CarPlayDSIManager$4$1(CarPlayDSIManager$4 carPlayDSIManager$4, LogChannel logChannel, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, TMState tMState, IStateHandler iStateHandler, TMState tMState2) {
        this.this$1 = carPlayDSIManager$4;
        this.val$pNewState = tMState2;
        super(logChannel, iContext, iDSISmartphoneManager, tMState, iStateHandler);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"CarPlayDSIManager");
        if (!this.val$pNewState.isResourceOwnerMainUnit(Resource.AUDIO_MEDIA)) {
            CarPlayDSIManager.access$000(CarPlayDSIManager$4.access$1300(this.this$1)).requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource$Builder().setpOwner(2).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(2).setDsiTakeType(4).setDSITransferPriority(1).setDsiBorrowConstraint(1).setDsiTakeConstraint(0).setDsiUnborrowConstraint(1).build()}, "audio play");
        }
        TMState tMState = CarPlayDSIManager.access$400(CarPlayDSIManager$4.access$1300(this.this$1)).getCurrentState();
        tMState.setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
        CarPlayDSIManager.access$400(CarPlayDSIManager$4.access$1300(this.this$1)).updateState(tMState);
        this.getCommandList().commandFinished();
    }
}

