/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2Subsystem;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction$AbstractStateChangeActionOverride;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class AndroidAuto2Subsystem$4
extends IStateChangeAction$AbstractStateChangeActionOverride {
    private final /* synthetic */ AndroidAuto2Subsystem this$0;

    AndroidAuto2Subsystem$4(AndroidAuto2Subsystem androidAuto2Subsystem) {
        this.this$0 = androidAuto2Subsystem;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        AndroidAuto2Subsystem.access$100(this.this$0).log(1078071040, "[%1.changeState] Audio_Media: Normal -> Paused by mute", (Object)AndroidAuto2Subsystem.access$000());
        AndroidAuto2Subsystem.access$300(this.this$0).postButtonEvent(127, 0);
        AndroidAuto2Subsystem.access$300(this.this$0).postButtonEvent(127, 1);
        AndroidAuto2Subsystem.access$400(this.this$0).setStateForResource(Resource.AUDIO_MEDIA, ResourceState.PAUSED_BY_MUTE);
        AndroidAuto2Subsystem.access$500(this.this$0).updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PAUSED));
    }
}

