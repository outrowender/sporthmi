/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd$Builder;

public class WaitSDARSTunerReadyCmd
extends AbstractSDARSCmd {
    private int availability = 0;
    private int detectedDevice = 0;

    public WaitSDARSTunerReadyCmd(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        super(abstractSDARSCmd$Builder);
        this.setName("WaitSDARSTunerReadyCmd");
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(-2137614336, "[WaitSDARSTunerReadyCmd.execute] set notifications");
        this.sdarsTuner.setNotification(new int[]{12, 26, 9});
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.logger.log(-2137614336, "[WaitSDARSTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        this.detectedDevice = n;
        if (n == 1) {
            this.commandList.stop(new StringBuffer().append("No SDARS-Tuner found! Detected Device = ").append(n).toString());
        } else {
            this.checkFinished();
        }
    }

    @Override
    public void updateAvailability(int n) {
        this.logger.log(-2137614336, "[WaitSDARSTunerReadyCmd.updateAvailability] availability:%1", (long)n);
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

