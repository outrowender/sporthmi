/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;

public class WaitAMFMTunerReadyCmd
extends AbstractAMFMCmd {
    private int availability;
    private final boolean hdTuner;
    private int detectedDevice = 0;

    public WaitAMFMTunerReadyCmd(boolean bl, boolean bl2, AbstractAMFMCmd.Builder builder) {
        super(builder);
        this.availability = bl ? 0 : 2;
        this.hdTuner = bl2;
        this.setName("WaitAMFMTunerReadyCmd");
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[WaitAMFMTunerReadyCmd.execute] set notifications");
        this.tuner.setNotification(new int[]{10, 18});
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void updateDetectedDevice(int n) {
        this.logger.log(10000000, "[WaitAMFMTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        this.detectedDevice = n;
        this.checkFinished();
    }

    public void updateAvailability(int n) {
        this.logger.log(10000000, "[WaitAMFMTunerReadyCmd.updateAvailability] availability:%1", (long)n);
        super.updateAvailability(n);
        this.availability = n;
        this.checkFinished();
    }

    private void checkFinished() {
        if ((this.detectedDevice == 4 || !this.hdTuner && this.detectedDevice == 3) && this.availability == 2) {
            this.commandFinished();
        }
    }
}

