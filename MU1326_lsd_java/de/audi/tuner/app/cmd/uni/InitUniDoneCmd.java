/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;

public class InitUniDoneCmd
extends AbstractUnifiedCmd {
    public InitUniDoneCmd(AbstractUnifiedCmd.Builder builder) {
        super(builder);
        this.setName("InitUniDoneCmd()");
    }

    public void execute() {
        this.logger.log(10000000, "[InitUniDoneCmd.execute]");
        this.unifiedTuner.setInitDone();
        this.commandFinished();
    }
}

