/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$3$1;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionOverride;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarPlayDSIManager$3
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ CarPlayDSIManager this$0;

    CarPlayDSIManager$3(CarPlayDSIManager carPlayDSIManager) {
        this.this$0 = carPlayDSIManager;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarPlayDSIManager.access$600(this.this$0).log(1078071040, "[%1.changeState] Audio_Media: Normal -> Paused by mute", (Object)"CarPlayDSIManager");
        if (ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_PHONE)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_SPEECH)) || ResourceOwner.DEVICE.is(tMState.getOwnerForResource(Resource.AUDIO_RINGTONE))) {
            return;
        }
        commandList.add(new CarPlayDSIManager$3$1(this, CarPlayDSIManager.access$700(this.this$0), CarPlayDSIManager.access$800(this.this$0), this.this$0, tMState, CarPlayDSIManager.access$400(this.this$0)));
    }

    static /* synthetic */ CarPlayDSIManager access$900(CarPlayDSIManager$3 carPlayDSIManager$3) {
        return carPlayDSIManager$3.this$0;
    }
}

