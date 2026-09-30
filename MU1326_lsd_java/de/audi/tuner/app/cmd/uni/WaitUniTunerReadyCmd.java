/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;

public class WaitUniTunerReadyCmd
extends AbstractUnifiedCmd {
    public WaitUniTunerReadyCmd(AbstractUnifiedCmd.Builder builder) {
        super(builder);
        this.setName("WaitUniTunerReadyCmd");
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[WaitUniTunerReadyCmd.execute] set notifications");
        this.unifiedTuner.setNotification(new int[]{1});
    }

    public void updateDetectedDevice(int n) {
        this.logger.log(10000000, "[WaitUniTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        if (n == 1) {
            this.commandList.stop("No Uni-Tuner found! Detected Device = " + n);
        } else if (n == 3) {
            this.commandFinished();
        }
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }
}

