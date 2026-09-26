/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;

public class TelRequestMediaRingtonePlaybackCmd
extends AbstractTelAudioCmd {
    private final IMediaFilePlayerService mediaService;
    private final IMediaFilePlayerSession mediaSession;

    TelRequestMediaRingtonePlaybackCmd(LogChannel logChannel, HMIAudioService hMIAudioService, IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession) {
        super(logChannel, "TelRequestMediaRingtonePlaybackCmd", hMIAudioService);
        this.mediaService = iMediaFilePlayerService;
        this.mediaSession = iMediaFilePlayerSession;
    }

    @Override
    public void execute() {
        if (this.mediaService != null) {
            if (this.mediaSession != null) {
                this.logger.log(1078071040, "[TelRequestMediaRingtonePlaybackCmd#execute] opening session.");
                this.mediaService.open(this.mediaSession);
                this.getCommandList().commandFinished();
            } else {
                this.logger.log(-1601830656, "[TelRequestMediaRingtonePlaybackCmd#execute] session is null --> NOP!");
                this.getCommandList().commandFinished();
            }
        } else {
            this.logger.log(-1601830656, "[TelRequestMediaRingtonePlaybackCmd#execute] media service is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }
}

