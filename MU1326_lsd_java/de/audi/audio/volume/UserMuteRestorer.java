/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.audio.AudioEnv;
import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.services.BaseAudioService;
import de.audi.audio.store.ConnectionStore;

public class UserMuteRestorer
extends DefaultAudioListener {
    private final BaseAudioService audioService;
    private volatile boolean restoreUserMute = false;
    private boolean amAvailable = false;
    private final AudioEnv env;

    public UserMuteRestorer(AudioEnv audioEnv, BaseAudioService baseAudioService) {
        this.env = audioEnv;
        this.audioService = baseAudioService;
        this.restoreUserMute = audioEnv.getStorageAccess().getBoolean(1009, 19, false);
        audioEnv.lcDSI.log(1000000, "[UserMuteRestorer] restoreUserMute:%1", this.restoreUserMute);
    }

    public void updateAMAvailable(boolean bl) {
        if (this.amAvailable == bl) {
            return;
        }
        this.amAvailable = bl;
        if (bl) {
            if (this.restoreUserMute) {
                this.restoreUserMute = false;
                this.audioService.requestConnection(8);
            }
        } else {
            this.restoreUserMute = ConnectionStore.INSTANCE.isActive(8, 1);
        }
    }

    public void updateConnStatus(int n, int n2, int n3) {
        if (this.amAvailable && n == 8) {
            boolean bl = n2 != 5;
            this.env.lcDSI.log(1000000, "[UserMuteRestorer.updateConnStatus] persist mute state, muted:%1", bl);
            this.env.getStorageAccess().setBoolean(1009, 19, bl);
        } else {
            this.env.lcDSI.log(1000000, "[UserMuteRestorer.updateConnStatus] ignored for AC:%1, status:%2, amAvailable:%3", (long)n, (long)n2, this.amAvailable);
        }
    }
}

