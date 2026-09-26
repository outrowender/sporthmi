/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelRequestConnectionCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;

public class TelAudioScenarioHFPHandsfreeMuteCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[]{100, 102, 104};
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelAudioScenarioHFPHandsfreeMuteCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService) {
        super(commandListManager, logChannel, hMIAudioService);
        this.add(new TelRequestConnectionCmd(logChannel, 100, hMIAudioService, 0));
        this.add(new TelRequestConnectionCmd(logChannel, 102, hMIAudioService, 0));
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelRequestConnectionCmd(logChannel, 104, hMIAudioService, 0));
    }
}

