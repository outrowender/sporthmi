/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioState;
import de.audi.app.terminalmode.audio.SpeechReset;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.utils.generics.Consumer;

class SpeechReset$1
implements Consumer {
    private final /* synthetic */ SpeechReset this$0;

    SpeechReset$1(SpeechReset speechReset) {
        this.this$0 = speechReset;
    }

    public void accept(AudioState audioState) {
        if (audioState == null) {
            return;
        }
        if (audioState.is(AudioState.STOPPED) && ((ResourceOwner)SpeechReset.access$000(this.this$0).getStateResourceProperty(Resource.AUDIO_SPEECH).get()).is(ResourceOwner.DEVICE) && SpeechReset.access$100(this.this$0).getActiveDevice().isCarplayDevice()) {
            SpeechReset.access$200(this.this$0).log(1078071040, "[%1.accept] owner[AUDIO_SPEECH] -> MU", (Object)"SpeechReset");
            SpeechReset.access$000(this.this$0).setOwnerForResource(Resource.AUDIO_SPEECH, ResourceOwner.MAINUNIT);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((AudioState)object);
    }
}

