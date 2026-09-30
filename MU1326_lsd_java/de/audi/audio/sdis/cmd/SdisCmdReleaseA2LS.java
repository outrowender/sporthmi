/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.audio.HMIAudioService;
import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;

public class SdisCmdReleaseA2LS
extends Command {
    private final HMIAudioService audioService;

    public SdisCmdReleaseA2LS(AudioEnv audioEnv, HMIAudioService hMIAudioService) {
        super(audioEnv.lcSDIS);
        this.audioService = hMIAudioService;
        this.setName("SdisCmdReleaseA2LS");
    }

    public void execute() {
        this.audioService.releaseConnection(308, 0);
        this.commandList.commandFinished();
    }
}

