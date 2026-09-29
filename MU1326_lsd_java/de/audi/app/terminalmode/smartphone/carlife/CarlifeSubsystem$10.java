/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeSubsystem;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionHook;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.RequestModeChange;
import de.audi.tghu.command.CommandList;

class CarlifeSubsystem$10
extends IStateChangeAction$AbstractStateChangeActionHook {
    private final /* synthetic */ CarlifeSubsystem this$0;

    CarlifeSubsystem$10(CarlifeSubsystem carlifeSubsystem) {
        this.this$0 = carlifeSubsystem;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarlifeSubsystem.access$000(this.this$0).log(1078071040, "[%1.changeState] audio media: device -> MU", (Object)"CarlifeSubsystem");
        if (iRequestor.is(IRequestor.MAINUNIT)) {
            commandList.add(new RequestModeChange(CarlifeSubsystem.access$100(this.this$0), tMState, l, CarlifeSubsystem.access$300(this.this$0)));
        }
        CarlifeSubsystem.access$400(this.this$0).updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PLAYING));
    }
}

