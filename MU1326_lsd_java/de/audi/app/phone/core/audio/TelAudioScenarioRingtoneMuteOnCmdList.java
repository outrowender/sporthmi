/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelReleaseConnectionCmd;
import de.audi.app.phone.core.audio.TelUpdateRingtoneMuteStateCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;

public class TelAudioScenarioRingtoneMuteOnCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[0];
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelAudioScenarioRingtoneMuteOnCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, ITelApplication iTelApplication) {
        super(commandListManager, logChannel, hMIAudioService);
        this.addReleaseConnectionCommands(connectionsToRelease);
        this.add(new TelReleaseConnectionCmd(logChannel, 100, hMIAudioService));
        this.add(new TelUpdateRingtoneMuteStateCmd(logChannel, hMIAudioService, true, iTelApplication));
    }
}

