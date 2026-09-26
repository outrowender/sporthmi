/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd$Builder;

class RadioCmdManager$DefaultAudioCmd
extends AbstractAudioCmd {
    RadioCmdManager$DefaultAudioCmd(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        super(abstractAudioCmd$Builder);
    }

    @Override
    public void execute() {
        throw new IllegalStateException("Calling #execute() for default audio command no allowed!");
    }
}

