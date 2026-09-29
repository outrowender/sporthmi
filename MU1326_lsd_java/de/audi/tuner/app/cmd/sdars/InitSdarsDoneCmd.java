/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd$Builder;

public class InitSdarsDoneCmd
extends AbstractSDARSCmd {
    public InitSdarsDoneCmd(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        super(abstractSDARSCmd$Builder);
        this.setName("InitSdarsDoneCmd()");
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[InitSdarsDoneCmd.execute]");
        this.sdarsTuner.setInitDone();
        this.commandFinished();
    }
}

