/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.util.DefaultDSISoundListener;
import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import org.dsi.ifc.audio.DSISoundListener;

public class SdisDSISoundListener
extends DefaultDSISoundListener
implements DSISoundListener {
    private final AudioEnv env;
    private final SdisAudioListener sdisAudioListener;

    public SdisDSISoundListener(AudioEnv audioEnv, SdisAudioListener sdisAudioListener) {
        this.env = audioEnv;
        this.sdisAudioListener = sdisAudioListener;
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
        if (n3 == 1) {
            this.sdisAudioListener.updateVolumeRange(new VolumeRange(n, n2));
        } else {
            this.env.lcSDIS.log(1078071040, "[SdisDSISoundListener.updateVolumeRange] INVALID");
        }
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
        if (n3 == 1 && this.isEntertainmentConnection(n)) {
            this.env.lcSDIS.log(1078071040, "[SdisDSISoundListener.updateVolume] AC:%1, value:%2", (long)n, (long)s);
            this.sdisAudioListener.updateVolume(s);
        } else {
            this.env.lcSDIS.log(1078071040, "[SdisDSISoundListener.updateVolume] INVALID or AC:%1 is no entertainment connection (valid:%2)", (long)n, (long)n3);
        }
    }

    private boolean isEntertainmentConnection(int n) {
        return AudioConnection.contains(AudioConnection.ENT_MEDIA_CONNS, n) || AudioConnection.contains(AudioConnection.ENT_RADIO_CONNS, n) || 308 == n;
    }
}

