/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager;
import de.audi.app.terminalmode.smartphone.carplay.CarPlayDSIManager$5$1;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionOverride;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarPlayDSIManager$5
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ CarPlayDSIManager this$0;

    CarPlayDSIManager$5(CarPlayDSIManager carPlayDSIManager) {
        this.this$0 = carPlayDSIManager;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarPlayDSIManager.access$1400(this.this$0).log(1078071040, "[%1.changeState] Audio_Media: Paused_by_mute -> Normal", (Object)"CarPlayDSIManager");
        if (IRequestor.MAINUNIT == iRequestor) {
            commandList.add(new CarPlayDSIManager$5$1(this, CarPlayDSIManager.access$1500(this.this$0), CarPlayDSIManager.access$1600(this.this$0), this.this$0, tMState, CarPlayDSIManager.access$400(this.this$0), tMState));
        }
    }

    static /* synthetic */ CarPlayDSIManager access$1700(CarPlayDSIManager$5 carPlayDSIManager$5) {
        return carPlayDSIManager$5.this$0;
    }
}

