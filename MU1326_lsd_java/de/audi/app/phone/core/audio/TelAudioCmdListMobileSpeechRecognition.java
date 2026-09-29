/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelReleaseConnectionCmd;
import de.audi.app.phone.core.audio.TelRequestConnectionCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;

public class TelAudioCmdListMobileSpeechRecognition
extends CommandList {
    static final int[] requiredConnections = new int[]{136, 137};
    static final int[] connectionsToRelease = AbstractTelAudioCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelAudioCmdListMobileSpeechRecognition(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, boolean bl) {
        super(commandListManager);
        if (bl) {
            this.add(new TelRequestConnectionCmd(logChannel, 137, hMIAudioService, 0));
            this.add(new TelRequestConnectionCmd(logChannel, 136, hMIAudioService, 2));
        } else {
            this.add(new TelReleaseConnectionCmd(logChannel, 137, hMIAudioService));
            this.add(new TelReleaseConnectionCmd(logChannel, 136, hMIAudioService));
        }
    }
}

