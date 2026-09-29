/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$2$1;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionOverride;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarPlayDSIManager$2
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ CarPlayDSIManager this$0;

    CarPlayDSIManager$2(CarPlayDSIManager carPlayDSIManager) {
        this.this$0 = carPlayDSIManager;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarPlayDSIManager.access$100(this.this$0).log(1078071040, "[%1.changeState] Audio_Media: Normal -> Paused", (Object)"CarPlayDSIManager");
        if (ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_PHONE)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_SPEECH)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_RINGTONE))) {
            return;
        }
        commandList.add(new CarPlayDSIManager$2$1(this, CarPlayDSIManager.access$200(this.this$0), CarPlayDSIManager.access$300(this.this$0), this.this$0, tMState, CarPlayDSIManager.access$400(this.this$0)));
    }

    static /* synthetic */ CarPlayDSIManager access$500(CarPlayDSIManager$2 carPlayDSIManager$2) {
        return carPlayDSIManager$2.this$0;
    }
}

