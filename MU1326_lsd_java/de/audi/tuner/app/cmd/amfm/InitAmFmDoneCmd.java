/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;

public class InitAmFmDoneCmd
extends AbstractAMFMCmd {
    public InitAmFmDoneCmd(AbstractAMFMCmd.Builder builder) {
        super(builder);
        this.setName("InitAmFmDoneCmd()");
    }

    public void execute() {
        this.logger.log(10000000, "[InitAmFmDoneCmd.execute]");
        this.tuner.setInitDone();
        this.commandFinished();
    }
}

