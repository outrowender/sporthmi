/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;

public class InitAmFmDoneCmd
extends AbstractAMFMCmd {
    public InitAmFmDoneCmd(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
        this.setName("InitAmFmDoneCmd()");
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[InitAmFmDoneCmd.execute]");
        this.tuner.setInitDone();
        this.commandFinished();
    }
}

