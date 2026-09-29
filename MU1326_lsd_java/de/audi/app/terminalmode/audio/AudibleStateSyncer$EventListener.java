/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudibleStateSyncer;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$1;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;

final class AudibleStateSyncer$EventListener
extends DefaultEventListener {
    private final /* synthetic */ AudibleStateSyncer this$0;

    private AudibleStateSyncer$EventListener(AudibleStateSyncer audibleStateSyncer) {
        this.this$0 = audibleStateSyncer;
    }

    @Override
    public void updatePlaybackInfo(PlaybackInfoChangedEvent playbackInfoChangedEvent) {
        AudibleStateSyncer.access$402(this.this$0, playbackInfoChangedEvent.getState());
        if (AudibleStateSyncer.access$400(this.this$0).isOneOf(PlaybackInfoChangedEvent$PlaybackState.PLAYING, PlaybackInfoChangedEvent$PlaybackState.SEEKBACKWARD, PlaybackInfoChangedEvent$PlaybackState.SEEKBACKWARD) && !AudibleStateSyncer.access$500(this.this$0).isAudible()) {
            this.onDevicePlayingWhileNotAudible();
        }
    }

    private void onDevicePlayingWhileNotAudible() {
        AudibleStateSyncer.access$600(this.this$0).log(-2137614336, "[AudibleStateSyncer.onDevicePlayingWhileNotAudible] %1 while not audible -> AudioManager.resumeAudio()", (Object)AudibleStateSyncer.access$400(this.this$0));
        AudibleStateSyncer.access$900(this.this$0).resumeAudio(true);
    }

    /* synthetic */ AudibleStateSyncer$EventListener(AudibleStateSyncer audibleStateSyncer, AudibleStateSyncer$1 audibleStateSyncer$1) {
        this(audibleStateSyncer);
    }
}

