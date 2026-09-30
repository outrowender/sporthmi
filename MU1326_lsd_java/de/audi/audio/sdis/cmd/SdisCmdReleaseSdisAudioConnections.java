/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.audio.HMIAudioService;
import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;

public class SdisCmdReleaseSdisAudioConnections
extends Command {
    private final HMIAudioService hmiAudioService;
    private final int[] sdisAudioConnections;
    private static final int SDIS_TERMINAL = 2;

    public SdisCmdReleaseSdisAudioConnections(AudioEnv audioEnv, HMIAudioService hMIAudioService, int[] nArray) {
        super(audioEnv.lcMain, "SdisCmdReleaseSdisAudioConnections");
        this.hmiAudioService = hMIAudioService;
        this.sdisAudioConnections = nArray;
    }

    public void execute() {
        for (int i2 = 0; i2 < this.sdisAudioConnections.length; ++i2) {
            int n = this.sdisAudioConnections[i2];
            this.logger.log(10000000, "[SdisCmdReleaseSdisAudioConnections.execute] release connection:", (long)n);
            this.hmiAudioService.releaseConnection(n, 2);
        }
        this.getCommandList().commandFinished();
    }
}

