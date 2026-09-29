/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioFocusSyncer;
import de.audi.atip.audio.IAudioFocusClient;

class AudioFocusSyncer$2
implements IAudioFocusClient {
    private final /* synthetic */ AudioFocusSyncer this$0;

    AudioFocusSyncer$2(AudioFocusSyncer audioFocusSyncer) {
        this.this$0 = audioFocusSyncer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateAudioFocus(int n, int n2) {
        this.this$0.log.log(1078071040, "[%1.updateAudioFocus] tId=%2, appid=%3", (Object)"AudioFocusSyncer", (long)n, (long)n2);
        Object object = AudioFocusSyncer.access$000(this.this$0);
        synchronized (object) {
            if (0 == n) {
                AudioFocusSyncer.access$100(this.this$0, 0, 2, n2);
            } else if (2 == n) {
                AudioFocusSyncer.access$100(this.this$0, 2, 0, n2);
            }
        }
    }
}

