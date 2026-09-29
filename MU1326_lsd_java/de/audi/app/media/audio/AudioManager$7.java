/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.app.media.audio.AudioManager$7$1;
import de.audi.atip.audio.IAudioFocusClient;

class AudioManager$7
implements IAudioFocusClient {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$7(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void updateAudioFocus(int n, int n2) {
        boolean bl = this.this$0.getTerminal().isStartup() && 2 == this.this$0.getTerminal().getFramework().getLastmodeHandler().getLastmodeAudio(n);
        this.this$0.getTerminal().getDispatcher().execute(new AudioManager$7$1(this, "AudioManager.updateAudioFocus", n2, n, bl));
    }

    static /* synthetic */ AudioManager access$2100(AudioManager$7 audioManager$7) {
        return audioManager$7.this$0;
    }
}

