/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager$1;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;

class AndroidAuto2DSIManager$AndroidAuto2EventListener
extends DefaultEventListener {
    private final /* synthetic */ AndroidAuto2DSIManager this$0;

    private AndroidAuto2DSIManager$AndroidAuto2EventListener(AndroidAuto2DSIManager androidAuto2DSIManager) {
        this.this$0 = androidAuto2DSIManager;
    }

    @Override
    public void mediaAudioAvailable(boolean bl) {
        if (bl && AndroidAuto2DSIManager.access$500(this.this$0).getCurrentState().getStateForResource(Resource.AUDIO_MEDIA).is(new ResourceState[]{ResourceState.PAUSED_BY_MUTE, ResourceState.PAUSED}) && AndroidAuto2DSIManager.access$600(this.this$0).resumeAudio(true)) {
            AndroidAuto2DSIManager.access$700(this.this$0).updatePlaybackInfo(new PlaybackInfoChangedEvent(PlaybackInfoChangedEvent$PlaybackState.PLAYING));
        }
    }

    /* synthetic */ AndroidAuto2DSIManager$AndroidAuto2EventListener(AndroidAuto2DSIManager androidAuto2DSIManager, AndroidAuto2DSIManager$1 androidAuto2DSIManager$1) {
        this(androidAuto2DSIManager);
    }
}

