/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmdList;
import de.audi.app.phone.core.audio.TelRequestConnectionCmd;
import de.audi.app.phone.core.audio.TelRequestWidebandSpeechCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;

public class TelAudioWidebandSpeechCmdList
extends AbstractTelAudioCmdList {
    static final int[] requiredConnections = new int[]{100, 102};
    static final int[] connectionsToRelease = TelAudioWidebandSpeechCmdList.getAudioConnectionsToRelease(requiredConnections);

    public TelAudioWidebandSpeechCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService, DSISound dSISound, boolean bl, boolean bl2, DSISoundListener dSISoundListener) {
        super(commandListManager, logChannel, hMIAudioService);
        if (!bl2) {
            this.add(new TelRequestConnectionCmd(logChannel, 100, hMIAudioService, 0));
            this.add(new TelRequestConnectionCmd(logChannel, 102, hMIAudioService, 0));
            this.addReleaseConnectionCommands(connectionsToRelease);
        }
        this.add(new TelRequestWidebandSpeechCmd(logChannel, dSISound, hMIAudioService, bl, dSISoundListener));
    }
}

