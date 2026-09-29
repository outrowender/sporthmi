/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$4$1;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionOverride;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarPlayDSIManager$4
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ CarPlayDSIManager this$0;

    CarPlayDSIManager$4(CarPlayDSIManager carPlayDSIManager) {
        this.this$0 = carPlayDSIManager;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarPlayDSIManager.access$1000(this.this$0).log(1078071040, "[%1.changeState] Audio_Media: Paused -> Normal", (Object)"CarPlayDSIManager");
        commandList.add(new CarPlayDSIManager$4$1(this, CarPlayDSIManager.access$1100(this.this$0), CarPlayDSIManager.access$1200(this.this$0), this.this$0, tMState, CarPlayDSIManager.access$400(this.this$0), tMState));
    }

    static /* synthetic */ CarPlayDSIManager access$1300(CarPlayDSIManager$4 carPlayDSIManager$4) {
        return carPlayDSIManager$4.this$0;
    }
}

