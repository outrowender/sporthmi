/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;

public class WaitSDARSTunerReadyCmd
extends AbstractSDARSCmd {
    private int availability = 0;
    private int detectedDevice = 0;

    public WaitSDARSTunerReadyCmd(AbstractSDARSCmd.Builder builder) {
        super(builder);
        this.setName("WaitSDARSTunerReadyCmd");
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[WaitSDARSTunerReadyCmd.execute] set notifications");
        this.sdarsTuner.setNotification(new int[]{12, 26, 9});
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void updateDetectedDevice(int n) {
        this.logger.log(10000000, "[WaitSDARSTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        this.detectedDevice = n;
        if (n == 1) {
            this.commandList.stop("No SDARS-Tuner found! Detected Device = " + n);
        } else {
            this.checkFinished();
        }
    }

    public void updateAvailability(int n) {
        this.logger.log(10000000, "[WaitSDARSTunerReadyCmd.updateAvailability] availability:%1", (long)n);
        super.updateAvailability(n);
        this.availability = n;
        this.checkFinished();
    }

    private void checkFinished() {
        if (this.detectedDevice == 3 && this.availability == 2) {
            this.commandFinished();
        }
    }
}

