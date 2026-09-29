/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.cmd.dab.AbstractDABCmd$Builder;

public class InitDabDoneCmd
extends AbstractDABCmd {
    public InitDabDoneCmd(AbstractDABCmd$Builder abstractDABCmd$Builder) {
        super(abstractDABCmd$Builder);
        this.setName("InitDabDoneCmd()");
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[InitDabDoneCmd.execute]");
        this.dabTuner.setInitDone();
        this.commandFinished();
    }
}

