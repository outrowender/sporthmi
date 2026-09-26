/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.audi.tghu.command.Command;

public abstract class AbstractSdisCmdSendUpdate
extends Command {
    protected final SdisAudioListener sdisAudioListener;

    protected AbstractSdisCmdSendUpdate(AudioEnv audioEnv, SdisAudioListener sdisAudioListener) {
        super(audioEnv.lcSDIS);
        this.sdisAudioListener = sdisAudioListener;
    }

    @Override
    public abstract void execute() {
    }
}

