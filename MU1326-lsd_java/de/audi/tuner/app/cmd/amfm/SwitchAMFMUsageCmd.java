/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class SwitchAMFMUsageCmd
extends AbstractAMFMCmd {
    private boolean enable;

    public SwitchAMFMUsageCmd(boolean bl, AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
        this.enable = bl;
        this.setName(new Buffer().append("SwitchAMFMUsageCmd(").append(bl).append(')').toString());
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SwitchAMFMUsageCmd.execute] enable:%1", this.enable);
        this.tuner.setComponentUsage(this.enable);
        this.commandFinished();
    }
}

