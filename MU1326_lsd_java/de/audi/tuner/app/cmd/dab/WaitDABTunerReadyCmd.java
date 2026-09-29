/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.cmd.dab.AbstractDABCmd$Builder;

public class WaitDABTunerReadyCmd
extends AbstractDABCmd {
    private int availability;
    private int detectedDevice = 0;

    public WaitDABTunerReadyCmd(boolean bl, AbstractDABCmd$Builder abstractDABCmd$Builder) {
        super(abstractDABCmd$Builder);
        this.availability = bl ? 0 : 2;
        this.setName("WaitDABTunerReadyCmd");
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(-2137614336, "[WaitDABTunerReadyCmd.execute] set notifications");
        this.dabTuner.setNotification(new int[]{21, 27});
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.logger.log(-2137614336, "[WaitDABTunerReadyCmd.updateDetectedDevice] detectedDevice:%1", (long)n);
        super.updateDetectedDevice(n);
        this.detectedDevice = n;
        if (n == 1) {
            this.commandList.stop(new StringBuffer().append("No DAB-Tuner found! Detected Device = ").append(n).toString());
        } else {
            this.checkFinished();
        }
    }

    @Override
    public void updateAvailability(int n) {
        this.logger.log(-2137614336, "[WaitDABTunerReadyCmd.updateAvailability] availability:%1", (long)n);
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

