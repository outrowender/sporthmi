/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;

public class WaitDABTunerReadyCmd
extends AbstractDABCmd {
    private int availability;
    private int detectedDevice = 0;

    public WaitDABTunerReadyCmd(boolean bl, AbstractDABCmd.Builder builder) {
        super(builder);
        this.availability = bl ? 0 : 2;
        this.setName("WaitDABTunerReadyCmd");
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[WaitDABTunerReadyCmd.execute] set notifications");
        this.dabTuner.setNotification(new int[]{21, 27});
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void updateDetectedDevice(int n) {
        this.logger.log(10000000, "[WaitDABTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        this.detectedDevice = n;
        if (n == 1) {
            this.commandList.stop("No DAB-Tuner found! Detected Device = " + n);
        } else {
            this.checkFinished();
        }
    }

    public void updateAvailability(int n) {
        this.logger.log(10000000, "[WaitDABTunerReadyCmd.updateAvailability] availability:%1", (long)n);
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

