/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionOverride;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarlifeDSIAppNotInstalledManager$5
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ CarlifeDSIAppNotInstalledManager this$0;

    CarlifeDSIAppNotInstalledManager$5(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        this.this$0 = carlifeDSIAppNotInstalledManager;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarlifeDSIAppNotInstalledManager.access$600(this.this$0).log(1078071040, "[%1.changeState] Notification: MU", (Object)"CarlifeDSIAppNotInstalledManager");
        CarlifeDSIAppNotInstalledManager.access$200(this.this$0).getChoiceModel(215232512).setValue(3);
    }
}

