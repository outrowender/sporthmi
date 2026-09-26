/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$RequestModeChangeCarPlay;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionHook;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarPlayDSIManager$8
extends IStateChangeAction$AbstractStateChangeActionHook {
    private final /* synthetic */ CarPlayDSIManager this$0;

    CarPlayDSIManager$8(CarPlayDSIManager carPlayDSIManager) {
        this.this$0 = carPlayDSIManager;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarPlayDSIManager.access$2400(this.this$0).log(1078071040, "[%1.changeState] Screen: Device -> MU", (Object)"CarPlayDSIManager");
        if (!iRequestor.isOneOf(IRequestor.DEVICE, IRequestor.DEVICE_WHILE_DISCONNECTING) && !CarPlayDSIManager.access$2500(this.this$0).isAccessRestricted(Resource.SCREEN)) {
            commandList.add(new CarPlayDSIManager$RequestModeChangeCarPlay(this.this$0, CarPlayDSIManager.access$2600(this.this$0), tMState, CarPlayDSIManager.access$400(this.this$0)));
        }
    }
}

