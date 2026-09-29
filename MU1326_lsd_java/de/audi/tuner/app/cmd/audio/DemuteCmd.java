/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd$Builder;

public class DemuteCmd
extends AbstractAudioCmd {
    public DemuteCmd(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        super(abstractAudioCmd$Builder);
        this.setName("DemuteCmd");
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[DemuteCmd.execute] release user mute -> don't wait");
        this.audio.demute();
        this.commandFinished();
    }
}

