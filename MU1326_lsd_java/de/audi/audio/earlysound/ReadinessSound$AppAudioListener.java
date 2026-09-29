/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.earlysound;

import de.audi.audio.earlysound.ReadinessSound;
import de.audi.audio.earlysound.ReadinessSound$1;
import de.audi.audio.intra.DefaultSoundListener;
import de.audi.audio.intra.IAudioListener;

class ReadinessSound$AppAudioListener
extends DefaultSoundListener
implements IAudioListener {
    private final /* synthetic */ ReadinessSound this$0;

    private ReadinessSound$AppAudioListener(ReadinessSound readinessSound) {
        this.this$0 = readinessSound;
    }

    @Override
    public void updateVolume(int n, int n2, int n3) {
        ReadinessSound.access$200(this.this$0).log(1078071040, "[ReadinessSound.AppAudioListener.updateVolume] connection: %1", (long)n);
        if (n == 82 || n == 48) {
            ReadinessSound.access$200(this.this$0).log(1078071040, "[ReadinessSound.AppAudioListener.updateVolume] volume: %1", (long)n3);
            ReadinessSound.access$302(this.this$0, n3);
            ReadinessSound.access$402(this.this$0, true);
            ReadinessSound.access$500(this.this$0, "updateVolume");
        }
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
        ReadinessSound.access$200(this.this$0).log(1078071040, "[ReadinessSound.AppAudioListener.menuVolumeRange] connection: %1", (long)n);
        if (n == 82) {
            ReadinessSound.access$200(this.this$0).log(1078071040, "[ReadinessSound.AppAudioListener.menuVolumeRange] min: %1", (long)n3);
            ReadinessSound.access$602(this.this$0, n3);
        }
    }

    @Override
    public void updateConnStatus(int n, int n2, int n3) {
        if (n == 48 && ReadinessSound.access$700(this.this$0)) {
            switch (n2) {
                case 2: {
                    ReadinessSound.access$800(this.this$0).fadeToConnection(n, 0);
                    break;
                }
                case 0: {
                    ReadinessSound.access$900(this.this$0).play();
                    break;
                }
                case 5: {
                    ReadinessSound.access$900(this.this$0).stop();
                    break;
                }
            }
        }
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        ReadinessSound.access$1002(this.this$0, bl);
        if (bl) {
            ReadinessSound.access$500(this.this$0, "updateAMAvailable");
        }
    }

    @Override
    public void updateActiveConnection(int n, int n2) {
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2) {
    }

    /* synthetic */ ReadinessSound$AppAudioListener(ReadinessSound readinessSound, ReadinessSound$1 readinessSound$1) {
        this(readinessSound);
    }
}

