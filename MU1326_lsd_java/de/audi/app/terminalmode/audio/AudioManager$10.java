/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.reactive.observables.Observables$Combinator;

class AudioManager$10
implements Observables$Combinator {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$10(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    public Boolean combine(AudioConnectionState audioConnectionState, TMDevice tMDevice) {
        AudioManager.access$1602(this.this$0, audioConnectionState.isAtAMActive());
        return new Boolean(AudioManager.access$1600(this.this$0) && tMDevice != null && tMDevice.isActive());
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2) {
        return this.combine((AudioConnectionState)object, (TMDevice)object2);
    }
}

