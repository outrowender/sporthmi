/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.audio.HMIAudioService;
import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;

public class SdisCmdRequestA2LS
extends Command {
    private final HMIAudioService audioService;

    public SdisCmdRequestA2LS(AudioEnv audioEnv, HMIAudioService hMIAudioService) {
        super(audioEnv.lcSDIS);
        this.audioService = hMIAudioService;
        this.setName("SdisCmdRequestA2LS");
    }

    public void execute() {
        this.audioService.requestAndFadeToConnection(308, 0);
        this.commandList.commandFinished();
    }
}

