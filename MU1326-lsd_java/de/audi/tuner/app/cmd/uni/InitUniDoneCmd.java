/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd$Builder;

public class InitUniDoneCmd
extends AbstractUnifiedCmd {
    public InitUniDoneCmd(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        super(abstractUnifiedCmd$Builder);
        this.setName("InitUniDoneCmd()");
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[InitUniDoneCmd.execute]");
        this.unifiedTuner.setInitDone();
        this.commandFinished();
    }
}

