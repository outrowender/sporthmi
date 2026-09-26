/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.reactive.observables.Observables$Combinator4;

class AudioManager$8
implements Observables$Combinator4 {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$8(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    public Boolean combine(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2, AudioConnectionState audioConnectionState3, TMDevice tMDevice) {
        return new Boolean(audioConnectionState.isAtAMActive() && audioConnectionState2.isAtAMActive() && !audioConnectionState3.isAudible() && tMDevice.isAndroidAutoDevice());
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2, Object object3, Object object4) {
        return this.combine((AudioConnectionState)object, (AudioConnectionState)object2, (AudioConnectionState)object3, (TMDevice)object4);
    }
}

