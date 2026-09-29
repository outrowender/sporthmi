/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd$Builder;

public class WaitAMAvailableCmd
extends AbstractAudioCmd {
    private final int timeout;

    public WaitAMAvailableCmd(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        super(abstractAudioCmd$Builder);
        this.timeout = -1;
        this.setName("WaitAMAvailableCmd");
    }

    public WaitAMAvailableCmd(AbstractAudioCmd$Builder abstractAudioCmd$Builder, int n) {
        super(abstractAudioCmd$Builder);
        this.timeout = n;
        this.setName("WaitAMAvailableCmd");
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        boolean bl = this.audio.isAMAvailable();
        this.logger.log(-2137614336, "[WaitAMAvailable.execute] available:%1", bl);
        if (bl) {
            this.commandFinished();
        }
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.logger.log(-2137614336, "[WaitAMAvailable.updateAMAvailable] available:%1", bl);
        super.updateAMAvailable(bl);
        if (bl) {
            this.commandFinished();
        }
    }

    @Override
    public long getTimeout() {
        if (this.timeout == -1) {
            return super.getTimeout();
        }
        return this.timeout;
    }
}

