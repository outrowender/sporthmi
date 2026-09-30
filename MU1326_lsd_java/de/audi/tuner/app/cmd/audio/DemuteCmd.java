/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;

public class DemuteCmd
extends AbstractAudioCmd {
    public DemuteCmd(AbstractAudioCmd.Builder builder) {
        super(builder);
        this.setName("DemuteCmd");
    }

    public void execute() {
        this.logger.log(10000000, "[DemuteCmd.execute] release user mute -> don't wait");
        this.audio.demute();
        this.commandFinished();
    }
}

