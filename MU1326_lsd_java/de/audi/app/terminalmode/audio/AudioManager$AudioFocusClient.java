/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$1;
import de.audi.app.terminalmode.audio.AudioManager$AudioFocusClient$1;
import de.audi.atip.audio.IAudioFocusClient;

final class AudioManager$AudioFocusClient
implements IAudioFocusClient {
    private static final String LOGCLASS;
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$AudioFocusClient(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void updateAudioFocus(int n, int n2) {
        AudioManager.access$2100(this.this$0).execute(new AudioManager$AudioFocusClient$1(this, "AudioManager.AudioFocusClient.updateAudioFocus", n, n2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAudioFocus(int n, boolean bl, boolean bl2) {
        Object object = AudioManager.access$2700(this.this$0);
        synchronized (object) {
            AudioManager.access$300(this.this$0).log(-2137614336, "[%2.setAudioFocus] '%1' (terminal='%3')", bl, (Object)"AudioManager.AudioFocusClient", (Object)new Integer(n));
            int n2 = AudioManager.access$2800(this.this$0);
            AudioManager.access$2900(this.this$0).accept(new Boolean(bl));
            int n3 = AudioManager.access$2800(this.this$0);
            if (n2 == n3) {
                AudioManager.access$300(this.this$0).log(-2137614336, "[%1.setAudioFocus] Not changed. Ignore.", (Object)"AudioManager.AudioFocusClient");
                return;
            }
            AudioManager.access$300(this.this$0).log(-2137614336, "[%1.setAudioFocus] '%2'", (Object)"AudioManager.AudioFocusClient", (Object)AudioManager.access$3000(this.this$0, n3));
            AudioManager.access$900(this.this$0);
            if (n3 == 1) {
                AudioManager.access$3100(this.this$0, bl2);
            }
        }
    }

    /* synthetic */ AudioManager$AudioFocusClient(AudioManager audioManager, AudioManager$1 audioManager$1) {
        this(audioManager);
    }

    static /* synthetic */ AudioManager access$2200(AudioManager$AudioFocusClient audioManager$AudioFocusClient) {
        return audioManager$AudioFocusClient.this$0;
    }

    static /* synthetic */ void access$2600(AudioManager$AudioFocusClient audioManager$AudioFocusClient, int n, boolean bl, boolean bl2) {
        audioManager$AudioFocusClient.setAudioFocus(n, bl, bl2);
    }
}

