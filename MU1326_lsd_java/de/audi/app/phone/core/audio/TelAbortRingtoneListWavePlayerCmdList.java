/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelAbortOutbandRingtonePlaybackCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class TelAbortRingtoneListWavePlayerCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[0];
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelAbortRingtoneListWavePlayerCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer) {
        super(commandListManager, logChannel, hMIAudioService);
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelAbortOutbandRingtonePlaybackCmd(logChannel, hMIAudioService, ringTonePlayer));
    }
}

