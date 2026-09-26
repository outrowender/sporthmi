/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;

public class SeekAbortCmd
extends AbstractAMFMCmd {
    public SeekAbortCmd(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
    }

    @Override
    public void execute() {
        if (this.tuner.isSeekActive()) {
            this.tuner.seekStation(3, -2);
        } else {
            this.commandFinished();
        }
    }

    @Override
    public void seekStationStatus(int n) {
        super.seekStationStatus(n);
        if (n == 3 || n == 2) {
            this.commandFinished();
        }
    }
}

