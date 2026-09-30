/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;

public class WaitAMAvailableCmd
extends AbstractAudioCmd {
    private final int timeout;

    public WaitAMAvailableCmd(AbstractAudioCmd.Builder builder) {
        super(builder);
        this.timeout = -1;
        this.setName("WaitAMAvailableCmd");
    }

    public WaitAMAvailableCmd(AbstractAudioCmd.Builder builder, int n) {
        super(builder);
        this.timeout = n;
        this.setName("WaitAMAvailableCmd");
    }

    public void execute() {
        this.logExecuteFirstCmd();
        boolean bl = this.audio.isAMAvailable();
        this.logger.log(10000000, "[WaitAMAvailable.execute] available:%1", bl);
        if (bl) {
            this.commandFinished();
        }
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void updateAMAvailable(boolean bl) {
        this.logger.log(10000000, "[WaitAMAvailable.updateAMAvailable] available:%1", bl);
        super.updateAMAvailable(bl);
        if (bl) {
            this.commandFinished();
        }
    }

    public long getTimeout() {
        if (this.timeout == -1) {
            return super.getTimeout();
        }
        return this.timeout;
    }
}

