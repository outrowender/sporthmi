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
        super(logChannel, new StringBuffer().append("TelRequestOutbandRingtonePlaybackCmd: ringtoneID=").append(n).toString(), hMIAudioService);
        if (ringTonePlayer == null) {
            throw new IllegalArgumentException("TelRequestOutbandRingtonePlaybackCmd#init: ringtonePlayer is null");
        }
        this.ringtonePlayer = ringTonePlayer;
        this.ringtoneID = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelRequestOutbandRingtonePlaybackCmd#execute] playing ringtoneID=%1", (long)this.ringtoneID);
        this.ringtonePlayer.playTone(1, this.ringtoneID);
        this.getCommandList().commandFinished();
    }

    @Override
    public void state(int n) {
        this.logger.log(1078071040, "[TelRequestOutbandRingtonePlaybackCmd#state] status=%1", (long)n);
    }
}

