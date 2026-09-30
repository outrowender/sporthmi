/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.SdisLabels;
import de.audi.audio.sdis.cmd.AbstractSdisCmdSendUpdate;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;

public class SdisCmdUpdateAudioContext
extends AbstractSdisCmdSendUpdate {
    private final AudioState audioState;
    private final String audioStateLabel;

    public SdisCmdUpdateAudioContext(AudioEnv audioEnv, SdisAudioListener sdisAudioListener, AudioState audioState) {
        super(audioEnv, sdisAudioListener);
        this.audioState = audioState;
        this.audioStateLabel = SdisLabels.getAudioState(audioState);
        this.setName("SdisCmdUpdateAudioContext: " + this.audioStateLabel);
    }

    public void execute() {
        this.logger.log(10000000, "-> [SdisCmdUpdateAudioContext.execute] %1", (Object)this.audioStateLabel);
        this.sdisAudioListener.updateAudioContext(this.audioState);
        this.commandList.commandFinished();
    }
}

