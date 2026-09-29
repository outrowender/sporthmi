/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.smartphone.carlife.CarlifeSubsystem;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionHook;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange;
import de.audi.tghu.command.CommandList;

class CarlifeSubsystem$13
extends IStateChangeAction$AbstractStateChangeActionHook {
    private final /* synthetic */ CarlifeSubsystem this$0;

    CarlifeSubsystem$13(CarlifeSubsystem carlifeSubsystem) {
        this.this$0 = carlifeSubsystem;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarlifeSubsystem.access$000(this.this$0).log(1078071040, "[%1.changeState] speech: device -> nobody", (Object)"CarlifeSubsystem");
        if (iRequestor.is(IRequestor.MAINUNIT)) {
            commandList.add(new RequestModeChange(CarlifeSubsystem.access$100(this.this$0), tMState, -1L, CarlifeSubsystem.access$300(this.this$0)));
        }
    }
}

