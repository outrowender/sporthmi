/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelAbortMediaRingtonePlaybackCmd;
import de.audi.app.phone.core.audio.TelRequestConnectionCmd;
import de.audi.app.phone.core.audio.TelRequestDefaultRingtonePlaybackCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.media.IMediaFilePlayerSession;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class TelRingingDefaultRingtoneFallbackCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[]{100, 98};
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelRingingDefaultRingtoneFallbackCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer, IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession) {
        super(commandListManager, logChannel, hMIAudioService);
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelRequestConnectionCmd(logChannel, 100, hMIAudioService, 0));
        this.add(new TelAbortMediaRingtonePlaybackCmd(logChannel, hMIAudioService, iMediaFilePlayerService, iMediaFilePlayerSession));
        this.add(new TelRequestConnectionCmd(logChannel, 98, hMIAudioService, 2));
        this.add(new TelRequestDefaultRingtonePlaybackCmd(logChannel, hMIAudioService, ringTonePlayer));
    }

    public TelRingingDefaultRingtoneFallbackCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer) {
        super(commandListManager, logChannel, hMIAudioService);
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelRequestConnectionCmd(logChannel, 100, hMIAudioService, 0));
        this.add(new TelRequestConnectionCmd(logChannel, 98, hMIAudioService, 2));
        this.add(new TelRequestDefaultRingtonePlaybackCmd(logChannel, hMIAudioService, ringTonePlayer));
    }
}

