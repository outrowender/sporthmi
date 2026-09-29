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

public class TelRingtoneListDefaultRingtoneFallbackCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[]{87};
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelRingtoneListDefaultRingtoneFallbackCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer, IMediaFilePlayerService iMediaFilePlayerService, IMediaFilePlayerSession iMediaFilePlayerSession) {
        super(commandListManager, logChannel, hMIAudioService);
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelAbortMediaRingtonePlaybackCmd(logChannel, hMIAudioService, iMediaFilePlayerService, iMediaFilePlayerSession));
        this.add(new TelRequestConnectionCmd(logChannel, 87, hMIAudioService, 2));
        this.add(new TelRequestDefaultRingtonePlaybackCmd(logChannel, hMIAudioService, ringTonePlayer));
    }

    public TelRingtoneListDefaultRingtoneFallbackCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer) {
        super(commandListManager, logChannel, hMIAudioService);
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelRequestConnectionCmd(logChannel, 87, hMIAudioService, 2));
        this.add(new TelRequestDefaultRingtonePlaybackCmd(logChannel, hMIAudioService, ringTonePlayer));
    }
}

