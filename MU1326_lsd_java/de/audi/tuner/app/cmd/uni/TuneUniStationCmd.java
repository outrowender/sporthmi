/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.esolutions.fw.util.commons.Buffer;

public class TuneUniStationCmd
extends AbstractUnifiedCmd {
    private final UnifiedStationExt station;
    private final boolean block;
    private final int terminal;

    public TuneUniStationCmd(UnifiedStationExt unifiedStationExt, boolean bl, int n, AbstractUnifiedCmd.Builder builder) {
        super(builder);
        this.station = unifiedStationExt;
        this.block = bl;
        this.terminal = n;
        Buffer buffer = new Buffer().append("TuneUniStationCmd(").append(unifiedStationExt).append(',').append(bl).append(')');
        this.setName(buffer);
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[TuneUniStationCmd.execute] station:%1 ", (Object)this.station);
        this.unifiedTuner.selectStation(this.station, this.terminal);
        if (!this.block) {
            this.commandFinished();
        }
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void selectStationStatus(int n) {
        this.logger.log(10000000, "[TuneUniStationCmd.selectStationStatus] status:%1", (long)n);
        super.selectStationStatus(n);
        if (n != 1) {
            this.commandFinished();
        }
    }
}

