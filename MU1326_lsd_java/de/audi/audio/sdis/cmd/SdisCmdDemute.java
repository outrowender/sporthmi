/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.audio.HMIAudioService;
import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;

public class SdisCmdDemute
extends Command {
    private final HMIAudioService audioService;

    public SdisCmdDemute(AudioEnv audioEnv, HMIAudioService hMIAudioService) {
        super(audioEnv.lcSDIS);
        this.audioService = hMIAudioService;
        this.setName("SdisCmdDemute");
    }

    public void execute() {
        this.audioService.releaseConnection(8, 0);
        this.commandList.commandFinished();
    }
}

