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
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarPlayDSIManager$12
extends IStateChangeAction$AbstractStateChangeActionHook {
    private final /* synthetic */ CarPlayDSIManager this$0;

    CarPlayDSIManager$12(CarPlayDSIManager carPlayDSIManager) {
        this.this$0 = carPlayDSIManager;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarPlayDSIManager.access$3600(this.this$0).log(1078071040, "[%1.changeState] speech: mainunit -> nobody", (Object)"CarPlayDSIManager");
        if (iRequestor.is(IRequestor.MAINUNIT)) {
            commandList.add(new CarPlayDSIManager$RequestModeChangeCarPlay(this.this$0, CarPlayDSIManager.access$3700(this.this$0), tMState, CarPlayDSIManager.access$400(this.this$0)));
        }
    }
}

