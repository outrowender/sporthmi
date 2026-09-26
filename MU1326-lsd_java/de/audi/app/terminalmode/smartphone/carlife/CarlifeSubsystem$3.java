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
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionOverride;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarlifeSubsystem$3
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ CarlifeSubsystem this$0;

    CarlifeSubsystem$3(CarlifeSubsystem carlifeSubsystem) {
        this.this$0 = carlifeSubsystem;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarlifeSubsystem.access$000(this.this$0).log(1078071040, "[%1.changeState] Audio_Media: Normal -> Paused", (Object)"CarlifeSubsystem");
        CarlifeSubsystem.access$200(this.this$0).postButtonEvent(19, 0);
        CarlifeSubsystem.access$200(this.this$0).postButtonEvent(19, 1);
        CarlifeSubsystem.access$300(this.this$0).setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED);
        CarlifeSubsystem.access$400(this.this$0).updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PAUSED));
    }
}

