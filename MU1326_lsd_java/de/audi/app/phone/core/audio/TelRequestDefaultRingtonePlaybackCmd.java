/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class TelRequestDefaultRingtonePlaybackCmd
extends AbstractTelAudioCmd {
    private final RingTonePlayer ringtonePlayer;

    TelRequestDefaultRingtonePlaybackCmd(LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer) {
        super(logChannel, "TelRequestDefaultRingtonePlaybackCmd", hMIAudioService);
        if (ringTonePlayer == null) {
            throw new IllegalArgumentException("TelRequestOutbandRingtonePlaybackCmd#init: ringtonePlayer is null");
        }
        this.ringtonePlayer = ringTonePlayer;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelRequestDefaultRingtonePlaybackCmd#execute] playing default ringtone");
        this.ringtonePlayer.playDefault(1);
        this.getCommandList().commandFinished();
    }

    @Override
    public void state(int n) {
        this.logger.log(1078071040, "[TelRequestDefaultRingtonePlaybackCmd#state] status=%1", (long)n);
    }
}

