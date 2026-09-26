/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.utils.generics.Consumer;

class AudioManager$7
implements Consumer {
    private volatile boolean volumeLock = false;
    private final /* synthetic */ AudioManager this$0;

    AudioManager$7(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    public void accept(Boolean bl) {
        if (bl.booleanValue() && !this.volumeLock) {
            this.this$0.requestVolumelock((Integer)AudioManager.access$1500(this.this$0).getAudioConnection(TMAudioConnection.MEDIA).get(), "micro on");
            this.volumeLock = true;
        } else if (this.volumeLock) {
            this.this$0.releaseVolumelock((Integer)AudioManager.access$1500(this.this$0).getAudioConnection(TMAudioConnection.MEDIA).get(), "micro off");
            this.volumeLock = false;
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

