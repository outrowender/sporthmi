/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd$Builder;

public class WaitUniTunerReadyCmd
extends AbstractUnifiedCmd {
    public WaitUniTunerReadyCmd(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        super(abstractUnifiedCmd$Builder);
        this.setName("WaitUniTunerReadyCmd");
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(-2137614336, "[WaitUniTunerReadyCmd.execute] set notifications");
        this.unifiedTuner.setNotification(new int[]{1});
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.logger.log(-2137614336, "[WaitUniTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        if (n == 1) {
            this.commandList.stop(new StringBuffer().append("No Uni-Tuner found! Detected Device = ").append(n).toString());
        } else if (n == 3) {
            this.commandFinished();
        }
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }
}

