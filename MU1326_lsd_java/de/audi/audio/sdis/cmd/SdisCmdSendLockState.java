/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.cmd.AbstractSdisCmdSendUpdate;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;

public class SdisCmdSendLockState
extends AbstractSdisCmdSendUpdate {
    private VolumeLockState volumeLockState;
    private SdisAudioListener sdisAudioListener;

    public SdisCmdSendLockState(AudioEnv audioEnv, VolumeLockState volumeLockState, SdisAudioListener sdisAudioListener) {
        super(audioEnv, sdisAudioListener);
        this.volumeLockState = volumeLockState;
        this.sdisAudioListener = sdisAudioListener;
    }

    @Override
    public void execute() {
        int n = this.volumeLockState.getState();
        int n2 = this.volumeLockState.getAudioContext();
        this.logger.log(1078071040, "[SdisCmdSendLockState.execute] lockState: %1, audioContext: %2", (long)n, (long)n2);
        this.sdisAudioListener.updateVolumeLockState(this.volumeLockState);
        this.commandList.commandFinished();
    }
}

