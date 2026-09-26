/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class TelAbortOutbandRingtonePlaybackCmd
extends AbstractTelAudioCmd {
    private final RingTonePlayer ringTonePlayer;

    TelAbortOutbandRingtonePlaybackCmd(LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer) {
        super(logChannel, "TelAbortOutbandRingtonePlaybackCmd", hMIAudioService);
        this.ringTonePlayer = ringTonePlayer;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[TelAbortOutbandRingtonePlaybackCmd#execute] aborting playback.");
        this.ringTonePlayer.abort();
        this.getCommandList().commandFinished();
    }
}

