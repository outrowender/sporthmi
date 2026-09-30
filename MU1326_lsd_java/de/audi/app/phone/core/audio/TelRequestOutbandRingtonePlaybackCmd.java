/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class TelRequestOutbandRingtonePlaybackCmd
extends AbstractTelAudioCmd {
    private final RingTonePlayer ringtonePlayer;
    private final int ringtoneID;

    TelRequestOutbandRingtonePlaybackCmd(LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer, int n) {
        super(logChannel, "TelRequestOutbandRingtonePlaybackCmd: ringtoneID=" + n, hMIAudioService);
        if (ringTonePlayer == null) {
            throw new IllegalArgumentException("TelRequestOutbandRingtonePlaybackCmd#init: ringtonePlayer is null");
        }
        this.ringtonePlayer = ringTonePlayer;
        this.ringtoneID = n;
    }

    public void execute() {
        this.logger.log(1000000, "[TelRequestOutbandRingtonePlaybackCmd#execute] playing ringtoneID=%1", (long)this.ringtoneID);
        this.ringtonePlayer.playTone(1, this.ringtoneID);
        this.getCommandList().commandFinished();
    }

    public void state(int n) {
        this.logger.log(1000000, "[TelRequestOutbandRingtonePlaybackCmd#state] status=%1", (long)n);
    }
}

