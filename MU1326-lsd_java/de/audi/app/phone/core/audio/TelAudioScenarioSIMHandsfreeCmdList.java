/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelRequestConnectionCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;

public class TelAudioScenarioSIMHandsfreeCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[]{100, 99};
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelAudioScenarioSIMHandsfreeCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService) {
        super(commandListManager, logChannel, hMIAudioService);
        this.add(new TelRequestConnectionCmd(logChannel, 100, hMIAudioService, 0));
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelRequestConnectionCmd(logChannel, 99, hMIAudioService, 2));
    }
}

