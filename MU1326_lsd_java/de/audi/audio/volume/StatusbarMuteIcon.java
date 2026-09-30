/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.volume;

import de.audi.atip.log.LogChannel;
import de.audi.audio.AudioEnv;
import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.store.ConnectionStore;

public class StatusbarMuteIcon
extends DefaultAudioListener {
    private static final int STATUS_LINE_MUTE_OFF = 0;
    private static final int STATUS_LINE_MUTE_ON = 1;
    private final LogChannel lc;
    private final AudioEnv env;

    public StatusbarMuteIcon(AudioEnv audioEnv) {
        this.env = audioEnv;
        this.lc = audioEnv.lcVol;
    }

    public void updateConnStatus(int n, int n2, int n3) {
        switch (n) {
            case 8: 
            case 96: {
                this.lc.log(10000000, "[StatusbarMuteIcon.updateConnStatus] status:%1 AC:%2 HT:%2", (long)n2, (long)n, (long)n3);
                break;
            }
            default: {
                return;
            }
        }
        switch (n2) {
            case 2: 
            case 4: {
                this.show(n3);
                break;
            }
            default: {
                this.hide(n3);
            }
        }
    }

    private void show(int n) {
        this.lc.log(10000000, "[StatusbarMuteIcon.show] HT:%1", (long)n);
        this.env.getChoiceModel(n, 379).setValue(1);
    }

    private void hide(int n) {
        this.lc.log(10000000, "[StatusbarMuteIcon.hide] HT:%1", (long)n);
        if (ConnectionStore.INSTANCE.isActive(n, 8)) {
            this.lc.log(1000000, "[StatusbarMuteIcon.hide] Not hiding --> MUTE_ENT active");
        } else if (ConnectionStore.INSTANCE.isActive(n, 96)) {
            this.lc.log(1000000, "[StatusbarMuteIcon.hide] Not hiding --> MUTEPIN active");
        } else {
            this.env.getChoiceModel(n, 379).setValue(0);
        }
    }
}

