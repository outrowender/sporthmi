/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.esolutions.fw.util.commons.Buffer;

public class HighlightAMFMStationCmd
extends AbstractAMFMCmd {
    private final AMFMStation station;
    private final boolean manualTune;
    private final int terminal;

    public HighlightAMFMStationCmd(AMFMStation aMFMStation, boolean bl, int n, AbstractAMFMCmd.Builder builder) {
        super(builder);
        this.station = aMFMStation;
        this.manualTune = bl;
        this.terminal = n;
        Buffer buffer = new Buffer(100).append("HighlightAMFMStationCmd(").append(aMFMStation.name).append(',').append(aMFMStation.frequency).append(',').append(bl).append(')');
        this.setName(buffer);
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[HighlightAMFMStationCmd.execute] : :%1", (Object)this.station);
        this.tuner.tuneStation(this.station, this.manualTune, true, this.terminal);
        this.commandFinished();
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }
}

