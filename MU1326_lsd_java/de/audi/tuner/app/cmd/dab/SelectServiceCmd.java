/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.dab.DabStation;
import de.esolutions.fw.util.commons.Buffer;

public class SelectServiceCmd
extends AbstractDABCmd {
    private final int selectServiceMode;
    private final DabStation station;
    private final boolean block;
    private final int terminal;

    public SelectServiceCmd(int n, DabStation dabStation, boolean bl, int n2, AbstractDABCmd.Builder builder) {
        super(builder);
        this.selectServiceMode = n;
        this.station = dabStation;
        this.block = bl;
        this.terminal = n2;
        Buffer buffer = new Buffer().append("SelectServiceCmd(").append(n).append(',').append(dabStation.service.sID).append(',').append(dabStation.service.ensID).append(',').append(dabStation.service.ensECC).append(',').append(dabStation.component.sCIDI).append(',').append(bl).append(')');
        this.setName(buffer);
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[SelectServiceCmd.execute] mode:%2 station:%1 ", (Object)this.station, (long)this.selectServiceMode);
        this.dabTuner.selectStation(this.station, this.selectServiceMode, this.terminal);
        if (!this.block) {
            this.commandFinished();
        }
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void selectServiceStatus(int n) {
        this.logger.log(10000000, "[SelectServiceCmd.selectServiceStatus] status:%1", (long)n);
        super.selectServiceStatus(n);
        if (n != 1) {
            this.commandFinished();
        }
    }
}

