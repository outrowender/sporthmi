/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.SpeechReset;
import de.audi.atip.utils.reactive.observables.Observables$Combinator;

class SpeechReset$2
implements Observables$Combinator {
    private final /* synthetic */ SpeechReset this$0;

    SpeechReset$2(SpeechReset speechReset) {
        this.this$0 = speechReset;
    }

    public AudioState combine(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2) {
        if (audioConnectionState.getState().is(AudioState.STOPPED) || audioConnectionState2.getState().is(AudioState.STOPPED)) {
            return AudioState.STOPPED;
        }
        return null;
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2) {
        return this.combine((AudioConnectionState)object, (AudioConnectionState)object2);
    }
}

