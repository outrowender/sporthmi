/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.cmd.dab.AbstractDABCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class SwitchDABUsageCmd
extends AbstractDABCmd {
    private boolean enable;

    public SwitchDABUsageCmd(boolean bl, AbstractDABCmd$Builder abstractDABCmd$Builder) {
        super(abstractDABCmd$Builder);
        this.enable = bl;
        this.setName(new Buffer().append("SwitchDABUsageCmd(").append(bl).append(')').toString());
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SwitchDABUsageCmd.execute] enable:%1", this.enable);
        this.dabTuner.setComponentUsage(this.enable);
        this.commandFinished();
    }
}

