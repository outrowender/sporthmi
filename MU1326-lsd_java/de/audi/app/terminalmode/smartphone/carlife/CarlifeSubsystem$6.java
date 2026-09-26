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
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class CarlifeSubsystem$6
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ CarlifeSubsystem this$0;

    CarlifeSubsystem$6(CarlifeSubsystem carlifeSubsystem) {
        this.this$0 = carlifeSubsystem;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        CarlifeSubsystem.access$000(this.this$0).log(1078071040, "[%1.changeState] Audio_Media: Paused_by_mute -> Normal", (Object)"CarlifeSubsystem");
        if (tMState.getOwnerForResource(Resource.AUDIO_MEDIA).is(ResourceOwner.DEVICE)) {
            CarlifeSubsystem.access$200(this.this$0).postButtonEvent(18, 0);
            CarlifeSubsystem.access$200(this.this$0).postButtonEvent(18, 1);
            CarlifeSubsystem.access$300(this.this$0).setStateForResource(Resource.AUDIO_MEDIA, ResourceState.NORMAL);
            CarlifeSubsystem.access$400(this.this$0).updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PLAYING));
        }
    }
}

