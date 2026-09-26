/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudibleStateSyncer;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$1;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$AudioStateListener$1;
import de.audi.app.terminalmode.audio.AudibleStateSyncer$AudioStateListener$2;
import de.audi.app.terminalmode.audio.DefaultAudioConnectionListener;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent$PlaybackState;

final class AudibleStateSyncer$AudioStateListener
extends DefaultAudioConnectionListener {
    private final /* synthetic */ AudibleStateSyncer this$0;

    private AudibleStateSyncer$AudioStateListener(AudibleStateSyncer audibleStateSyncer) {
        this.this$0 = audibleStateSyncer;
    }

    @Override
    public void onPause() {
        if (AudibleStateSyncer.access$400(this.this$0).isOneOf(PlaybackInfoChangedEvent$PlaybackState.PLAYING, PlaybackInfoChangedEvent$PlaybackState.SEEKBACKWARD, PlaybackInfoChangedEvent$PlaybackState.SEEKFORWARD)) {
            AudibleStateSyncer.access$600(this.this$0).log(-2137614336, "[AudibleStateSyncer.onAudioConnectionPaused] %1 while %2 -> playerModificationListener.pause()", (Object)AudibleStateSyncer.access$500(this.this$0), (Object)AudibleStateSyncer.access$400(this.this$0));
            AudibleStateSyncer.access$800(this.this$0).create().addSingle(new AudibleStateSyncer$AudioStateListener$1(this, AudibleStateSyncer.access$700(this.this$0).getLogger().main(), "PauseAudio", AudibleStateSyncer.access$700(this.this$0), AudibleStateSyncer.access$200(this.this$0))).execute("AudibleStateSyncer");
        }
    }

    @Override
    public void onPauseByMute() {
        if (AudibleStateSyncer.access$400(this.this$0).isOneOf(PlaybackInfoChangedEvent$PlaybackState.PLAYING, PlaybackInfoChangedEvent$PlaybackState.SEEKBACKWARD, PlaybackInfoChangedEvent$PlaybackState.SEEKFORWARD)) {
            AudibleStateSyncer.access$600(this.this$0).log(-2137614336, "[AudibleStateSyncer.onAudioConnectionPaused] %1 while %2 -> playerModificationListener.pause()", (Object)AudibleStateSyncer.access$500(this.this$0), (Object)AudibleStateSyncer.access$400(this.this$0));
            AudibleStateSyncer.access$300(this.this$0);
        }
    }

    @Override
    public void onResume() {
        AudibleStateSyncer.access$600(this.this$0).log(-2137614336, "[AudibleStateSyncer.onAudioConnectionStarted] %1 while %2 -> playerModificationListener.resume()", (Object)AudibleStateSyncer.access$500(this.this$0), (Object)AudibleStateSyncer.access$400(this.this$0));
        AudibleStateSyncer.access$800(this.this$0).create().addSingle(new AudibleStateSyncer$AudioStateListener$2(this, AudibleStateSyncer.access$700(this.this$0).getLogger().main(), "ResumeAudio", AudibleStateSyncer.access$700(this.this$0), AudibleStateSyncer.access$200(this.this$0))).execute("AudibleStateSyncer");
    }

    /* synthetic */ AudibleStateSyncer$AudioStateListener(AudibleStateSyncer audibleStateSyncer, AudibleStateSyncer$1 audibleStateSyncer$1) {
        this(audibleStateSyncer);
    }
}

