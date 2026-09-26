/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudibleStateSyncer;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.audi.atip.utils.reactive.observables.Observables$Consumer2;

class AudibleStateSyncer$1
implements Observables$Consumer2 {
    private final /* synthetic */ AudibleStateSyncer this$0;

    AudibleStateSyncer$1(AudibleStateSyncer audibleStateSyncer) {
        this.this$0 = audibleStateSyncer;
    }

    public void accept(AudioState audioState, AudioConnectionState audioConnectionState) {
        if (audioState.is(AudioState.STARTED) && audioConnectionState.getState().is(AudioState.PAUSED) && AudibleStateSyncer.access$200(this.this$0).getCurrentState().getStateForResource(Resource.AUDIO_MEDIA).isNot(ResourceState.PAUSED_BY_MUTE)) {
            AudibleStateSyncer.access$300(this.this$0);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object, Object object2) {
        this.accept((AudioState)object, (AudioConnectionState)object2);
    }
}

