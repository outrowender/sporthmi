/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.AbstractEcallAudioCmdList;
import de.audi.app.ecall.core.audio.cmd.EcallReleaseConnectionCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandListManager;

class EcallReleaseAllConnectionsCmdList
extends AbstractEcallAudioCmdList {
    private static final int[] CONNECTIONS_TO_RELEASE = new int[]{226, 227, 228, 225, 213, 210};

    EcallReleaseAllConnectionsCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService) {
        super(commandListManager, hMIAudioService, logChannel);
        this.addReleaseConnectionCommands(CONNECTIONS_TO_RELEASE);
    }

    private void addReleaseConnectionCommands(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.add(new EcallReleaseConnectionCmd(this.log, nArray[i2], this.audioService));
        }
    }

    void addToFirst(Command command) {
        this.add(0, command);
    }
}

