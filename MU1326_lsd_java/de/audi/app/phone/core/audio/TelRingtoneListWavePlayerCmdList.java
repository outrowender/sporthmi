/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelRequestConnectionCmd;
import de.audi.app.phone.core.audio.TelRequestOutbandRingtonePlaybackCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class TelRingtoneListWavePlayerCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[]{87};
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelRingtoneListWavePlayerCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, RingTonePlayer ringTonePlayer, int n) {
        super(commandListManager, logChannel, hMIAudioService);
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelRequestConnectionCmd(logChannel, 87, hMIAudioService, 2));
        this.add(new TelRequestOutbandRingtonePlaybackCmd(logChannel, hMIAudioService, ringTonePlayer, n));
    }
}

