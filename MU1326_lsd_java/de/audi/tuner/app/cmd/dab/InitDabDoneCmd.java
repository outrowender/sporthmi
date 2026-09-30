/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;

public class InitDabDoneCmd
extends AbstractDABCmd {
    public InitDabDoneCmd(AbstractDABCmd.Builder builder) {
        super(builder);
        this.setName("InitDabDoneCmd()");
    }

    public void execute() {
        this.logger.log(10000000, "[InitDabDoneCmd.execute]");
        this.dabTuner.setInitDone();
        this.commandFinished();
    }
}

