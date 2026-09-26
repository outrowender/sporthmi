/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class HighlightAMFMStationCmd
extends AbstractAMFMCmd {
    private final AMFMStation station;
    private final boolean manualTune;
    private final int terminal;

    public HighlightAMFMStationCmd(AMFMStation aMFMStation, boolean bl, int n, AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
        this.station = aMFMStation;
        this.manualTune = bl;
        this.terminal = n;
        Buffer buffer = new Buffer(100).append("HighlightAMFMStationCmd(").append(aMFMStation.name).append(',').append(aMFMStation.frequency).append(',').append(bl).append(')');
        this.setName(buffer);
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(-2137614336, "[HighlightAMFMStationCmd.execute] : :%1", (Object)this.station);
        this.tuner.tuneStation(this.station, this.manualTune, true, this.terminal);
        this.commandFinished();
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }
}

