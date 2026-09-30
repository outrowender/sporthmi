/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.esolutions.fw.util.commons.Buffer;

public class SwitchUniUsageCmd
extends AbstractUnifiedCmd {
    private boolean enable;

    public SwitchUniUsageCmd(boolean bl, AbstractUnifiedCmd.Builder builder) {
        super(builder);
        this.enable = bl;
        this.setName(new Buffer().append("SwitchUniUsageCmd(").append(bl).append(')').toString());
    }

    public void execute() {
        this.logger.log(10000000, "[SwitchUniUsageCmd.execute] enable:%1", this.enable);
        this.unifiedTuner.setComponentUsage(this.enable);
        this.commandFinished();
    }
}

