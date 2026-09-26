/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class TuneAMFMStationCmd
extends AbstractAMFMCmd {
    private final AMFMStation station;
    private final boolean manualTune;
    private final boolean block;
    private final int terminal;

    public TuneAMFMStationCmd(AMFMStation aMFMStation, boolean bl, boolean bl2, int n, AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
        this.station = aMFMStation;
        this.manualTune = bl;
        this.block = bl2;
        this.terminal = n;
        Buffer buffer = new Buffer(100).append("TuneAMFMStationCmd(").append(aMFMStation.name).append(',').append(aMFMStation.frequency).append(',').append(bl).append(',').append(bl2).append(')');
        this.setName(buffer);
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(-2137614336, "[TuneAMFMStationCmd.execute] Tune station: %2 block:%1", this.block, (Object)this.station);
        this.tuner.tuneStation(this.station, this.manualTune, false, this.terminal);
        if (!this.block) {
            this.commandFinished();
        }
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    @Override
    public void selectStationStatus(int n) {
        this.logger.log(-2137614336, "[TuneAMFMStationCmd.selectStationStatus] status:%1", (long)n);
        super.selectStationStatus(n);
        if (n != 1) {
            this.commandFinished();
        }
    }
}

