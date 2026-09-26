/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;

public class WaitAMFMTunerReadyCmd
extends AbstractAMFMCmd {
    private int availability;
    private final boolean hdTuner;
    private int detectedDevice = 0;

    public WaitAMFMTunerReadyCmd(boolean bl, boolean bl2, AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
        this.availability = bl ? 0 : 2;
        this.hdTuner = bl2;
        this.setName("WaitAMFMTunerReadyCmd");
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(-2137614336, "[WaitAMFMTunerReadyCmd.execute] set notifications");
        this.tuner.setNotification(new int[]{10, 18});
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.logger.log(-2137614336, "[WaitAMFMTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        this.detectedDevice = n;
        this.checkFinished();
    }

    @Override
    public void updateAvailability(int n) {
        this.logger.log(-2137614336, "[WaitAMFMTunerReadyCmd.updateAvailability] availability:%1", (long)n);
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

