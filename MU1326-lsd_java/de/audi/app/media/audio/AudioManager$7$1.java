/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.audio.AudioManager;
import de.audi.app.media.audio.AudioManager$7;

class AudioManager$7$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pAppId;
    private final /* synthetic */ int val$pTerminalID;
    private final /* synthetic */ boolean val$muteOnStartup;
    private final /* synthetic */ AudioManager$7 this$1;

    AudioManager$7$1(AudioManager$7 audioManager$7, String string, int n, int n2, boolean bl) {
        this.this$1 = audioManager$7;
        this.val$pAppId = n;
        this.val$pTerminalID = n2;
        this.val$muteOnStartup = bl;
        super(string);
    }

    @Override
    public void run() {
        boolean bl;
        boolean bl2 = bl = this.val$pAppId == 2;
        if (AudioManager.access$2200(AudioManager$7.access$2100(this.this$1)).audio().isInfo()) {
            AudioManager.access$2300(AudioManager$7.access$2100(this.this$1)).audio().log(1078071040, "[%1.updateAudioFocus] '%3' (terminalID='%2')", (Object)"AudioManager", (Object)new Integer(this.val$pTerminalID), (Object)(bl ? "MEDIA" : "OTHER"));
        }
        AudioManager.access$2400(AudioManager$7.access$2100(this.this$1), this.val$pTerminalID, bl, !this.val$muteOnStartup);
    }
}

