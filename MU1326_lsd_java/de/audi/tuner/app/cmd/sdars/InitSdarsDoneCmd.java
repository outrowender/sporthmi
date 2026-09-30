/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;

public class InitSdarsDoneCmd
extends AbstractSDARSCmd {
    public InitSdarsDoneCmd(AbstractSDARSCmd.Builder builder) {
        super(builder);
        this.setName("InitSdarsDoneCmd()");
    }

    public void execute() {
        this.logger.log(10000000, "[InitSdarsDoneCmd.execute]");
        this.sdarsTuner.setInitDone();
        this.commandFinished();
    }
}

