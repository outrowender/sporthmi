/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.esolutions.fw.util.commons.Buffer;

public class SwitchAMFMUsageCmd
extends AbstractAMFMCmd {
    private boolean enable;

    public SwitchAMFMUsageCmd(boolean bl, AbstractAMFMCmd.Builder builder) {
        super(builder);
        this.enable = bl;
        this.setName(new Buffer().append("SwitchAMFMUsageCmd(").append(bl).append(')').toString());
    }

    public void execute() {
        this.logger.log(10000000, "[SwitchAMFMUsageCmd.execute] enable:%1", this.enable);
        this.tuner.setComponentUsage(this.enable);
        this.commandFinished();
    }
}

